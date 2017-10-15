package com.sunsat.sathish.j2ee.loggingapp.persistor;

import com.sunsat.sathish.j2ee.loggingapp.pojo.dao.CustomerInfoDao;
import com.sunsat.sathish.j2ee.loggingapp.pojo.dto.CustomerInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Objects;

/**
 * Created by ssundar2 on 15-03-2017.
 */
public class CustomerInfoPersistor {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    CustomerInfoDao custInfoDao;

    public void addNewCustomer(CustomerInfoDto custDto) {

        custInfoDao.setId(custDto.getId());
        custInfoDao.setName(custDto.getName());
        custInfoDao.setGender(custDto.getGender());
        custInfoDao.setDateOfBirth(custDto.getDateOfBirth());

        String sql = "insert into customerinfo (id,name,gender,dateofbirth) values(?,?,?,?)";
        Object[] paramsObj = {custInfoDao.getId(),custInfoDao.getName(),custInfoDao.getGender(),custInfoDao.getDateOfBirth()};
        jdbcTemplate.update(sql,paramsObj);
    }

    public void updateCustomer(CustomerInfoDto custDto){

    }

    public void deleteCustomer(CustomerInfoDto custDto) {

    }
}
