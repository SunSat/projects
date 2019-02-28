package com.sunsat.sathish.j2ee.health.base.util;

import org.springframework.beans.factory.annotation.Value;

public class GeneralConstants {
    public static String ANNOYMOUS_USER = "anonymousUser";
    public static String LOGGED_USER_NAME = "loggedUserName";
    public static String LOGGED_USER_ID = "loggedUserId";
    public static String IS_ADMIN = "isAdmin";
    public static String ADMIN_ROLE_NAME = "ADMIN";
    public static String LIKE_COUNT = "userLikeCount";
    public static String USER_LIKE = "userLike";

    //@Value("${expiry.duration.password.days}")
    public static Integer PASSWORD_EXPIRE_DURATION_DAYS = 180;

    //@Value("${expiry.duration.new.account.validation.days}")
    public static Integer NEW_ACCOUNT_VALIDATION_EXPIRY_DURATION_DAYS = 1;

    public static String NEW_USER_REGISTRATION_TEMPLATE_NAME = "newUserRegistration";
}
