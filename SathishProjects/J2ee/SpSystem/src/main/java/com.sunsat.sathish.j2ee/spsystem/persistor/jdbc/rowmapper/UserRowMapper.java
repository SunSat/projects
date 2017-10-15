package com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.rowmapper;

import com.sunsat.sathish.j2ee.spsystem.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ssundar2 on 29-03-2017.
 */
@Scope("prototype")
public class UserRowMapper implements RowMapper<UserDto> {

    public UserDto mapRow(ResultSet rs, int i) throws SQLException {
        UserDto dto = new UserDto();
        dto.setTrackingId(rs.getInt("trackingid"));
        dto.setUserId(rs.getString("userid"));
        dto.setName(rs.getString("name"));
        dto.setPassword(rs.getString("password"));
        dto.setAddress(rs.getString("address"));
        dto.setDateofbirth(rs.getDate("dateofbirth"));
        dto.setDateofjoin(rs.getDate("dateofjoin"));
        dto.setDateofleave(rs.getDate("dateofleave"));
        dto.setIsAdmin(rs.getString("isadmin"));
        dto.setGender(rs.getString("gender"));
        dto.setMobile(rs.getString("mobile"));
        dto.setStatus(rs.getString("status"));
        return dto;
    }
}
