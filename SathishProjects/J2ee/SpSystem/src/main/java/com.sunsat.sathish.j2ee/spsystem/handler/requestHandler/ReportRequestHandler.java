package com.sunsat.sathish.j2ee.spsystem.handler.requestHandler;

import com.sunsat.sathish.j2ee.spsystem.SpSystemConstants;
import com.sunsat.sathish.j2ee.spsystem.dto.ReportResultByDateDto;
import com.sunsat.sathish.j2ee.spsystem.dto.ReporterDto;
import com.sunsat.sathish.j2ee.spsystem.persistor.jdbc.ReportGeneratorJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ssundar2 on 28-03-2017.
 */
@Scope("prototype")
@Controller
@RequestMapping(value = "/Report.sp")
public class ReportRequestHandler {

    @Autowired
    ReportGeneratorJdbc reportGenerator;

    @Autowired
    ReporterDto reporterDto;

    Logger logger = Logger.getLogger(LoginRequestHandler.class.getName());
    Level level = Level.INFO;
    boolean canLog = logger.isLoggable(level);

    @RequestMapping(params = "Submit=By Date", method = RequestMethod.POST)
    public ModelAndView reportByDate(@RequestParam Map<String,String> allReqMap,ModelMap retMap) {

        if(canLog) logger.log(level,"Entering into -- reportByDate with request param as : " + allReqMap);

        String startDate = allReqMap.get("startdate");
        String endDate = allReqMap.get("enddate");
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        try {
            reporterDto.setStartDate(dateFormater.parse(startDate));
            Date d = dateFormater.parse(endDate);
            d.setDate(d.getDate() + 1);
            reporterDto.setEndDate(d);
        } catch (ParseException e) {
            retMap.addAttribute("ReportMessage","Provided Start or End date format was not good.");
            return new ModelAndView("homeadmin",retMap);
        }
        List<ReportResultByDateDto> resultLi = reportGenerator.reportByDate(reporterDto);

        Map<String,Integer> userIdVsSubmittedCount = new LinkedHashMap<String, Integer>();
        Map<String,Integer> userIdVsRejectedCount = new LinkedHashMap<String, Integer>();

        Map<Integer,Integer> rejected1To5Count = new LinkedHashMap<Integer, Integer>();
        List<ReportResultByDateDto> totalSubmittedReLi = new LinkedList<ReportResultByDateDto>();
        List<ReportResultByDateDto> totalRejectedReLi = new LinkedList<ReportResultByDateDto>();

        for(ReportResultByDateDto reDto : resultLi) {
            if(SpSystemConstants.BAR_CODE_STATUS_SUBMITTED.equalsIgnoreCase(reDto.getStatus())) {
                totalSubmittedReLi.add(reDto);
                int count = userIdVsSubmittedCount.getOrDefault(reDto.getUserid()+":"+reDto.getName(),0);
                userIdVsSubmittedCount.put(reDto.getUserid()+":"+reDto.getName(),++count);
            } else if(SpSystemConstants.BAR_CODE_STATUS_REJECTED.equalsIgnoreCase(reDto.getStatus())){
                totalRejectedReLi.add(reDto);
                int count = userIdVsRejectedCount.getOrDefault(reDto.getUserid()+":"+reDto.getName(),0);
                userIdVsRejectedCount.put(reDto.getUserid()+":"+reDto.getName(),++count);
                int reCount = rejected1To5Count.getOrDefault(reDto.getCount(),0);
                rejected1To5Count.put(reDto.getCount(),++reCount);
            }
        }
        retMap.addAttribute("userIdVsSubmittedCount",userIdVsSubmittedCount);
        retMap.addAttribute("userIdVsRejectedCount",userIdVsRejectedCount);
        retMap.addAttribute("totalSubmittedReLi",totalSubmittedReLi);
        retMap.addAttribute("totalRejectedReLi",totalRejectedReLi);
        retMap.addAttribute("reportBy","Date");
        retMap.addAttribute("reporterDto",reporterDto);
        retMap.addAttribute("rejected1To5Count",rejected1To5Count);

        return new ModelAndView("reportform",retMap);
    }

    @RequestMapping(params = "Submit=By UserId" , method = RequestMethod.POST)
    public ModelAndView reportById(@RequestParam Map<String,String> allReqMap,ModelMap retMap) {
        return new ModelAndView("reportform",retMap);
    }

    @RequestMapping(params = "Submit=By Name" , method = RequestMethod.POST)
    public ModelAndView reportByName(@RequestParam Map<String,String> allReqMap,ModelMap retMap) {
        return new ModelAndView("reportform",retMap);
    }

}
