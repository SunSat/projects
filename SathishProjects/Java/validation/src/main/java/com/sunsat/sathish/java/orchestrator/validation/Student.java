package com.sunsat.sathish.java.orchestrator.validation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    @JsonProperty("dob")
    private Date dob;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("lastName")
    private String lastName;
}
