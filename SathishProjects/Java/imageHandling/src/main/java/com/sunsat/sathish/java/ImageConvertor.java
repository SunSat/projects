package com.sunsat.sathish.java;

import org.apache.commons.io.IOUtils;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * Hello world!
 *
 */
public class ImageConvertor
{
    public static void main( String[] args )
    {
        System.getenv().forEach((key,value) -> System.out.println(key + " : " + value));
        System.out.println("---------");
        System.getProperties().forEach((key,value) -> System.out.println(key + " : " + value));

        String fromFile = "/Users/sathishkumar_su/personal/projects/SathishProjects/Java/imageHandling/target/classes/1.png";
        String toFile = "/Users/sathishkumar_su/personal/projects/SathishProjects/Java/imageHandling/target/classes/1_resize.png";
        ConvertCmd cmd = new ConvertCmd();
        IMOperation imgeOperation = new IMOperation();
        imgeOperation.addImage();
        imgeOperation.resize(574,574);
        imgeOperation.addImage();

        try {
            String encodeSt = getImageAsEncodedString("/Users/sathishkumar_su/personal/projects/SathishProjects/Java/imageHandling/target/classes/1.png");
            byte[] byteArr = getImageBytesFromEncodedSt(encodeSt);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArr);
            BufferedImage buffImge = ImageIO.read(inputStream);
            cmd.run(imgeOperation,buffImge,toFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IM4JavaException e) {
            e.printStackTrace();
        }

    }

    public static String getImageAsEncodedString(String imagePath) {
        File f = new File(imagePath);
        String encodedSt = "";
        try(FileInputStream fos = new FileInputStream(f)) {
            encodedSt = Base64.getEncoder().encodeToString(fos.readAllBytes());
        }catch (IOException ioe) {

        }
        return encodedSt;
    }

    public static byte[] getImageBytesFromEncodedSt(String encodedSt) {
        byte[] imageByteArray = Base64.getDecoder().decode(encodedSt);
        return imageByteArray;
    }
}
