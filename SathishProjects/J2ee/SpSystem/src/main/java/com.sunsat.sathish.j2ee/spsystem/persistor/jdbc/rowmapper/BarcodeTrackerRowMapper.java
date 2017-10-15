package com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.rowmapper;

import com.sunsat.sathish.j2ee.spsystem.dto.BarCodeTrackerDto;
import com.sunsat.sathish.j2ee.spsystem.dto.UserDto;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ssundar2 on 29-03-2017.
 */
@Scope("prototype")
public class BarcodeTrackerRowMapper implements RowMapper<BarCodeTrackerDto> {
    public BarCodeTrackerDto mapRow(ResultSet rs, int i) throws SQLException {
        BarCodeTrackerDto dto = new BarCodeTrackerDto();
        dto.setTrackerId(rs.getInt("trackingid"));
        dto.setBarcodeId(rs.getString("barcodeid"));
        dto.setType(rs.getString("type"));
        dto.setCount(rs.getInt("count"));
        dto.setCreatedDate(rs.getDate("date"));
        dto.setIsRejected(rs.getString("isrejected"));
        dto.setStatus(rs.getString("status"));
        dto.setMessage(rs.getString("message"));
        return dto;
    }
}
