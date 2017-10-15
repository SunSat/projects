package com.sunsat.sathish.j2ee.spsystem.handler.requestHandler;

import com.sunsat.sathish.j2ee.spsystem.SpSystemConstants;
import com.sunsat.sathish.j2ee.spsystem.dto.CurrentUserDto;
import com.sunsat.sathish.j2ee.spsystem.dto.UserDto;
import com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.UserPersistorJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by ssundar2 on 28-03-2017.
 */

@Scope("prototype")
@Controller
@RequestMapping(value = "/user.sp")
public class UserRequestHandler {

    @Autowired
    HttpSession session;
    @Autowired
    UserDto uDto;

    @Autowired
    UserPersistorJdbc uPersistor;


    @RequestMapping(params = "submit=AddUser")
    public ModelAndView addUser(@RequestParam Map<String,String> allReqMap,ModelMap map) {

        map.addAttribute("UserMessage", "");
        map.addAttribute("userDto",new UserDto());

        CurrentUserDto dto = (CurrentUserDto)session.getAttribute("currentUserDto");
        if(!dto.getIsAdmin().equalsIgnoreCase(SpSystemConstants.TRUE)) {
            map.addAttribute("Message", "Your not a admin & You cannot access this page");
            return new ModelAndView("index",map);
        }

        String userId = allReqMap.get("userid");
        String name = allReqMap.get("name");
        String password = allReqMap.get("password");
        String isadmin = allReqMap.get("isadmin");
        String status = allReqMap.get("status");

        uDto.setUserId(userId == null ? "" : userId);
        uDto.setStatus(status == null ? "" : status);

        uDto.setIsAdmin(isadmin == null ? "" : isadmin.equalsIgnoreCase("yes") ? "true" : "false" );
        uDto.setName(name == null ? "" : name);
        uDto.setPassword(password == null ? "" : password);

        map.addAttribute("userDto",uDto);
        if(userId == null && userId.trim().length() == 0 || name  ==null || name.trim().length() == 0 || password == null || password.trim().length() == 0) {
            map.addAttribute("UserMessage", "User Id Or Name or Password field is empty. Please add the required data.");
            return new ModelAndView("homeadmin",map);
        }

        List<UserDto> userDtoLi = uPersistor.getByUserId(uDto);
        if(userDtoLi != null && userDtoLi.size() != 0) {
            map.addAttribute("UserMessage", "This user Id is already available. Please terminate this user First. Then you can use the same user id.");
            return new ModelAndView("homeadmin",map);
        }

        uPersistor.add(uDto);

        map.addAttribute("userDto",new UserDto());
        map.addAttribute("UserMessage", "User added Successfully to the DB.");
        return new ModelAndView("homeadmin",map);
    }

    @RequestMapping(params = "submit=UpdateUser")
    public ModelAndView updateUser(@RequestParam Map<String,String> allReqMap,ModelMap map) {

        map.addAttribute("UserMessage", "");

        CurrentUserDto dto = (CurrentUserDto)session.getAttribute("currentUserDto");
        if(!dto.getIsAdmin().equalsIgnoreCase(SpSystemConstants.TRUE)) {
            map.addAttribute("Message", "Your not a admin & You cannot access this page");
            return new ModelAndView("index",map);
        }

        String userId = allReqMap.get("userid");
        String name = allReqMap.get("name");
        String password = allReqMap.get("password");
        String isadmin = allReqMap.get("isadmin");
        String status = allReqMap.get("status");

        uDto.setUserId(userId == null ? "" : userId);
        uDto.setStatus(status == null ? "" : status);
        uDto.setIsAdmin(isadmin == null ? "" : isadmin);
        uDto.setName(name == null ? "" : name);
        uDto.setPassword(password == null ? "" : password);

        map.addAttribute("userDto",uDto);
        if(userId == null && userId.trim().length() == 0 || name  ==null || name.trim().length() == 0 || password == null || password.trim().length() == 0) {
            map.addAttribute("UserMessage", "User Id Or Name or Password field is empty. Please add the required data.");
            return new ModelAndView("homeadmin",map);
        }

        uPersistor.edit(uDto);
        map.addAttribute("userDto",new UserDto());
        map.addAttribute("UserMessage", "User updated Successfully to the DB.");
        return new ModelAndView("homeadmin",map);
    }

    @RequestMapping(params = "submit=DeleteUser")
    public ModelAndView delete(@RequestParam Map<String,String> allReqMap,ModelMap map) {

        map.addAttribute("UserMessage", "");

        CurrentUserDto dto = (CurrentUserDto)session.getAttribute("currentUserDto");
        if(!dto.getIsAdmin().equalsIgnoreCase(SpSystemConstants.TRUE)) {
            map.addAttribute("Message", "Your not a admin & You cannot access this page");
            return new ModelAndView("index",map);
        }

        String userId = allReqMap.get("userid");
        String name = allReqMap.get("name");
        String password = allReqMap.get("password");
        String isadmin = allReqMap.get("isadmin");
        String status = allReqMap.get("status");

        uDto.setUserId(userId == null ? "" : userId);
        uDto.setStatus(status == null ? "" : status);
        uDto.setIsAdmin(isadmin == null ? "" : isadmin);
        uDto.setName(name == null ? "" : name);
        uDto.setPassword(password == null ? "" : password);

        map.addAttribute("userDto",uDto);
        if(userId == null && userId.trim().length() == 0 || name  ==null || name.trim().length() == 0 || password == null || password.trim().length() == 0) {
            map.addAttribute("UserMessage", "User Id Or Name or Password field is empty. Please add the required data.");
            return new ModelAndView("homeadmin",map);
        }

        uPersistor.delete(uDto);
        map.addAttribute("userDto",new UserDto());
        map.addAttribute("UserMessage", "User Deleted Successfully to the DB.");
        return new ModelAndView("homeadmin",map);
    }


    @RequestMapping(params = "submit=SearchUser")
    public ModelAndView searchUser(@RequestParam Map<String,String> allReqMap,ModelMap map) {

        map.addAttribute("UserMessage", "");
        map.addAttribute("userDto",new UserDto());

        CurrentUserDto dto = (CurrentUserDto)session.getAttribute("currentUserDto");
        if(!dto.getIsAdmin().equalsIgnoreCase(SpSystemConstants.TRUE)) {
            map.addAttribute("Message", "Your not a admin & You cannot access this page");
            return new ModelAndView("index",map);
        }

        String userId = allReqMap.get("userid");
        String name = allReqMap.get("name");
        String password = allReqMap.get("password");
        String isadmin = allReqMap.get("isadmin");
        String status = allReqMap.get("status");

        uDto.setUserId(userId == null ? "" : userId);
        uDto.setStatus(status == null ? "" : status);
        uDto.setIsAdmin(isadmin == null ? "" : isadmin);
        uDto.setName(name == null ? "" : name);
        uDto.setPassword(password == null ? "" : password);

        map.addAttribute("userDto",uDto);
        if(userId == null && userId.trim().length() == 0) {
            map.addAttribute("UserMessage", "User Id field is empty. Please provide the required data.");
            return new ModelAndView("homeadmin",map);
        }

        List<UserDto> userDtoLi = uPersistor.getByUserId(uDto);

        if(null == userDtoLi || userDtoLi.size() == 0) {
            map.addAttribute("UserMessage", "No User Available for this userId.");
            return new ModelAndView("homeadmin",map);
        }

        map.addAttribute("userDto",userDtoLi.get(0));
        return new ModelAndView("homeadmin",map);
    }
}
