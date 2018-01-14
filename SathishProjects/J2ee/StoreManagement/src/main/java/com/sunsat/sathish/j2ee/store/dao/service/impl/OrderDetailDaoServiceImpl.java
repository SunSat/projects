package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.DaoUtil;
import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;
import com.sunsat.sathish.j2ee.store.dao.model.OrderDetailDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by sathishkumar_su on 1/9/2018.
 */
public class OrderDetailDaoServiceImpl extends BaseDaoServiceImpl {
    public int add(OrderDetailDaoModel model) throws SQLException {
        String sql = "insert into order_detail (orderid, amount, payment_type, created_date, order_state) values (?,?,?,?,?)";
        PreparedStatement insertSt = null;
        int maxId = getMaxId("order_detail","orderid");
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            insertSt = con.prepareStatement(sql);
            insertSt.setInt(1, maxId);
            insertSt.setFloat(2, model.getAmount());
            insertSt.setString(3, model.getPaymentType());
            insertSt.setDate(4, DaoUtil.convertJavaToSqlDate(model.getCreatedDate()));
            insertSt.setString(5, model.getOrderState());
            insertSt.execute();
            con.commit();
            con.setAutoCommit(true);
        } finally {
            if(null != insertSt)
                insertSt.close();
        }
        return maxId;
    }

    public int delete(OrderDetailDaoModel model) throws SQLException {
        String sql = "delete from order_detail where orderid=?";
        PreparedStatement delSt = null;
        int deleteCount = 0 ;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            delSt = con.prepareStatement(sql);
            delSt.setInt(1, model.getOrderId());
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

    public int update(OrderDetailDaoModel model) throws SQLException {
        String sql = "update order_detail set amount=?,payment_type=?,created_date=?,order_state=? where orderid= ?";
        PreparedStatement updateSt = null;
        int updateCount = 0;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            updateSt = con.prepareStatement(sql);
            updateSt.setFloat(1, model.getAmount());
            updateSt.setString(2,model.getPaymentType());
            updateSt.setDate(3, DaoUtil.convertJavaToSqlDate(model.getCreatedDate()));
            updateSt.setString(4, model.getOrderState());
            updateSt.setInt(5,model.getOrderId());
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


    public List<OrderDetailDaoModel> getByName(String name) throws SQLException {

        /*String sql = "select * from order_detail where  = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        List<OrderDetailDaoModel> userLi = new ArrayList<>();
        Connection con = null;
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setString(1,name);
            rs = getState.executeQuery();
            while(rs.next()) {
                OrderDetailDaoModel model = new OrderDetailDaoModel();
                model.setOrderId(rs.getInt("orderid"));
                model.setAmount(rs.getFloat("amount"));
                model.setPaymentType(rs.getString("payment_type"));
                model.setCreatedDate(DaoUtil.convertSqlToJavaDate(rs.getDate("created_date")));
                model.setOrderState(rs.getString("order_state"));
                userLi.add(model);
            }
        }finally {
            if(getState != null) {
                getState.close();
            }
            if(rs!= null){
                rs.close();
            }
        }
        return userLi;*/
        return null;
    }

    public OrderDetailDaoModel getById(int id) throws SQLException {
        String sql = "select * from order_detail where orderid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        OrderDetailDaoModel model = new OrderDetailDaoModel();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, id);
            rs = getState.executeQuery();
            while(rs.next()) {
                model.setOrderId(rs.getInt("orderid"));
                model.setAmount(rs.getFloat("amount"));
                model.setPaymentType(rs.getString("payment_type"));
                model.setCreatedDate(DaoUtil.convertSqlToJavaDate(rs.getDate("created_date")));
                model.setOrderState(rs.getString("order_state"));
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

    public List<OrderDetailDaoModel> getAllByName(String objName) throws SQLException{
        /*String sql = "select * from item where name = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        List<OrderDetailDaoModel> userLi = new ArrayList<>();
        Connection con = null;
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setString(1,objName);
            rs = getState.executeQuery();
            while(rs.next()) {
                OrderDetailDaoModel model = new OrderDetailDaoModel();
                model.setOrderId(rs.getInt("orderid"));
                model.setAmount(rs.getFloat("amount"));
                model.setPaymentType(rs.getString("payment_type"));
                model.setCreatedDate(DaoUtil.convertSqlToJavaDate(rs.getDate("created_date")));
                model.setOrderState(rs.getString("order_state"));
                userLi.add(model);
            }
        }finally {
            if(getState != null) {
                getState.close();
            }
            if(rs!= null){
                rs.close();
            }
        }
        return userLi;*/
        return null;
    }

    public static void main(String[] args) {
        OrderDetailDaoModel daoModel = new OrderDetailDaoModel();
        daoModel.setAmount(100.00f);
        daoModel.setPaymentType("Case On Delivery");
        daoModel.setOrderState("moved");
        daoModel.setCreatedDate(new Date());
        OrderDetailDaoServiceImpl impl = new OrderDetailDaoServiceImpl();
        try {
            impl.add(daoModel);
        }catch (SQLException sqe) {
            sqe.printStackTrace();
        }
    }
}
