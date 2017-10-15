package com.sunsat.sathish.j2ee.spsystem.persistor.jdbc;

import com.sunsat.sathish.j2ee.spsystem.SpSystemConstants;
import com.sunsat.sathish.j2ee.spsystem.dto.BarCodeTrackerDto;
import com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.rowmapper.BarcodeTrackerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.GeneratedValue;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ssundar2 on 29-03-2017.
 */
public class BarCodePersistorJdbc implements GeneralPersistorJdbc<BarCodeTrackerDto> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BarcodeTrackerRowMapper barcodeRowMapper;

    Logger logger = Logger.getLogger(BarCodePersistorJdbc.class.getName());
    Level level = Level.INFO;
    boolean canLog = logger.isLoggable(level);

    public int add(BarCodeTrackerDto bcDto) {

        if(canLog) logger.log(level,"Entering -- add response param as : " + bcDto);
        String sql = "INSERT INTO spsystems.barcodetracker values (?,?,?,?,?,?,?,?)";
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(bcDto.getCreatedDate().getTime());
        Object[] vals = new Object[]{bcDto.getTrackerId(),bcDto.getBarcodeId(),bcDto.getType(),sqlDate,bcDto.getStatus(),bcDto.getIsRejected(),bcDto.getCount(),bcDto.getMessage()};
        Object[] types = new Object[]{Integer.class,String.class,String.class,java.sql.Timestamp.class,String.class,String.class,Integer.class,String.class};
        if(canLog) logger.log(level,"Exiting -- add : sucessfully added the barcode to DB. : ");
        return jdbcTemplate.update(sql,vals);
    }

    public void edit(BarCodeTrackerDto bcDto) {
        if(canLog) logger.log(level,"Entering -- edit : " + bcDto);
        String sql = "update spsystems.barcodetracker SET date=?, status = ?, isrejected=?, count=?, message=? WHERE trackingid =? and barcodeid =? and type=? and status=?";
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(bcDto.getCreatedDate().getTime());
        Object[] vals = new Object[]{sqlDate,bcDto.getStatus(),bcDto.getIsRejected(),bcDto.getCount(),bcDto.getMessage(),bcDto.getTrackerId(),bcDto.getBarcodeId(),bcDto.getType(), SpSystemConstants.BAR_CODE_STATUS_LOCKED};
        Object[] types = new Object[]{java.sql.Timestamp.class,String.class,String.class,Integer.class,String.class,Integer.class,String.class,String.class,String.class};
        if(canLog) logger.log(level,"Exiting -- sucessfully updated the barcode to DB. : ");
        jdbcTemplate.update(sql,vals);
    }

    public boolean delete(BarCodeTrackerDto bcDto) {
        if(canLog) logger.log(level,"Entering -- delete : " + bcDto);
        String sql = "DELETE from spsystems.barcodetracker WHERE barcodeid =? and type=? and status=?";
        Object[] vals = new Object[]{bcDto.getBarcodeId(),bcDto.getType(),bcDto.getStatus()};
        Object[] types = new Object[]{String.class,String.class,String.class};
        if(canLog) logger.log(level,"Exiting -- successfully deleted the barcode to DB. : ");
        jdbcTemplate.update(sql,vals);
        return  true;
    }

    public List<BarCodeTrackerDto> getByTrackingId(BarCodeTrackerDto barCodeTrackerDto) {
        return null;
    }

    public List<BarCodeTrackerDto> getByName(BarCodeTrackerDto barCodeTrackerDto) {
        return null;
    }

    public List<BarCodeTrackerDto> getByUserId(BarCodeTrackerDto barCodeTrackerDto) {
        return null;
    }

    public List<BarCodeTrackerDto> getAllByDate(BarCodeTrackerDto barCodeTrackerDto, Date from, Date To) {
        return null;
    }
    public List<BarCodeTrackerDto> getByColumnName(BarCodeTrackerDto barCodeTrackerDto, String columnName) {

        if(canLog) logger.log(level,"Entering into getByColumnName : " + barCodeTrackerDto);

        String sql = null;
        Object[] val = null;
        if(columnName.equalsIgnoreCase("barcodeId")) {
            sql = "select * from spsystems.barcodetracker where barcodeid = ? and type= ?";
            val = new Object[]{barCodeTrackerDto.getBarcodeId(),barCodeTrackerDto.getType()};
        }

        List<BarCodeTrackerDto> dtos = jdbcTemplate.query(sql,val,barcodeRowMapper);

        if(canLog) logger.log(level,"Exiting -- getByColumnName with list of Dtos : " + dtos);
        return dtos;
    }
}
