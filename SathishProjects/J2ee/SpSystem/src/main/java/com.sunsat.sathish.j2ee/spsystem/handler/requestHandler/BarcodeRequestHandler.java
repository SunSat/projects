package com.sunsat.sathish.j2ee.spsystem.handler.requestHandler;

import com.sunsat.sathish.j2ee.spsystem.SpSystemConstants;
import com.sunsat.sathish.j2ee.spsystem.dto.BarCodeTrackerDto;
import com.sunsat.sathish.j2ee.spsystem.dto.CurrentUserDto;
import com.sunsat.sathish.j2ee.spsystem.dto.UserDto;
import com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.BarCodePersistorJdbc;
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
@RequestMapping(value = "/barcodereqeust")
@Scope("session")
public class BarcodeRequestHandler {

    @Autowired
    BarCodeTrackerDto barcodeTrackerDto;

    @Autowired
    HttpSession session;

    @Autowired
    BarCodePersistorJdbc barCodePersistorJdbc;

    @Autowired
    UserPersistorJdbc userPersistorJdbc;

    Logger logger = Logger.getLogger(BarcodeRequestHandler.class.getName());
    Level level = Level.INFO;
    boolean canLog = logger.isLoggable(level);

    @RequestMapping(path = "/barcodecheck",method = RequestMethod.POST)
    public ModelAndView barcodeChecker(@RequestParam Map<String,String> allReqMap,ModelMap returnMap) {

        if(canLog) logger.log(level,"Entering into -- barcodeChecker with request param as : " + allReqMap);

        CurrentUserDto cuDto = (CurrentUserDto)session.getAttribute(SpSystemConstants.CURRENT_USER_DTO);

        if(allReqMap.get("Submit") != null && allReqMap.get("Submit").equals("Home")) {
            if(cuDto.getIsAdmin().equals("true")) {
                if(canLog) logger.log(level,"Exiting -- barcodeChecker 1 admin pressed the home button: " + returnMap);
                return new ModelAndView("homeadmin",returnMap);
            } else {
                if(canLog) logger.log(level,"Exiting -- barcodeChecker 2 normal user pressed the home button : " + returnMap);
                return new ModelAndView("home",returnMap);
            }
        }

        String barcodeId = allReqMap.get("barcodeId");
        String fileType = allReqMap.get("fileType");

        if(null == barcodeId || barcodeId.trim().length() == 0 || fileType == null || fileType.trim().length() == 0) {
            returnMap.addAttribute("Message", "BarcodeId or FileType is missing. Please enter Barcode Id and File Type");
            if(cuDto.getIsAdmin().equals("true")) {
                if(canLog) logger.log(level,"Exiting -- as admin user missed barcode id or filetype : " + returnMap);
                return new ModelAndView("homeadmin",returnMap);
            } else {
                if(canLog) logger.log(level,"Exiting -- as normal used missed barcode id or file type : " + returnMap);
                return new ModelAndView("home",returnMap);
            }
        }

        barcodeTrackerDto.setBarcodeId(barcodeId);
        barcodeTrackerDto.setType(fileType);
        barcodeTrackerDto.setTrackerId(cuDto.getTrackingId());
        barcodeTrackerDto.setIsRejected("no");
        barcodeTrackerDto.setCount(0);
        barcodeTrackerDto.setMessage("");

        if(allReqMap.get("Submit") != null && allReqMap.get("Submit").equals("UnLock")) {
            if(cuDto.getIsAdmin().equals("true")) {
                barCodePersistorJdbc.delete(barcodeTrackerDto);
                returnMap.put("Message","The barcode :" +barcodeTrackerDto.getBarcodeId() + " & file type : " + barcodeTrackerDto.getType() + " unlocked successfully");
                return new ModelAndView("homeadmin",returnMap);
            } else {
                returnMap.put("Message","You not autherized to do this operations.");
                return new ModelAndView("home",returnMap);
            }
        }

        returnMap.addAttribute("BarCodeTrackerDto",barcodeTrackerDto);

        List<BarCodeTrackerDto> dtoLi =  barCodePersistorJdbc.getByColumnName(barcodeTrackerDto, "barcodeid");

        if(dtoLi == null || dtoLi.size() == 0) {
            barcodeTrackerDto.setStatus(SpSystemConstants.BAR_CODE_STATUS_LOCKED);
            barcodeTrackerDto.setCreatedDate(new Date());
            barCodePersistorJdbc.add(barcodeTrackerDto);
            returnMap.addAttribute("Message", "The BarcodeId :'"+barcodeTrackerDto.getBarcodeId() +"' & File Type : '"+barcodeTrackerDto.getType()+"' was Locked By User." + cuDto.getName());
            return new ModelAndView("barcodeSubmitter",returnMap);
        }

        if(canLog) logger.log(level,"barcodeChecker got DTO successfully.");

        int rejectedCount = 0;
        String isRejected = SpSystemConstants.NO;
        String rejectedMsg = "";

        for(BarCodeTrackerDto barcodeTrackerDto : dtoLi) {
            if (barcodeTrackerDto.getStatus().equalsIgnoreCase(SpSystemConstants.BAR_CODE_STATUS_SUBMITTED)){
                returnMap.addAttribute("Message", "The BarcodeId :'"+ barcodeTrackerDto.getBarcodeId() +"' & File Type : '"+ barcodeTrackerDto.getType()+"' was already Submitted. Please use Different Barcode Id.");
                if(cuDto.getIsAdmin().equals("true")) {
                    if(canLog) logger.log(level,"Exiting -- barcodeChecker  5 with response param as : " + returnMap);
                    return new ModelAndView("homeadmin",returnMap);
                } else {
                    if(canLog) logger.log(level,"Exiting -- barcodeChecker 6 with response param as : " + returnMap);
                    return new ModelAndView("home",returnMap);
                }
            } else if (barcodeTrackerDto.getStatus().equalsIgnoreCase(SpSystemConstants.BAR_CODE_STATUS_REJECTED)){
                if(rejectedCount < barcodeTrackerDto.getCount()) {
                    rejectedCount = barcodeTrackerDto.getCount();
                    rejectedMsg = barcodeTrackerDto.getMessage();
                }
            } else if(barcodeTrackerDto.getStatus().equalsIgnoreCase(SpSystemConstants.BAR_CODE_STATUS_LOCKED)) {
                UserDto uDto = new UserDto();
                uDto.setTrackingId(barcodeTrackerDto.getTrackerId());
                List<UserDto> uDtos = userPersistorJdbc.getByTrackingId(uDto);
                String message = "The BarcodeId :'"+ barcodeTrackerDto.getBarcodeId() +"' & File Type : '"+ barcodeTrackerDto.getType()+"' was locked by user : .";
                if(uDtos == null || uDtos.size() == 0) {
                    //This case need to handle.
                } else {
                    if(uDtos.get(0).getName().equals(cuDto.getName())) {
                        new ModelAndView("barcodeSubmitter",returnMap);
                    } else {
                        message+= uDtos.get(0).getName();
                        returnMap.addAttribute("Message",message);
                        if(cuDto.getIsAdmin().equals("true")) {
                            if(canLog) logger.log(level,"Exiting -- barcodeChecker 7 with response param as : " + returnMap);
                            return new ModelAndView("homeadmin",returnMap);
                        } else {
                            if(canLog) logger.log(level,"Exiting -- barcodeChecker 8 with response param as : " + returnMap);
                            return new ModelAndView("home",returnMap);
                        }
                    }
                }
            }
        }

        if(rejectedCount > 0)  {
            isRejected = SpSystemConstants.YES;
            barcodeTrackerDto.setStatus(SpSystemConstants.BAR_CODE_STATUS_LOCKED);
            barcodeTrackerDto.setCreatedDate(new Date());
            barCodePersistorJdbc.add(barcodeTrackerDto);
        };

        barcodeTrackerDto.setIsRejected(isRejected);
        barcodeTrackerDto.setCount(rejectedCount);
        barcodeTrackerDto.setMessage(rejectedMsg);

        if(canLog) logger.log(level,"Exiting -- barcodeChecker 7 with response param as : " + returnMap);

        return new ModelAndView("barcodeSubmitter",returnMap);

    }

