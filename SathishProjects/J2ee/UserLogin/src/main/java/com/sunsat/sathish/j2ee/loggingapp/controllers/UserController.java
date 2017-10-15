package com.sunsat.sathish.j2ee.loggingapp.controllers;

import com.sunsat.sathish.j2ee.loggingapp.persistor.CustomerCommInfoPersistor;
import com.sunsat.sathish.j2ee.loggingapp.persistor.CustomerInfoPersistor;
import com.sunsat.sathish.j2ee.loggingapp.pojo.dto.CustCommInfoDto;
import com.sunsat.sathish.j2ee.loggingapp.pojo.dto.CustomerInfoDto;
import com.sunsat.sathish.j2ee.loggingapp.pojo.model.UserModel;
import com.sunsat.sathish.j2ee.loggingapp.persistor.UserPersistor;
import com.sunsat.sathish.j2ee.loggingapp.pojo.dto.UserDto;
import com.sunsat.sathish.j2ee.loggingapp.util.GeneralConstants;
import com.sunsat.sathish.j2ee.loggingapp.util.dao.DaoUtil;
import com.sunsat.sathish.j2ee.loggingapp.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ssundar2 on 24-02-2017.
 */
@Controller
@RequestMapping("/newUser.sp")
public class UserController {

    @Autowired
    UserPersistor userPersistor;
    @Autowired
    CustomerInfoPersistor custInfoPersistor;
    @Autowired
    CustomerCommInfoPersistor custCommInfoPersistor;


    @Autowired
    DaoUtil daoUtil;

    @Autowired
    UserModel model;

    @Autowired
    UserDto userDto;
    @Autowired
    CustomerInfoDto custInfoDto;
    @Autowired
    CustCommInfoDto custCommInfoDto;

    @RequestMapping(method = RequestMethod.POST)
    //public String persistUserLogin(@RequestParam Map<String, String> allReqMap, @PathVariable String userId) {
    public String createNewUser( @ModelAttribute UserModel model) {

        ValidationResult vr = new ValidationResult();
        if(!performValidation(vr)) {
            return "user";
        }

        int id = daoUtil.getMaxUserId();
        userDto.setId(id);
        userDto.setUesrName(model.getUserName());
        userDto.setPassword(model.getPassword());
        userDto.setCreationTime(new Date());
        userDto.setExpiryTime(new Date());
        userDto.setStauts(GeneralConstants.NEW_USER_STATUS_INIIAL);
        userPersistor.addNewUser(userDto);

        custInfoDto.setId(id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date d = null;
        try {
            d = format.parse(model.getDateOfBirth());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        custInfoDto.setDateOfBirth(d);
        custInfoDto.setGender(model.getGender());
        custInfoDto.setName(model.getName());
        custInfoPersistor.addNewCustomer(custInfoDto);

        custCommInfoDto.setId(id);
        custCommInfoDto.setMobileNo1(model.getMobileNo1());
        custCommInfoDto.setMobileNo1Verified(false);
        custCommInfoDto.setMobileNo2(model.getMobileNo2());
        custCommInfoDto.setMobileNo2Verified(false);
        custCommInfoDto.setMailId1(model.getEmail1());
        custCommInfoDto.setMailId1Verified(false);
        custCommInfoDto.setMailId2(model.getEmail2());
        custCommInfoDto.setMailId2Verified(false);
        custCommInfoPersistor.addNewCustomerCommInfo(custCommInfoDto);
        return "index";
    }

    public boolean performValidation(ValidationResult vr) {
        return  true;
    }

}
