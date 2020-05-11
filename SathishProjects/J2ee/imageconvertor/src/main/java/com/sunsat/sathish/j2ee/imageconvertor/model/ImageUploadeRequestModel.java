package com.sunsat.sathish.j2ee.imageconvertor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
public class ImageUploadeRequestModel {

    @JsonProperty(required = true,value = "name")
    private String name;

    @JsonProperty(required = true,value = "path")
    private String path;

    @JsonProperty(required = true,value = "type")
    private String type;

    @JsonProperty(required = true,value = "image")
    private String image;

}
