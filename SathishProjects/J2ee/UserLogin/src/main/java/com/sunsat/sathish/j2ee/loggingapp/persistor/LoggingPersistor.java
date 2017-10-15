package com.sunsat.sathish.j2ee.loggingapp.persistor;

import com.sunsat.sathish.j2ee.loggingapp.pojo.dto.LogingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by ssundar2 on 24-02-2017.
 */
public class LoggingPersistor {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public LoggingPersistor() {

    }

    public int persistUserLogin() {


        return 0;
    }

}
