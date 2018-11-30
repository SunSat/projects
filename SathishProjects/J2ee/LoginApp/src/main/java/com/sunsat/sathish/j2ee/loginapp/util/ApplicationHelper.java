package com.sunsat.sathish.j2ee.loginapp.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ApplicationHelper {

    public static void clearCookie(HttpServletRequest request) {
        Cookie[] cooArr = request.getCookies();
        for(Cookie cookie  : cooArr) {
            if(cookie.getName().equals("userId")) {
                cookie.setMaxAge(0);
                break;
            }
        }
    }

    public static void clearSession(HttpServletRequest request) {
        request.getSession().invalidate();
    }

}
