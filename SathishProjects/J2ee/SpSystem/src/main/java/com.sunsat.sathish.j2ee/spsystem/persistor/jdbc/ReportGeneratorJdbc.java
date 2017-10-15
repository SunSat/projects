package com.sunsat.sathish.j2ee.spsystem.persistor.jdbc;

import com.sunsat.sathish.j2ee.spsystem.dto.ReportResultByDateDto;
import com.sunsat.sathish.j2ee.spsystem.dto.ReporterDto;
import com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.rowmapper.ReportGenerateByDateRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ssundar2 on 30-03-2017.
 */
public class ReportGeneratorJdbc {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ReportGenerateByDateRowMapper rowMapper;

    Logger logger = Logger.getLogger(BarCodePersistorJdbc.class.getName());
    Level level = Level.INFO;
    boolean canLog = logger.isLoggable(level);

    public List<ReportResultByDateDto> reportByDate(ReporterDto dto) {

        if(canLog) logger.log(level,"Entering into ReportGeneratorJdbc --> reportByDate for the DTO : " + dto.toString());
        String sql = "select u.userid,u.name,b.barcodeid,b.type,b.date,b.status,b.message,b.count from spsystems.user u,spsystems.barcodetracker b where u.trackingid = b.trackingid  and date between ? and ? order by u.userid,b.date,b.status";
        Object[] val = new Object[]{new java.sql.Date(dto.getStartDate().getTime()),new java.sql.Date(dto.getEndDate().getTime())};
        List<ReportResultByDateDto> dtos =  jdbcTemplate.query(sql,val,rowMapper);
        if(canLog) logger.log(level,"Exiting from ReportGeneratorJdbc --> reportByDate with the result as  : " + dtos);
        return dtos;
    }
}
