package com.sunsat.sathish.java.hackerrank.preparation.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ssundar2 on 6/2/2017.
 */
public class PersistorConnection {
    public static void main(String[] args) {
        try {
            Connection con =  DriverManager.getConnection("");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
