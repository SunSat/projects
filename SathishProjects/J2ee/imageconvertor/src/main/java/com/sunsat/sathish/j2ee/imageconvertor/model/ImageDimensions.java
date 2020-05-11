package com.sunsat.sathish.j2ee.imageconvertor.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "resize")
public class ImageDimensions {
    String type;
    Integer width;
    Integer height;
    String folderPath;
}
