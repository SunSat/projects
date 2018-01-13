package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;
import com.sunsat.sathish.j2ee.store.dao.model.CategoryDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 1/12/2018.
 */
public class CategoryServiceImpl extends BaseServiceImpl {

    public int delete(CategoryDaoModel model) throws SQLException {
        String sql = "delete from category where categoryid=?";
        PreparedStatement delSt = null;
        int deleteCount = 0 ;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            delSt = con.prepareStatement(sql);
            delSt.setInt(1, model.getCategoryid());
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

    public int add(CategoryDaoModel model) throws SQLException {
        String sql = "insert into category (categoryid, parent_category_id, category_name) values (?,?,?,?)";
        PreparedStatement insertSt = null;
        int maxId = getMaxId("category","categoryid");
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            insertSt = con.prepareStatement(sql);
            insertSt.setInt(1, maxId);
            insertSt.setInt(2, model.getParentCategoryId());
            insertSt.setString(3, model.getName());
            insertSt.execute();
            con.commit();
            con.setAutoCommit(true);
        } finally {
            if(null != insertSt)
                insertSt.close();
        }
        return maxId;
    }


    public int update(CategoryDaoModel model) throws SQLException {
        String sql = "update category set parent_category_id = ?, category_name = ? where categoryid = ?";
        PreparedStatement updateSt = null;
        int updateCount = 0;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            updateSt = con.prepareStatement(sql);
            updateSt.setInt(1, model.getParentCategoryId());
            updateSt.setString(2,model.getName());
            updateSt.setInt(3,model.getCategoryid());
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


    public List<CategoryDaoModel> getByName(String name) throws SQLException {
        String sql = "select * from category where category_name = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        List<CategoryDaoModel> userLi = new ArrayList<>();
        Connection con = null;
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setString(1,name);
            rs = getState.executeQuery();
            while(rs.next()) {
                CategoryDaoModel model = new CategoryDaoModel();
                model.setCategoryid(rs.getInt("categoryid"));
                model.setParentCategoryId(rs.getInt("parent_category_id"));
                model.setName(rs.getString("category_name"));
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

    public CategoryDaoModel getById(int id) throws SQLException {
        String sql = "select * from category where categoryid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        CategoryDaoModel model = new CategoryDaoModel();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, id);
            rs = getState.executeQuery();
            while(rs.next()) {
                model.setCategoryid(rs.getInt("categoryid"));
                model.setParentCategoryId(rs.getInt("parent_category_id"));
                model.setName(rs.getString("name"));
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
    public List<CategoryDaoModel> getAllChildByParentId(int parentId) throws SQLException {
        String sql = "select * from category where parent_category_id = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<CategoryDaoModel> listOfCategoryModel = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, parentId);
            rs = getState.executeQuery();
            while(rs.next()) {
                CategoryDaoModel model = new CategoryDaoModel();
                model.setCategoryid(rs.getInt("categoryid"));
                model.setParentCategoryId(rs.getInt("parent_category_id"));
                model.setName(rs.getString("name"));
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
