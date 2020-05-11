package com.sunsat.sathish.j2ee.imageconvertor.service;

import com.sunsat.sathish.j2ee.imageconvertor.model.ImageDimensions;
import com.sunsat.sathish.j2ee.imageconvertor.model.ImageMetadataModel;
import com.sunsat.sathish.j2ee.imageconvertor.model.ImageUploadeRequestModel;
import com.sunsat.sathish.j2ee.imageconvertor.utility.Utility;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.ImageCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ImageConvertorService {

    @Autowired
    Utility utility;

    @Autowired
    ImageMetadataModel imageMetadataModel;


    public void convertImage(ImageUploadeRequestModel model) {

        String encodedSt = utility.getImageEncodedString(model.getImage());

        //All this code can go to service layer
        byte[] imageInBytes = utility.getImageBytes(encodedSt);

        BufferedImage bufferedImage = utility.getBufferedImg(imageInBytes);

        Path filePath = Path.of(model.getPath());
        Boolean isExist = utility.isFileExists(filePath.getParent());

        if(!isExist) utility.createFolder(filePath.getParent());

        ImageDimensions thembnailViewDimeension = imageMetadataModel.getResize().get("thumbnail");
        ImageDimensions detailedViewDimeension = imageMetadataModel.getResize().get("detailed");

        utility.convertImage(detailedViewDimeension,bufferedImage,model.getPath());
        utility.convertImage(thembnailViewDimeension,bufferedImage,model.getPath()+"1");
    }
}
