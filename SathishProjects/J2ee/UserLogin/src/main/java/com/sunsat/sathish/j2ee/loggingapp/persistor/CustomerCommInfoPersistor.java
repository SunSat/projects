package com.sunsat.sathish.j2ee.loggingapp.persistor;

import com.sunsat.sathish.j2ee.loggingapp.pojo.dao.CustCommInfoDao;
import com.sunsat.sathish.j2ee.loggingapp.pojo.dto.CustCommInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.sunsat.sathish.j2ee.loggingapp.util.GeneralConstants.*;

/**
 * Created by ssundar2 on 15-03-2017.
 */
@Repository
public class CustomerCommInfoPersistor {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CustCommInfoDao custCommInfoDao;

    public void addNewCustomerCommInfo(CustCommInfoDto commInfoDto) {

        custCommInfoDao.setId(commInfoDto.getId());
        custCommInfoDao.setMailId1(commInfoDto.getMailId1());
        custCommInfoDao.setMailId2(commInfoDto.getMailId2());
        custCommInfoDao.setMobileNo1(commInfoDto.getMobileNo1());
        custCommInfoDao.setMobileNo2(commInfoDto.getMobileNo2());
        if(commInfoDto.isMailId1Verified()) {
            custCommInfoDao.setMailId1Verified(NEW_USER_VERIFIED_YES);
        } else {
            custCommInfoDao.setMailId1Verified(NEW_USER_VERIFIED_NO);
        }

        if(commInfoDto.isMailId2Verified()) {
            custCommInfoDao.setMailId2Verified(NEW_USER_VERIFIED_YES);
        } else {
            custCommInfoDao.setMailId2Verified(NEW_USER_VERIFIED_NO);
        }

        if(commInfoDto.isMobileNo1Verified()) {
            custCommInfoDao.setMobileNo1Verified(NEW_USER_VERIFIED_YES);
        } else {
            custCommInfoDao.setMobileNo1Verified(NEW_USER_VERIFIED_NO);
        }

        if(commInfoDto.isMobileNo2Verified()) {
            custCommInfoDao.setMobileNo2Verified(NEW_USER_VERIFIED_YES);
        } else {
            custCommInfoDao.setMobileNo2Verified(NEW_USER_VERIFIED_NO);
        }

        String sql = "insert into communication(id,mobile1,mobile1verified,mobile2," +
                "mobile2verified,email1,email1verified,email2,email2verified) values (?,?,?,?,?,?,?,?,?)";
        Object[] param = {custCommInfoDao.getId(),custCommInfoDao.getMobileNo1(),custCommInfoDao.getMobileNo1Verified(),custCommInfoDao.getMobileNo2(),
                custCommInfoDao.getMobileNo2Verified(),custCommInfoDao.getMailId1(),custCommInfoDao.getMailId1Verified(),custCommInfoDao.getMailId2(),custCommInfoDao.getMailId2Verified()};
        jdbcTemplate.update(sql,param);
    }
}
