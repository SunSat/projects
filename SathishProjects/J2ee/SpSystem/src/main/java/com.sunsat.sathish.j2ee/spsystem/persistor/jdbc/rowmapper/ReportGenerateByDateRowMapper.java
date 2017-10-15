package com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.rowmapper;

import com.sunsat.sathish.j2ee.spsystem.dto.ReportResultByDateDto;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ssundar2 on 30-03-2017.
 */
@Scope("prototype")
public class ReportGenerateByDateRowMapper implements RowMapper<ReportResultByDateDto>{

    public ReportResultByDateDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReportResultByDateDto dto = new ReportResultByDateDto();
        dto.setUserid(rs.getString("userid"));
        dto.setName(rs.getString("name"));
        dto.setBarcodeId(rs.getString("barcodeid"));
        dto.setStatus(rs.getString("status"));
        dto.setType(rs.getString("type"));
        dto.setDate(rs.getDate("date"));
        dto.setMessage(rs.getString("message"));
        dto.setCount(rs.getInt("count"));
        return dto;
    }
}
