package com.vwr.em.migration.util;

import com.vwr.em.migration.dao.DocumentDao;
import org.apache.log4j.Logger;

import static com.vwr.em.migration.util.MigrationConstants.*;

import javax.naming.NamingException;
import java.io.*;
import java.util.Date;
import java.util.HashMap;

import javax.jcr.LoginException;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.naming.NamingException;

import org.apache.jackrabbit.rmi.repository.URLRemoteRepository;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.jcr.Binary;
import javax.jcr.ItemNotFoundException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.naming.NamingException;
import org.apache.jackrabbit.JcrConstants;




/**
 * Created by sathishkumar_su on 7/13/2018.
 */
public class JCRFileUtil {

    private static JCRFileUtil instance = null;
    private static Logger logger = Logger.getLogger("FILE");

    private static Session jcrSession;

    private static HashMap<String,String> map = new HashMap<String,String>();

    private JCRFileUtil() {
        init();
    }

    private void init() {
        logger.info("Entering JCRFileUtil Init method");
        loadMap();
        try {
            Repository repo = new URLRemoteRepository(PropertyUtil.getProperty(MIGRATION_JCR_URL));
            jcrSession =  repo.login(new SimpleCredentials(PropertyUtil.getProperty(MIGRATION_JCR_USERNAME), PropertyUtil.getProperty(MIGRATION_JCR_PASSWORD).toCharArray()));
        } catch (LoginException e) {
            logger.error("JCRInit Failled by Loging Exception: ", e);
        } catch (RepositoryException e) {
            logger.error("JCRInit Failled by Repository Exception :", e);
        } catch (Exception e) {
            logger.error("JCRInit Failled by general Exception : ", e);
        }
        logger.info("Exited JCRFileUtil Init method");
    }

