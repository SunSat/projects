package com.sunsat.sathish.j2ee.spsystem.persistor.jdbc;

import com.sunsat.sathish.j2ee.spsystem.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

/**
 * Created by ssundar2 on 29-03-2017.
 */
public class LoginPersistorJdbc implements GeneralPersistorJdbc<LoginDto> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int add(LoginDto loginDto) {
        String sql = "insert into spsystems.login(trackingid,logingtime,logouttime,status) values(?,?,?,?)";
        Object[] values = {loginDto.getTrackingId(),loginDto.getLogingTime(),loginDto.getLoggoutTime(),loginDto.getSttaus()};
        Object[] type = {Integer.class,Date.class,Date.class,String.class};
        return jdbcTemplate.update(sql,values,type);
    }

    public void edit(LoginDto loginDto) {

    }

    public boolean delete(LoginDto loginDto) {
        return false;
    }

    public List<LoginDto> getByTrackingId(LoginDto loginDto) {
        return null;
    }

    public List<LoginDto> getByName(LoginDto loginDto) {
        return null;
    }

    public List<LoginDto> getByUserId(LoginDto loginDto) {
        return null;
    }

    public List<LoginDto> getAllByDate(LoginDto loginDto, Date from, Date To) {
        return null;
    }

    public List<LoginDto> getByColumnName(LoginDto loginDto, String name) {
        return null;
    }
}
