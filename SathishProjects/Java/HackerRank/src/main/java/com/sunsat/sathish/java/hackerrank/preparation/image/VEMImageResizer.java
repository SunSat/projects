package com.sunsat.sathish.java.hackerrank.preparation.image;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class VEMImageResizer {

    public static void main(String[] args) {
        String fileName = "C:\\vem\\defects\\CAR-1875\\temp_images\\resize\\2.jpg";
        try {
            FileInputStream fis = new FileInputStream(new File("C:\\vem\\defects\\CAR-1875\\temp_images\\resize\\1.jpg"));
            resizeImage(fileName,fis,0.9f);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream resizeImage(String fileName, InputStream is, float quality)
            throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream(fileName);
        BufferedImage image = null;
        ImageWriter writer = null;
        ImageOutputStream ios = null;
        // get all image writers for JPG format
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        if (!writers.hasNext()) {
            throw new IllegalStateException("No writers found");
        }
        try {
            // create a BufferedImage as the result of decoding the supplied InputStream
            image = ImageIO.read(is);
            writer = (ImageWriter) writers.next();
            ios = ImageIO.createImageOutputStream(os);
            writer.setOutput(ios);
            ImageWriteParam param = writer.getDefaultWriteParam();
            // compress to a given quality
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(quality);
            /*
             *  appends a complete image stream containing a single image and associated stream and image metadata and thumbnails to the output
             */
            writer.write(null, new IIOImage(image, null, null), param);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            is.close();
            os.close();
            ios.close();
            writer.dispose();
        }
        return new FileInputStream(fileName);
    }
}
