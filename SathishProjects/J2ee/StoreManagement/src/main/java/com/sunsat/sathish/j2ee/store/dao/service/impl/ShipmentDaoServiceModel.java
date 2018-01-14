package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.DaoUtil;
import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;
import com.sunsat.sathish.j2ee.store.dao.model.ShipmentDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 1/14/2018.
 */
public class ShipmentDaoServiceModel extends BaseDaoServiceImpl {
    public int delete(ShipmentDaoModel model) throws SQLException {
        String sql = "delete from shipment where shipmentid=?";
        PreparedStatement delSt = null;
        int deleteCount = 0 ;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            delSt = con.prepareStatement(sql);
            delSt.setInt(1, model.getShipmentId());
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

    public int add(ShipmentDaoModel model) throws SQLException {
        String sql = "insert into shipment (shipmentid, orderid, itemid, userid, addressid, current_state, shipment_date) " +
                "values (?,?,?,?,?,?,?)";
        PreparedStatement insertSt = null;
        int maxId = getMaxId("shipment","shipmentid");
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            insertSt = con.prepareStatement(sql);
            insertSt.setInt(1, model.getShipmentId());
            insertSt.setInt(2, model.getOrderId());
            insertSt.setInt(3, model.getItemId());
            insertSt.setInt(4, model.getUserId());
            insertSt.setInt(5, model.getAddressId());
            insertSt.setString(6, model.getCurrentState());
            insertSt.setDate(7, DaoUtil.convertJavaToSqlDate(model.getShipmentDate()));
            insertSt.execute();
            con.commit();
            con.setAutoCommit(true);
        } finally {
            if(null != insertSt)
                insertSt.close();
        }
        return maxId;
    }

    public int update(ShipmentDaoModel model) throws SQLException {
        String sql = "update shipment set orderid = ? , itemid = ? , userid = ? , addressid = ? , current_state = ? , shipment_date = ?"
                + "where shipmentid = ?";
        PreparedStatement updateSt = null;
        int updateCount = 0;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            updateSt = con.prepareStatement(sql);
            updateSt.setInt(1, model.getOrderId());
            updateSt.setInt(2, model.getItemId());
            updateSt.setInt(3, model.getUserId());
            updateSt.setInt(4, model.getAddressId());
            updateSt.setString(5, model.getCurrentState());
            updateSt.setDate(6, DaoUtil.convertJavaToSqlDate(model.getShipmentDate()));
            updateSt.setInt(7, model.getShipmentId());
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

    public List<ShipmentDaoModel> getByName(String name) throws SQLException {
        return null;
    }

    public ShipmentDaoModel getById(int id) throws SQLException {
        String sql = "select * from shipment where shipmentid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        ShipmentDaoModel model = new ShipmentDaoModel();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, id);
            rs = getState.executeQuery();
            while(rs.next()) {
                model.setShipmentId(rs.getInt("paymentid" ));
                model.setOrderId(rs.getInt("orderid"));
                model.setItemId(rs.getInt("itemid" ));
                model.setUserId(rs.getInt("userid"));
                model.setAddressId(rs.getInt("addreddid"));
                model.setCurrentState(rs.getString("current_state"));
                model.setShipmentDate(DaoUtil.convertSqlToJavaDate(rs.getDate("shipment_date")));
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
    public List<ShipmentDaoModel> getAllShipmentByOrderId(int orderId) throws SQLException {
        String sql = "select * from shipment where categoryid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<ShipmentDaoModel> listOfCategoryModel = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, orderId);
            rs = getState.executeQuery();
            while(rs.next()) {
                ShipmentDaoModel model = new ShipmentDaoModel();
                model.setShipmentId(rs.getInt("paymentid" ));
                model.setOrderId(rs.getInt("orderid"));
                model.setItemId(rs.getInt("itemid" ));
                model.setUserId(rs.getInt("userid"));
                model.setAddressId(rs.getInt("addreddid"));
                model.setCurrentState(rs.getString("current_state"));
                model.setShipmentDate(DaoUtil.convertSqlToJavaDate(rs.getDate("shipment_date")));
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
    public List<ShipmentDaoModel> getAllShipmentByItemId(int itemId) throws SQLException {
        String sql = "select * from shipment where categoryid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<ShipmentDaoModel> listOfCategoryModel = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, itemId);
            rs = getState.executeQuery();
            while(rs.next()) {
                ShipmentDaoModel model = new ShipmentDaoModel();
                model.setShipmentId(rs.getInt("paymentid" ));
                model.setOrderId(rs.getInt("orderid"));
                model.setItemId(rs.getInt("itemid" ));
                model.setUserId(rs.getInt("userid"));
                model.setAddressId(rs.getInt("addreddid"));
                model.setCurrentState(rs.getString("current_state"));
                model.setShipmentDate(DaoUtil.convertSqlToJavaDate(rs.getDate("shipment_date")));
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

    public List<ShipmentDaoModel> getAllShipmentByUserId(int userId) throws SQLException {
        String sql = "select * from shipment where categoryid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<ShipmentDaoModel> listOfCategoryModel = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, userId);
            rs = getState.executeQuery();
            while(rs.next()) {
                ShipmentDaoModel model = new ShipmentDaoModel();
                model.setShipmentId(rs.getInt("paymentid" ));
                model.setOrderId(rs.getInt("orderid"));
                model.setItemId(rs.getInt("itemid" ));
                model.setUserId(rs.getInt("userid"));
                model.setAddressId(rs.getInt("addreddid"));
                model.setCurrentState(rs.getString("current_state"));
                model.setShipmentDate(DaoUtil.convertSqlToJavaDate(rs.getDate("shipment_date")));
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

    public List<ShipmentDaoModel> getAllShipmentByAddressId(int addressId) throws SQLException {
        String sql = "select * from shipment where categoryid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<ShipmentDaoModel> listOfCategoryModel = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, addressId);
            rs = getState.executeQuery();
            while(rs.next()) {
                ShipmentDaoModel model = new ShipmentDaoModel();
                model.setShipmentId(rs.getInt("paymentid" ));
                model.setOrderId(rs.getInt("orderid"));
                model.setItemId(rs.getInt("itemid" ));
                model.setUserId(rs.getInt("userid"));
                model.setAddressId(rs.getInt("addreddid"));
                model.setCurrentState(rs.getString("current_state"));
                model.setShipmentDate(DaoUtil.convertSqlToJavaDate(rs.getDate("shipment_date")));
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
