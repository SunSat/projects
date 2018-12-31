package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDayOfDate {
    public static void main(String[] args) {
        simpleDate2();
    }
    public static void simpleDate1() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,5);
        cal.set(Calendar.MONTH,5);
        cal.set(Calendar.YEAR,2015);
        System.out.println(cal.getTime().toInstant());
        Date d = cal.getTime();
        DateFormat format = new SimpleDateFormat("EE");
        System.out.println(new SimpleDateFormat("EE").format(d));
        System.out.println(new SimpleDateFormat("EEE").format(d));
        System.out.println(new SimpleDateFormat("EEEE").format(d));


    }
    public static void simpleDate2() {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        System.out.println(df.format(new Date(2015,8,05)));


    }
}
