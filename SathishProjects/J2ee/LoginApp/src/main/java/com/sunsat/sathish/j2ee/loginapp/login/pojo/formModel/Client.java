package com.sunsat.sathish.j2ee.loginapp.login.pojo.formModel;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by sathishkumar_su on 6/5/2018.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        ObjectMapper objMap = new ObjectMapper();

        LoggedUserFormModel model = new LoggedUserFormModel();
        model.setMessage("hello worold");
        model.setLoggedTime(new Date());
        model.setUserName("Sathish Kumar");
        Map<String,String> envMap = System.getenv();
        model.setUserId(12);
        objMap.writeValue(new File("C:\\hello\\hello.xml"),model);
    }
}
