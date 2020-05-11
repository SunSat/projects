package com.sunsat.sathish.j2ee.imageconvertor.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableConfigurationProperties({ImageDimensions.class,ImageQuality.class})
@ConfigurationProperties(prefix = "image")
@Getter
@Setter
public class ImageMetadataModel {

    public String uploadMaxSize;

    public Map<String,ImageDimensions> resize;

    public ImageQuality quality;

}
