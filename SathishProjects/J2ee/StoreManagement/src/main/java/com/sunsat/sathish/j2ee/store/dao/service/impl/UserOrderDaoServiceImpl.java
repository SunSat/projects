package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;
import com.sunsat.sathish.j2ee.store.dao.model.UserOrderDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 1/13/2018.
 */
public class UserOrderDaoServiceImpl extends BaseDaoServiceImpl {

    public int delete(UserOrderDaoModel model) throws SQLException {
        String sql = "delete from user_order where id=?";
        PreparedStatement delSt = null;
        int deleteCount = 0 ;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            delSt = con.prepareStatement(sql);
            delSt.setInt(1, model.getId());
            deleteCount = delSt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        }finally {
            if(delSt != null) {
                delSt.close();
            }
        }
        return deleteCount;
    }

    public int add(UserOrderDaoModel model) throws SQLException {
        String sql = "insert into user_order (id, userid, orderid) values (?,?,?,?)";
        PreparedStatement insertSt = null;
        int maxId = getMaxId("category_item","id");
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            insertSt = con.prepareStatement(sql);
            insertSt.setInt(1, maxId);
            insertSt.setInt(2, model.getUserId());
            insertSt.setInt(3, model.getOrderId());
            insertSt.execute();
            con.commit();
            con.setAutoCommit(true);
        } finally {
            if(null != insertSt)
                insertSt.close();
        }
        return maxId;
    }

    public int update(UserOrderDaoModel model) throws SQLException {
        String sql = "update user_order set userid = ?, orderid = ? where id = ?";
        PreparedStatement updateSt = null;
        int updateCount = 0;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            updateSt = con.prepareStatement(sql);
            updateSt.setInt(1, model.getUserId());
            updateSt.setInt(2, model.getOrderId());
            updateSt.setInt(3,model.getId());
            updateCount = updateSt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        }finally {
            if(updateSt != null) {
                updateSt.close();
            }
        }
        return updateCount;
    }


    public List<UserOrderDaoModel> getByName(String name) throws SQLException {
        return null;
    }

    public UserOrderDaoModel getById(int id) throws SQLException {
        String sql = "select * from user_order where id = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        UserOrderDaoModel model = new UserOrderDaoModel();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, id);
            rs = getState.executeQuery();
            while(rs.next()) {
                model.setId(rs.getInt("id"));
                model.setUserId(rs.getInt("userid"));
                model.setOrderId(rs.getInt("orderid"));
            }
        }finally {
            if(getState != null) {
                getState.close();
            }
            if(rs!= null){
                rs.close();
            }
        }
        return model;
    }

    public List<UserOrderDaoModel> getAllOrderByUserId(int userId) throws SQLException {
        String sql = "select * from user_order where userid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<UserOrderDaoModel> listOfOrdersByUserId = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, userId);
            rs = getState.executeQuery();
            while(rs.next()) {
                UserOrderDaoModel model = new UserOrderDaoModel();
                model.setId(rs.getInt("id"));
                model.setUserId(rs.getInt("userid"));
                model.setOrderId(rs.getInt("orderid"));
                listOfOrdersByUserId.add(model);
            }
        }finally {
            if(getState != null) {
                getState.close();
            }
            if(rs!= null){
                rs.close();
            }
        }
        return listOfOrdersByUserId;
    }
    public List<UserOrderDaoModel> getUserByOrderId(int orderId) throws SQLException {
        String sql = "select * from user_order where orderid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<UserOrderDaoModel> listOfCategoryModel = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, orderId);
            rs = getState.executeQuery();
            while(rs.next()) {
                UserOrderDaoModel model = new UserOrderDaoModel();
                model.setId(rs.getInt("id"));
                model.setUserId(rs.getInt("userid"));
                model.setOrderId(rs.getInt("orderid"));
                listOfCategoryModel.add(model);
            }
        }finally {
            if(getState != null) {
                getState.close();
            }
            if(rs!= null){
                rs.close();
            }
        }
        return listOfCategoryModel;
    }

}
