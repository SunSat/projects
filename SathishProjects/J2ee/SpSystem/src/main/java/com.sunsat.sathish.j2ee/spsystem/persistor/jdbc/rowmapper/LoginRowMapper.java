package com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.rowmapper;

import com.sunsat.sathish.j2ee.spsystem.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ssundar2 on 29-03-2017.
 */
@Scope("prototype")
public class LoginRowMapper implements RowMapper<LoginDto> {

    public LoginDto mapRow(ResultSet resultSet, int i) throws SQLException {
        LoginDto dto = new LoginDto();
        dto.setTrackingId(resultSet.getInt("trackingid"));
        dto.setLogingTime(resultSet.getDate("logingtime"));
        dto.setLoggoutTime(resultSet.getDate("logouttime"));
        dto.setSttaus(resultSet.getString("status"));
        return dto;
    }
}
