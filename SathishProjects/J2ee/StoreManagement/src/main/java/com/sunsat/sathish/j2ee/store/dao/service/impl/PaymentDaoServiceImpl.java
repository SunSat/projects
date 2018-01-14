package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.DaoUtil;
import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;
import com.sunsat.sathish.j2ee.store.dao.model.PaymentDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 1/14/2018.
 */
public class PaymentDaoServiceImpl extends BaseDaoServiceImpl {
    public int delete(PaymentDaoModel model) throws SQLException {
        String sql = "delete from payment where paymentid=?";
        PreparedStatement delSt = null;
        int deleteCount = 0 ;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            delSt = con.prepareStatement(sql);
            delSt.setInt(1, model.getPaymentId());
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

    public int add(PaymentDaoModel model) throws SQLException {
        String sql = "insert into payment (paymentid,userid,payment_type,card_user_name,card_no,card_expiry_date,card_type," +
                "bank_name,user_name) " + "values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement insertSt = null;
        int maxId = getMaxId("payment","paymentid");
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            insertSt = con.prepareStatement(sql);
            insertSt.setInt(1, maxId);
            insertSt.setInt(2, model.getUserId());
            insertSt.setString(3, model.getPaymentType());
            insertSt.setString(4, model.getCardUserName());
            insertSt.setInt(5, model.getCardNo());
            insertSt.setDate(6, new java.sql.Date(model.getCardExpiryDate().getTime()));
            insertSt.setString(7, model.getCardType());
            insertSt.setString(8, model.getBankName());
            insertSt.setString(9, model.getUserName());
            insertSt.execute();
            con.commit();
            con.setAutoCommit(true);
        } finally {
            if(null != insertSt)
                insertSt.close();
        }
        return maxId;
    }


    public int update(PaymentDaoModel model) throws SQLException {
        String sql = "update payment set userid=?,payment_type=?,card_user_name=?,card_no=?,card_expiry_date=?,card_type=?," +
                "bank_name=?,user_name=? where paymentid=?";
        PreparedStatement updateSt = null;
        int updateCount = 0;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            updateSt = con.prepareStatement(sql);
            updateSt.setInt(1, model.getUserId());
            updateSt.setString(2, model.getPaymentType());
            updateSt.setString(3, model.getCardUserName());
            updateSt.setInt(4, model.getCardNo());
            updateSt.setDate(5, new java.sql.Date(model.getCardExpiryDate().getTime()));
            updateSt.setString(6, model.getCardType());
            updateSt.setString(7, model.getBankName());
            updateSt.setString(8, model.getUserName());
            updateSt.setInt(9, model.getPaymentId());
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


    public List<PaymentDaoModel> getByName(String name) throws SQLException {
        return null;
    }

    public PaymentDaoModel getById(int id) throws SQLException {
        String sql = "select * from payment where paymentid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        PaymentDaoModel model = new PaymentDaoModel();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, id);
            rs = getState.executeQuery();
            while(rs.next()) {
                model.setPaymentId(rs.getInt("paymentid"));
                model.setUserId(rs.getInt("userid"));
                model.setPaymentType(rs.getString("payment_type"));
                model.setCardUserName(rs.getString("description"));
                model.setCardNo(rs.getInt("card_no"));
                model.setCardExpiryDate(DaoUtil.convertSqlToJavaDate(rs.getDate("card_expiry_date")));
                model.setCardType(rs.getString("card_type"));
                model.setBankName(rs.getString("bank_name"));
                model.setUserName(rs.getString("user_name"));
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

    public List<PaymentDaoModel> getAllByName(String objName) throws SQLException{
        return null;
    }

    public List<PaymentDaoModel> getPaymentByUserId(int userId) throws SQLException {
        String sql = "select * from payment where userid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<PaymentDaoModel> allPaymentLi = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, userId);
            rs = getState.executeQuery();
            while(rs.next()) {
                PaymentDaoModel model = new PaymentDaoModel();
                model.setPaymentId(rs.getInt("paymentid"));
                model.setUserId(rs.getInt("userid"));
                model.setPaymentType(rs.getString("payment_type"));
                model.setCardUserName(rs.getString("description"));
                model.setCardNo(rs.getInt("card_no"));
                model.setCardExpiryDate(DaoUtil.convertSqlToJavaDate(rs.getDate("card_expiry_date")));
                model.setCardType(rs.getString("card_type"));
                model.setBankName(rs.getString("bank_name"));
                model.setUserName(rs.getString("user_name"));
                allPaymentLi.add(model);
            }
        }finally {
            if(getState != null) {
                getState.close();
            }
            if(rs!= null){
                rs.close();
            }
        }
        return allPaymentLi;
    }

    public static void main(String[] args) {
    }
}
