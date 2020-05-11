package com.sunsat.sathish.j2ee.imageconvertor.utility;

import com.sunsat.sathish.j2ee.imageconvertor.model.ImageDimensions;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.ImageCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Component
public class Utility {

    @Autowired
    ImageCommand convertorCmd;

    public String getImageEncodedString(String imagePath) {
        File f = new File(imagePath);
        String encodedSt = "";
        try(FileInputStream fos = new FileInputStream(f)) {
            encodedSt = Base64.getEncoder().encodeToString(fos.readAllBytes());
        }catch (IOException ioe) {

        }
        return encodedSt;
    }

    public byte[] getImageBytes(String encodedSt) {
        byte[] imageByteArray = Base64.getDecoder().decode(encodedSt);
        return imageByteArray;
    }

    public BufferedImage getBufferedImg(byte[] imageInByteArray) {
        InputStream in = new ByteArrayInputStream(imageInByteArray);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    public Boolean isFileExists(Path filePath) {
        return Files.exists(filePath);
    }

    public Boolean createFolder(Path filePath) {
        try {
            Files.createDirectories(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Boolean convertImage(ImageDimensions imageDimensions,BufferedImage sourceImg, String destinationPath) {
        IMOperation operation = new IMOperation();
        operation.addImage();
        operation.resize(imageDimensions.getWidth(),imageDimensions.getHeight());
        operation.addImage();
        try {
            convertorCmd.run(operation,sourceImg,destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (IM4JavaException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