    @RequestMapping(path = "/barcodesubmit",method = RequestMethod.POST)
    public ModelAndView barcodeSubmitter(@RequestParam Map<String,String> allReqMap,ModelMap map) {

        if(canLog) logger.log(level,"Entering -- barcodeSubmitter with request param as : " + allReqMap);

        CurrentUserDto cUserDto = (CurrentUserDto)session.getAttribute("currentUserDto");

        String barcodeId = allReqMap.get("barcodeId");
        String type = allReqMap.get("type");
        String message = allReqMap.get("message");
        String fileStatus = SpSystemConstants.BAR_CODE_STATUS_REJECTED;
        String isRejected = allReqMap.get("isRejected");
        String rejectedCount = allReqMap.get("rejectedcount");
        int rejCount = Integer.parseInt(rejectedCount);
        String warnMessage =  barcodeId +" : Rejected Successfully.";

        if(allReqMap.get("Submit").equalsIgnoreCase("Barcode Submit")) {
            warnMessage =  barcodeId +" : Submitted Successfully.";
            fileStatus = SpSystemConstants.BAR_CODE_STATUS_SUBMITTED;
        } else {
            isRejected = SpSystemConstants.YES;
            rejCount++;
        }

        barcodeTrackerDto.setBarcodeId(barcodeId);
        barcodeTrackerDto.setTrackerId(cUserDto.getTrackingId());
        barcodeTrackerDto.setType(type);
        barcodeTrackerDto.setMessage(message);
        barcodeTrackerDto.setStatus(fileStatus);
        barcodeTrackerDto.setIsRejected(isRejected);
        barcodeTrackerDto.setCount(rejCount);
        barcodeTrackerDto.setCreatedDate(new Date());
        barCodePersistorJdbc.edit(barcodeTrackerDto);
        map.addAttribute("Message",  warnMessage);
        if(cUserDto.getIsAdmin().equals("true")) {
            if(canLog) logger.log(level,"Exiting -- barcodeSubmitter 1 with response param as : " + map);
            return new ModelAndView("homeadmin",map);
        } else {
            if(canLog) logger.log(level,"Exiting -- barcodeSubmitter 2 with response param as : " + map);
            return new ModelAndView("home",map);
        }
    }
}

