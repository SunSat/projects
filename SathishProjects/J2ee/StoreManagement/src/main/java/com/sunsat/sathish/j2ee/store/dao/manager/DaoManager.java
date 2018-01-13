package com.sunsat.sathish.j2ee.store.dao.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sathishkumar_su on 1/4/2018.
 */
public class DaoManager {

    private String url = "jdbc:mysql://localhost:3306/cart_management";
    private String userName = "root";
    private String password = "root";
    private Connection con;
    private static DaoManager daoManager = null;

    private DaoManager() throws SQLException {
        init();
    }

    private void init() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,userName,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DaoManager getInstance() throws SQLException {
        if(daoManager == null) {
            synchronized (DaoManager.class) {
                if(daoManager == null) {
                    daoManager = new DaoManager();
                }
            }
        }
        return daoManager;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().con;
    }

    public static boolean cleanUp() throws SQLException {
        Connection con = getInstance().con;
        if(con != null) {
            con.close();
        }
        return true;
    }
}
