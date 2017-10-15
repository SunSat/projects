package com.sunsat.sathish.j2ee.spsystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by ssundar2 on 29-03-2017.
 */
public class SpSystemConstants {

    public static String BAR_CODE_TYPE_DE1 = "DE1";
    public static String BAR_CODE_TYPE_DE2 = "DE2";

    public static String USER_EMPLOYMENT_STATUS_CURRENT = "current";
    public static String USER_EMPLOYMENT_STATUS_TERMINATED = "terminated";

    public static String USER_LOGGING_STATUS_LOGIN = "login";
    public static String USER_LOGGING_STATUS_LOGOUT = "logout";

    public static String TRUE = "true";
    public static String FALSE = "false";

    public static String YES = "yes";
    public static String NO = "no";

    public static String CURRENT_USER_DTO = "currentUserDto";
    public static String MESSAGE = "Message";

    public static String BAR_CODE_STATUS_LOCKED = "locked";
    public static String BAR_CODE_STATUS_SUBMITTED = "submitted";
    public static String BAR_CODE_STATUS_REJECTED = "rejected";

    public static DateFormat sqlDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");


}
