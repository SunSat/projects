package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;
import com.sunsat.sathish.j2ee.store.dao.model.ItemDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 1/8/2018.
 */
public class ItemDaoServiceImpl extends BaseDaoServiceImpl {

    public int delete(ItemDaoModel model) throws SQLException {
        String sql = "delete from item where itemid=?";
        PreparedStatement delSt = null;
        int deleteCount = 0 ;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            delSt = con.prepareStatement(sql);
            delSt.setInt(1, model.getItemId());
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

    public int add(ItemDaoModel model) throws SQLException {
        String sql = "insert into item (itemid,name,description,initial_price,reserved_price,start_date,end_date,quantity,state) " +
                "values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement insertSt = null;
        int maxId = getMaxId("item","itemid");
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            insertSt = con.prepareStatement(sql);
            insertSt.setInt(1, maxId);
            insertSt.setString(2, model.getName());
            insertSt.setString(3, model.getDescription());
            insertSt.setFloat(4, model.getInitial_price());
            insertSt.setFloat(5, model.getReserved_price());
            insertSt.setDate(6, new java.sql.Date(model.getStart_date().getTime()));
            insertSt.setDate(7, new java.sql.Date(model.getEnd_date().getTime()));
            insertSt.setInt(8, model.getQuantity());
            insertSt.setString(9, model.getState());
            insertSt.execute();
            con.commit();
            con.setAutoCommit(true);
        } finally {
            if(null != insertSt)
                insertSt.close();
        }
        return maxId;
    }


    public int update(ItemDaoModel model) throws SQLException {
        String sql = "update item set name=?,description=?,initial_price=?,reserved_price=?,start_date=?,end_date=?,quantity=?,state=?"
                + " where userid=?";
        PreparedStatement updateSt = null;
        int updateCount = 0;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            updateSt = con.prepareStatement(sql);
            updateSt.setString(1,model.getName());
            updateSt.setString(2,model.getDescription());
            updateSt.setFloat(3, model.getInitial_price());
            updateSt.setFloat(4, model.getReserved_price());
            updateSt.setDate(5, new java.sql.Date(model.getStart_date().getTime()));
            updateSt.setDate(6, new java.sql.Date(model.getEnd_date().getTime()));
            updateSt.setInt(7,model.getQuantity());
            updateSt.setString(8,model.getState());
            updateSt.setInt(9,model.getItemId());
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


    public List<ItemDaoModel> getByName(String name) throws SQLException {
        String sql = "select * from item where name = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        List<ItemDaoModel> userLi = new ArrayList<>();
        Connection con = null;
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setString(1,name);
            rs = getState.executeQuery();
            while(rs.next()) {
                ItemDaoModel model = new ItemDaoModel();
                model.setItemId(rs.getInt("itemid"));
                model.setName(rs.getString("name"));
                model.setDescription(rs.getString("description"));
                model.setInitial_price(rs.getFloat("initial_price"));
                model.setReserved_price(rs.getFloat("reserved_price"));
                model.setStart_date(rs.getDate("start_date"));
                model.setEnd_date(rs.getDate("end_date"));
                model.setQuantity(rs.getInt("quantity"));
                model.setState(rs.getString("state"));
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
        return userLi;
    }

    public ItemDaoModel getById(int id) throws SQLException {
        String sql = "select * from item where itemid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        ItemDaoModel model = new ItemDaoModel();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, id);
            rs = getState.executeQuery();
            while(rs.next()) {
                model.setItemId(rs.getInt("itemid"));
                model.setName(rs.getString("name"));
                model.setDescription(rs.getString("description"));
                model.setInitial_price(rs.getFloat("initial_price"));
                model.setReserved_price(rs.getFloat("reserved_price"));
                model.setStart_date(rs.getDate("start_date"));
                model.setEnd_date(rs.getDate("end_date"));
                model.setQuantity(rs.getInt("quantity"));
                model.setState(rs.getString("state"));
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

    public List<ItemDaoModel> getAllByName(String objName) throws SQLException{
        String sql = "select * from item where name = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        List<ItemDaoModel> userLi = new ArrayList<>();
        Connection con = null;
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setString(1,objName);
            rs = getState.executeQuery();
            while(rs.next()) {
                ItemDaoModel model = new ItemDaoModel();
                model.setItemId(rs.getInt("itemid"));
                model.setName(rs.getString("name"));
                model.setDescription(rs.getString("description"));
                model.setInitial_price(rs.getFloat("initial_price"));
                model.setReserved_price(rs.getFloat("reserved_price"));
                model.setStart_date(new java.util.Date(rs.getDate("start_date").getTime()));
                model.setEnd_date(new java.util.Date(rs.getDate("end_date").getTime()));
                model.setQuantity(rs.getInt("quantity"));
                model.setState(rs.getString("state"));
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
        return userLi;
    }

    public static void main(String[] args) {
        ItemDaoModel daoModel = new ItemDaoModel();
        daoModel.setName("Box");
        daoModel.setDescription("Good Model");
        daoModel.setInitial_price(55.3f);
        daoModel.setReserved_price(56.4f);
        daoModel.setStart_date(new java.util.Date());
        daoModel.setEnd_date(new java.util.Date());
        daoModel.setQuantity(100);
        daoModel.setState("Available");
        ItemDaoServiceImpl impl = new ItemDaoServiceImpl();
        try {
            impl.add(daoModel);
        }catch (SQLException sqe) {
            sqe.printStackTrace();
        }

        try {
            List<ItemDaoModel> liModel = impl.getAllByName("Box");
            System.out.println(liModel);
            ItemDaoModel model = liModel.get(0);
            ItemDaoModel model1 = impl.getById(model.getItemId());
            System.out.println(model1.getName());
            impl.delete(model1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