    private void loadMap() {
        map.put(".aac","audio/aac");
        map.put(".abw","application/x-abiword");
        map.put(".arc","application/octet-stream");
        map.put(".avi","video/x-msvideo");
        map.put(".azw","application/vnd.amazon.ebook");
        map.put(".bin","application/octet-stream");
        map.put(".bmp","image/bmp");
        map.put(".bz","application/x-bzip");
        map.put(".bz2","application/x-bzip2");
        map.put(".csh","application/x-csh");
        map.put(".css","text/css");
        map.put(".csv","text/csv");
        map.put(".doc","application/msword");
        map.put(".docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        map.put(".eot","application/vnd.ms-fontobject");
        map.put(".epub","application/epub+zip");
        map.put(".es","application/ecmascript");
        map.put(".gif","image/gif");
        map.put(".htm","text/html");
        map.put(".html","text/html");
        map.put(".ico","image/x-icon");
        map.put(".ics","text/calendar");
        map.put(".jar","application/java-archive");
        map.put(".jpeg","image/jpeg");
        map.put(".jpg","image/jpeg");
        map.put(".js","application/javascript");
        map.put(".json","application/json");
        map.put(".mpeg","video/mpeg");
        map.put(".pdf","application/pdf");
        map.put(".ppt","application/vnd.ms-powerpoint");
        map.put(".pptx","application/vnd.openxmlformats-officedocument.presentationml.presentation");
        map.put(".rar","application/x-rar-compressed");
        map.put(".rtf","application/rtf");
        map.put(".sh","application/x-sh");
        map.put(".svg","image/svg+xml");
        map.put(".swf","application/x-shockwave-flash");
        map.put(".tar","application/x-tar");
        map.put(".ts","application/typescript");
        map.put(".ttf","font/ttf");
        map.put(".txt","text/plain");
        map.put(".vsd","application/vnd.visio");
        map.put(".wav","audio/wav");
        map.put(".weba","audio/webm");
        map.put(".webm","video/webm");
        map.put(".webp","image/webp");
        map.put(".woff","font/woff");
        map.put(".woff2","font/woff2");
        map.put(".xhtml","application/xhtml+xml");
        map.put(".xls","application/vnd.ms-excel");
        map.put(".xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        map.put(".xml","application/xml");
    }


    public static JCRFileUtil getInstance() {
        if (instance == null) {
            instance = new JCRFileUtil();
        }
        return instance;
    }

    public static Session getSession() throws RepositoryException,NamingException {
        return getInstance().jcrSession;
    }

    public static boolean downloadFile(String uniqueId, DocumentDao documentObj, String downloadPath) {
        Session jcrSession = null;
        Node fileNode;
        try {
            jcrSession = getSession();
            fileNode = jcrSession.getNodeByIdentifier(uniqueId);
            Node jcrContent = fileNode.getNode("jcr:content");
            String mimeType = jcrContent.getProperty(JcrConstants.JCR_MIMETYPE).getName();
            InputStream stream = jcrContent.getProperty("jcr:data").getBinary().getStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length;
            try {
                while((length = stream.read(bytes)) != -1) {
                    baos.write(bytes, 0, length);
                }
                FileOutputStream outputStream = new FileOutputStream(downloadPath);
                // filename=\""+documentValue.getFileName().trim().replaceAll(" ","_").replaceAll(",","_")+ "\"");
                baos.writeTo(outputStream);
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                return false;
            }finally {
                try {
                    stream.close();
                } catch (IOException e) {
                    return false;
                }
            }
        } catch (RepositoryException e) {
            return false;
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return true;
    }


    public static DocumentDao saveFileNode(final InputStream inputStream,final String contentType,final String folderPath, final String fileName, DocumentDao documentCenterValue, boolean isThumb){
        try {
            Node rootNode = jcrSession.getRootNode();
            Node folderNode = createDocumentFolder(rootNode, "em/businessService");
            Node fileNode;
            String name = new Date().getTime()+"_"+fileName;
            if(folderNode.hasNode(name)){
                fileNode = folderNode.getNode(name);
                fileNode.remove();
                jcrSession.save();
            }else{
                fileNode = folderNode.addNode(name,JcrConstants.NT_FILE);
            }
            fileNode.addMixin(JcrConstants.MIX_VERSIONABLE);
            Node contentNode;
            if(fileNode.hasNode(JcrConstants.JCR_CONTENT)){
                contentNode = fileNode.getNode(JcrConstants.JCR_CONTENT);
            }else{
                contentNode = fileNode.addNode(JcrConstants.JCR_CONTENT, JcrConstants.NT_RESOURCE);
            }
            if(contentType != null || contentType.length() !=0 ){
                contentNode.setProperty(JcrConstants.JCR_MIMETYPE, getMimeType(contentType));
            }

            Binary binary = jcrSession.getValueFactory().createBinary(inputStream);
            contentNode.setProperty(JcrConstants.JCR_DATA, binary);
            jcrSession.save();
            //if(isThumb){
                //documentCenterValue.setThumbImageUniqueid(fileNode.getIdentifier());
            //}else{
                documentCenterValue.setDocumentUniquId(fileNode.getIdentifier());
            //}
            logger.debug("File uploaded successfully, File name:" + name + ", Unique id:" + documentCenterValue.getDocumentUniquId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return documentCenterValue;
    }

    private static Node createDocumentFolder(Node rootNode, String folderPath) throws RepositoryException{
        Node folderNode = rootNode;
        String[] folderArr = folderPath.split("/");
        for (String folderName : folderArr) {
            if(!folderNode.hasNode(folderName)){
               // Create a new folder node ...
               folderNode = folderNode.addNode(folderName, JcrConstants.NT_FOLDER);
            }else{
                folderNode = folderNode.getNode(folderName);
            }
        }
        return folderNode;
    }

    public static String getMimeType(String extension) {
        return map.get(extension);
    }

    public static Session getNewSession() {
        Repository repo = null;
        Session session = null;
        try {
            try {
                repo = new URLRemoteRepository(PropertyUtil.getProperty(MIGRATION_JCR_URL));
                session =  repo.login(new SimpleCredentials(PropertyUtil.getProperty(MIGRATION_JCR_USERNAME), PropertyUtil.getProperty(MIGRATION_JCR_PASSWORD).toCharArray()));
            } catch (LoginException e) {
                logger.error("JCRInit Failled by Loging Exception: ", e);
            } catch (RepositoryException e) {
                logger.error("JCRInit Failled by Repository Exception :", e);
            } catch (Exception e) {
                logger.error("JCRInit Failled by general Exception : ", e);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
}
