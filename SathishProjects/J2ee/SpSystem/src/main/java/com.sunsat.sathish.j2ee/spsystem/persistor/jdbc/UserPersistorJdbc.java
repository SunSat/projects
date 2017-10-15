package com.sunsat.sathish.j2ee.spsystem.persistor.jdbc;

import com.sunsat.sathish.j2ee.spsystem.SpSystemConstants;
import com.sunsat.sathish.j2ee.spsystem.dto.UserDto;
import com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ssundar2 on 29-03-2017.
 */

public class UserPersistorJdbc implements GeneralPersistorJdbc<UserDto> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserRowMapper userRowMapper;

    Logger logger = Logger.getLogger(UserPersistorJdbc.class.getName());
    Level level = Level.INFO;
    boolean canLog = logger.isLoggable(level);


    public int add(UserDto userDto) {
        String sql = "insert into spsystems.user(userid,name,password,dateofbirth,gender,mobile,isadmin,address,dateofjoin,dateofleave,status) values(?,?,?,?,?,?,?,?,?,?,?)";
        Object[] obj = {userDto.getUserId(),userDto.getName(),userDto.getPassword(),userDto.getDateofbirth(),userDto.getGender(),userDto.getMobile(),userDto.getIsAdmin(),userDto.getAddress(),userDto.getDateofjoin(),userDto.getDateofleave(),userDto.getStatus()};
        return jdbcTemplate.update(sql,obj);
    }

    public void edit(UserDto userDto) {
        String sql = "update spsystems.user SET name=?,password=?,isadmin=?,status=? where userid=?";
        Object[] value = {userDto.getName(),userDto.getPassword(),userDto.getIsAdmin(),userDto.getStatus(),userDto.getUserId()};
        jdbcTemplate.update(sql, value);
    }

    public boolean delete(UserDto userDto) {

        String sql = "update spsystems.user SET status=? where userid=?";
        Object[] value = new Object[]{SpSystemConstants.USER_EMPLOYMENT_STATUS_TERMINATED, userDto.getUserId()};
        jdbcTemplate.update(sql,value);
        return true;
    }

    public List<UserDto> getByTrackingId(UserDto userDto) {
        String sql = "select * from spsystems.user where trackingid=?";
        Object[] value = {userDto.getTrackingId()};
        return jdbcTemplate.query(sql,value,userRowMapper);
    }

    public List<UserDto> getByName(UserDto userDto) {
        String sql = "select * from spsystems.user where name=? and status=?";
        Object[] value = {userDto.getName(), SpSystemConstants.USER_EMPLOYMENT_STATUS_CURRENT};
        return jdbcTemplate.query(sql,value,userRowMapper);
    }

    public List<UserDto> getByUserId(UserDto userDto) {
        if(canLog) logger.log(level,"Entering into -- getByUserId with request param as : " + userDto.toString());
        String sql = "select * from spsystems.user where userid=? and status=?";
        Object[] value = {userDto.getUserId(), SpSystemConstants.USER_EMPLOYMENT_STATUS_CURRENT};
        List<UserDto> dtos = jdbcTemplate.query(sql,value,userRowMapper);;
        if(canLog) logger.log(level,"Exiting -- getByUserId with response param as list of Dtos : " + dtos);
        return dtos;
    }

    public List<UserDto> getAllByDate(UserDto userDto, Date from, Date To) {
        return null;
    }

    public List<UserDto> getByColumnName(UserDto userDto, String name) {
        return null;
    }
}
