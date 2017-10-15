package com.sunsat.sathish.j2ee.loggingapp.util.dao;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.SQLException;

/**
 * Created by ssundar2 on 24-02-2017.
 */
public class DaoUtil {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static DaoUtil persistorUtil = null;
    private DaoUtil() {

    }

    public static DaoUtil getInstance() {
        if(persistorUtil == null) {
            synchronized (DaoUtil.class) {
                if(persistorUtil == null) {
                    persistorUtil = new DaoUtil();
                }
            }
        }
        return persistorUtil;
    }

    public int getMaxUserId() {
        String sql = "select max(users.id) from users";
        Integer userId = 0;
        try {
            userId = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception s) {

        }
        return userId;
    }
}
