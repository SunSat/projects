package com.sunsat.sathish.j2ee.imageconvertor.controller;

import com.sunsat.sathish.j2ee.imageconvertor.model.Greeting;
import com.sunsat.sathish.j2ee.imageconvertor.model.ImageDimensions;
import com.sunsat.sathish.j2ee.imageconvertor.model.ImageMetadataModel;
import com.sunsat.sathish.j2ee.imageconvertor.model.ImageUploadeRequestModel;
import com.sunsat.sathish.j2ee.imageconvertor.service.ImageConvertorService;
import com.sunsat.sathish.j2ee.imageconvertor.utility.Utility;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.ImageCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Map;

@RestController
public class ImageController {

    @Autowired
    ImageConvertorService imageConvertorService;

    @PostMapping("/mcp-mgmt/upload-image")
    public Boolean changeImageScaller(@Valid @RequestBody ImageUploadeRequestModel model) {
        imageConvertorService.convertImage(model);
        return true;
    }
}
