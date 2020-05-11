package com.sunsat.sathish.j2ee.imageconvertor;

import com.sunsat.sathish.j2ee.imageconvertor.model.ImageMetadataModel;
import org.im4java.core.ConvertCmd;
import org.im4java.core.ImageCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ImageconvertorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageconvertorApplication.class, args);
    }

    @Bean
    public ImageCommand getConvertorCmd(){
        ImageCommand cmd = new ConvertCmd();
        return cmd;
    }
}
