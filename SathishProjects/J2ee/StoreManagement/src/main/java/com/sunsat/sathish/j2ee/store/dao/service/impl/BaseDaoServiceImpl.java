package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sathishkumar_su on 1/8/2018.
 */
public abstract class BaseDaoServiceImpl {

    public int getMaxId(String tableName,String primaryKeyColumn) throws SQLException {
        Statement maxSt = null;
        ResultSet maxRs = null;
        int maxId = 0;
        Connection con = DaoManager.getConnection();
        try {
            String maxSql = "select max("+primaryKeyColumn+") from "+tableName;
            maxSt = con.createStatement();
            maxRs = maxSt.executeQuery(maxSql);
            if (maxRs.next()) {
                maxId = maxRs.getInt(1);
            }
        }finally {
            if(maxRs != null)
                maxRs.close();
            if(maxSt != null)
                maxSt.close();
        }
        return maxId+1;
    }

}
