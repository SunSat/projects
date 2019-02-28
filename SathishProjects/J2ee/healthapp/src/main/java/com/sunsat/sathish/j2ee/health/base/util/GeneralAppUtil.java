package com.sunsat.sathish.j2ee.health.base.util;

import com.sunsat.sathish.j2ee.health.login.pojo.business.RoleBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.sunsat.sathish.j2ee.health.base.util.GeneralConstants.*;

@Component
public class GeneralAppUtil {

    private static String otpString = "0123456789";
    private static Integer randomDigits = 4;

    public static void setAuthentication(Authentication auth) {
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Object getLoggedUserPrinciple() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static UserBusiness getLoggedUserDetails() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserBusiness ub = null;
        if(obj != null) {
            if(obj instanceof UserBusiness) {
                ub = (UserBusiness)obj;
            }
            else {
                ub = new UserBusiness();
                ub.setUserName((String)obj);
            }
        } else {
            ub = new UserBusiness();
            ub.setUserName(ANNOYMOUS_USER);
        }
        return ub;
    }

    public static Long getLoggedUserId() {
        return  getLoggedUserDetails().getPrimaryKeyId();
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

    public static Date addDateTime(Integer field,Integer value) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.add(field,value);
        return cal.getTime();
    }

    public static Boolean isAdmin() {
        UserBusiness ub = getLoggedUserDetails();
        if(ub.getRoleBusinesses() == null) return false;
        for(RoleBusiness rb : ub.getRoleBusinesses()) {
            if(rb.getRoleName().equalsIgnoreCase(ADMIN_ROLE_NAME)) {
                return true;
            }
        }
        return false;
    }
}
