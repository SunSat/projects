package com.sunsat.sathish.j2ee.health.base.util;

import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Component
public class GeneralAppUtil {

    private static String otpString = "0123456789";
    private static Integer randomDigits = 4;

    public static Object getLoggedUser() {
        return SecurityContextHolder.getContext().getAuthentication().getDetails();
    }


    public static void setAuthentication(Authentication auth) {
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static UserBusiness getCurrentlyLoggedUser() {
        return (UserBusiness) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    public static Date getCurrentTime() {
        return Calendar.getInstance(Locale.US).getTime();
    }

    public static String getOtp() {
        SecureRandom random = new SecureRandom();
        Integer bound = otpString.length();
        StringBuilder sb = new StringBuilder();
        for(Integer i=0;i<randomDigits;i++) {
            sb.append(otpString.charAt(random.nextInt(bound)));
        }
        return sb.toString();
    }

    public static Calendar getCurrentCalender() {
        return Calendar.getInstance(Locale.US);
    }
}
