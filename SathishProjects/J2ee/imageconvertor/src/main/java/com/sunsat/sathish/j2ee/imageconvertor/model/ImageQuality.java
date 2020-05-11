package com.sunsat.sathish.j2ee.imageconvertor.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix = "quality")
@Getter
@Setter
public class ImageQuality {
    Integer applyIfSize;
    Integer applyTo;
}
