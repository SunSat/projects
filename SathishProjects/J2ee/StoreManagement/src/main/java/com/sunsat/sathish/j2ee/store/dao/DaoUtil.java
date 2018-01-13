package com.sunsat.sathish.j2ee.store.dao;

/**
 * Created by sathishkumar_su on 12/29/2017.
 */
public class DaoUtil {

    public static java.util.Date convertSqlToJavaDate(java.sql.Date sqlDate) {
        return new java.util.Date(sqlDate.getTime());
    }

    public static java.sql.Date convertJavaToSqlDate(java.util.Date javaDate) {
        return new java.sql.Date(javaDate.getTime());
    }
}
