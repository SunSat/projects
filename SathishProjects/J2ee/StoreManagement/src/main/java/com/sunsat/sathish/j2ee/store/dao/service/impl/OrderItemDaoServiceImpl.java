package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;
import com.sunsat.sathish.j2ee.store.dao.model.OrderItemDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 1/13/2018.
 */
public class OrderItemDaoServiceImpl extends BaseDaoServiceImpl {
    public int delete(OrderItemDaoModel model) throws SQLException {
        String sql = "delete from order_item where id=?";
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

    public int add(OrderItemDaoModel model) throws SQLException {
        String sql = "insert into order_item (id,orderid,itemid,quantity,each_item_cost,total_cost) " +
                "values (?,?,?,?,?,?)";
        PreparedStatement insertSt = null;
        int maxId = getMaxId("order_item","id");
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            insertSt = con.prepareStatement(sql);
            insertSt.setInt(1, maxId);
            insertSt.setInt(2, model.getOrderId());
            insertSt.setInt(3, model.getItemId());
            insertSt.setInt(4, model.getQuantity());
            insertSt.setFloat(5, model.getEachItemCost());
            insertSt.setFloat(6, model.getTotalCost());
            insertSt.execute();
            con.commit();
            con.setAutoCommit(true);
        } finally {
            if(null != insertSt)
                insertSt.close();
        }
        return maxId;
    }


    public int update(OrderItemDaoModel model) throws SQLException {
        String sql = "update order_item set orderid=?, itemid=?, quantity=?, each_item_cost=?, total_cost=? where userid=?";
        PreparedStatement updateSt = null;
        int updateCount = 0;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            updateSt = con.prepareStatement(sql);
            updateSt.setInt(1, model.getOrderId());
            updateSt.setInt(2, model.getItemId());
            updateSt.setInt(3, model.getQuantity());
            updateSt.setFloat(4, model.getEachItemCost());
            updateSt.setFloat(5, model.getTotalCost());
            updateSt.setInt(6,model.getId());
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


    public List<OrderItemDaoModel> getByName(String name) throws SQLException {
        return null;
    }

    public OrderItemDaoModel getById(int id) throws SQLException {
        String sql = "select * from order_item where id = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        OrderItemDaoModel model = new OrderItemDaoModel();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, id);
            rs = getState.executeQuery();
            while(rs.next()) {
                model.setId(rs.getInt("id"));
                model.setOrderId(rs.getInt("userid"));
                model.setItemId(rs.getInt("itemid"));
                model.setQuantity(rs.getInt("quantity"));
                model.setEachItemCost(rs.getFloat("each_item_cost"));
                model.setTotalCost(rs.getFloat("total_cost"));
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

    public List<OrderItemDaoModel> getAllByName(String objName) throws SQLException{
        return null;
    }


    public List<OrderItemDaoModel> getAllItemByOrderId(int orderId) throws SQLException {
        String sql = "select * from order_item where orderid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<OrderItemDaoModel> listOfItemByOrderId = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, orderId);
            rs = getState.executeQuery();
            while(rs.next()) {
                OrderItemDaoModel model = new OrderItemDaoModel();
                model.setId(rs.getInt("id"));
                model.setOrderId(rs.getInt("userid"));
                model.setItemId(rs.getInt("itemid"));
                model.setQuantity(rs.getInt("quantity"));
                model.setEachItemCost(rs.getFloat("each_item_cost"));
                model.setTotalCost(rs.getFloat("total_cost"));
                listOfItemByOrderId.add(model);
            }
        }finally {
            if(getState != null) {
                getState.close();
            }
            if(rs!= null){
                rs.close();
            }
        }
        return listOfItemByOrderId;
    }

    public List<OrderItemDaoModel> getAllOrdersByItemId(int itemId) throws SQLException {
        String sql = "select * from order_item where itemid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<OrderItemDaoModel> listOfOrdersByItemId = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, itemId);
            rs = getState.executeQuery();
            while(rs.next()) {
                OrderItemDaoModel model = new OrderItemDaoModel();
                model.setId(rs.getInt("id"));
                model.setOrderId(rs.getInt("userid"));
                model.setItemId(rs.getInt("itemid"));
                model.setQuantity(rs.getInt("quantity"));
                model.setEachItemCost(rs.getFloat("each_item_cost"));
                model.setTotalCost(rs.getFloat("total_cost"));
                listOfOrdersByItemId.add(model);
            }
        }finally {
            if(getState != null) {
                getState.close();
            }
            if(rs!= null){
                rs.close();
            }
        }
        return listOfOrdersByItemId;
    }


    public static void main(String[] args) {

    }
}
