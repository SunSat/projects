package com.sunsat.sathish.j2ee.spsystem.handler.requestHandler;

import com.sunsat.sathish.j2ee.spsystem.SpSystemConstants;
import com.sunsat.sathish.j2ee.spsystem.dto.CurrentUserDto;
import com.sunsat.sathish.j2ee.spsystem.dto.UserDto;
import com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.LoginPersistorJdbc;
import com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.UserPersistorJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ssundar2 on 28-03-2017.
 */

@Controller
@RequestMapping("/Login.sp")
@Scope("session")
public class LoginRequestHandler {


    @Autowired
    LoginPersistorJdbc loginPersistorJdbc;

    @Autowired
    CurrentUserDto currentUserDto;

    @Autowired
    UserPersistorJdbc uPersistor;

    @Autowired
    HttpSession session;

    @Autowired
    UserDto uDto;

    Logger logger = Logger.getLogger(LoginRequestHandler.class.getName());
    Level level = Level.INFO;
    boolean canLog = logger.isLoggable(level);

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView handleUserLogin(@RequestParam Map<String,String> allReqMap,ModelMap returnMap) {
    //public String handleUserLogin(@ModelAttribute LoginModel logModel, ModelMap returnMap) {

        //Step 1 : Check username and password is correct from DB.
        //Step 2 : Check check isAdmin or User.
        //Step 3 : Is Admin then return homeadmin.
        //Step 4 : not return home.
        //Step 5 : Any Error return error message saying username or password wrong.
        if(canLog) logger.log(level,"Entering into -- handleUserLogin with request param as : " + allReqMap);
        returnMap.addAttribute("Message","");

        if(!allReqMap.containsKey("userid") || !allReqMap.containsKey("password")) {
            returnMap.addAttribute("Message", "UserName or Password Wrong");
            return new ModelAndView("index",returnMap);
        }

        String st = allReqMap.get("userid");
        String password = allReqMap.get("password");

        if( st == null || st.trim().length() == 0 || password == null || password.trim().length() == 0) {
            returnMap.addAttribute("Message", "UserName or Password Wrong");
            if(canLog) logger.log(level,"Exiting -- handleUserLogin 1 with response param as : " + allReqMap);
            return new ModelAndView("index",returnMap);
        }

        uDto.setUserId(st);
        List<UserDto> dtoli = uPersistor.getByUserId(uDto);

        if(null == dtoli || dtoli.size() == 0) {
            returnMap.addAttribute("Message", "UserName or Password is Wrong");
            if(canLog) logger.log(level,"Exiting -- handleUserLogin 2 with response param as : " + allReqMap);
            return new ModelAndView("index",returnMap);
        }

        uDto = dtoli.get(0);

        if(!uDto.getPassword().equals(password)) {
            returnMap.addAttribute("Message", "UserName or Password is Wrong");
            if(canLog) logger.log(level,"Exiting -- handleUserLogin 3 with response param as : " + allReqMap);
            return new ModelAndView("index",returnMap);
        }

        currentUserDto.setTrackingId(uDto.getTrackingId());
        currentUserDto.setUserId(uDto.getUserId());
        currentUserDto.setIsAdmin(uDto.getIsAdmin());
        currentUserDto.setLogingTime(new Date());
        currentUserDto.setName(uDto.getName());

        if(SpSystemConstants.TRUE.equalsIgnoreCase(uDto.getIsAdmin())) {
            if(canLog) logger.log(level,"Exiting -- handleUserLogin 4 with response param as : " + allReqMap);
            return new ModelAndView("homeadmin",returnMap);
        } else {
            if(canLog) logger.log(level,"Exiting -- handleUserLogin 5 with response param as : " + allReqMap);
            return new ModelAndView("home",returnMap);
        }
    }
}
