package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;
import com.sunsat.sathish.j2ee.store.dao.model.CategoryItemDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 1/12/2018.
 */
public class CategoryItemDaoServiceImpl extends BaseDaoServiceImpl {
    public int delete(CategoryItemDaoModel model) throws SQLException {
        String sql = "delete from category_item where id=?";
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

    public int add(CategoryItemDaoModel model) throws SQLException {
        String sql = "insert into category_item (id, categoryid, itemid) values (?,?,?,?)";
        PreparedStatement insertSt = null;
        int maxId = getMaxId("category_item","id");
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            insertSt = con.prepareStatement(sql);
            insertSt.setInt(1, maxId);
            insertSt.setInt(2, model.getCategoryId());
            insertSt.setInt(3, model.getItemId());
            insertSt.execute();
            con.commit();
            con.setAutoCommit(true);
        } finally {
            if(null != insertSt)
                insertSt.close();
        }
        return maxId;
    }

    public int update(CategoryItemDaoModel model) throws SQLException {
        String sql = "update category_item set categoryid = ?, itemid = ? where id = ?";
        PreparedStatement updateSt = null;
        int updateCount = 0;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            updateSt = con.prepareStatement(sql);
            updateSt.setInt(1, model.getCategoryId());
            updateSt.setInt(2, model.getItemId());
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


    public List<CategoryItemDaoModel> getByName(String name) throws SQLException {
        return null;
    }

    public CategoryItemDaoModel getById(int id) throws SQLException {
        String sql = "select * from category_item where id = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        CategoryItemDaoModel model = new CategoryItemDaoModel();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, id);
            rs = getState.executeQuery();
            while(rs.next()) {
                model.setId(rs.getInt("id"));
                model.setCategoryId(rs.getInt("categoryid"));
                model.setItemId(rs.getInt("itemid"));
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
    public List<CategoryItemDaoModel> getAllItemByCategoryId(int categoryId) throws SQLException {
        String sql = "select * from category_item where categoryid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<CategoryItemDaoModel> listOfCategoryModel = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, categoryId);
            rs = getState.executeQuery();
            while(rs.next()) {
                CategoryItemDaoModel model = new CategoryItemDaoModel();
                model.setId(rs.getInt("id"));
                model.setCategoryId(rs.getInt("categoryid"));
                model.setItemId(rs.getInt("itemid"));
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
    public List<CategoryItemDaoModel> getCategoryByItemId(int itemid) throws SQLException {
        String sql = "select * from category_item where itemid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<CategoryItemDaoModel> listOfCategoryModel = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, itemid);
            rs = getState.executeQuery();
            while(rs.next()) {
                CategoryItemDaoModel model = new CategoryItemDaoModel();
                model.setId(rs.getInt("id"));
                model.setCategoryId(rs.getInt("categoryid"));
                model.setItemId(rs.getInt("itemid"));
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
