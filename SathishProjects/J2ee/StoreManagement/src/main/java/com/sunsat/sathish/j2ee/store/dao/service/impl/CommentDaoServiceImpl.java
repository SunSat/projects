package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.DaoUtil;
import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;
import com.sunsat.sathish.j2ee.store.dao.model.CommentDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 1/12/2018.
 */
public class CommentDaoServiceImpl extends BaseDaoServiceImpl {

    public int delete(CommentDaoModel model) throws SQLException {
        String sql = "delete from comment where commentid=?";
        PreparedStatement delSt = null;
        int deleteCount = 0 ;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            delSt = con.prepareStatement(sql);
            delSt.setInt(1, model.getCommentId());
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

    public int add(CommentDaoModel model) throws SQLException {
        String sql = "insert into comment (commentid, itemid, userid, rating,comment_text,created_date ) values (?,?,?,?,?,?)";
        PreparedStatement insertSt = null;
        int maxId = getMaxId("comment","commentid");
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            insertSt = con.prepareStatement(sql);
            insertSt.setInt(1, maxId);
            insertSt.setInt(2, model.getItemId());
            insertSt.setInt(3, model.getUserId());
            insertSt.setInt(4, model.getRating());
            insertSt.setString(5, model.getCommentText());
            insertSt.setDate(6, DaoUtil.convertJavaToSqlDate(model.getCreatedDate()));
            insertSt.execute();
            con.commit();
            con.setAutoCommit(true);
        } finally {
            if(null != insertSt)
                insertSt.close();
        }
        return maxId;
    }

    public int update(CommentDaoModel model) throws SQLException {
        String sql = "update comment set itemid = ?, userid = ?,rating = ?,comment_text = ?,created_date = ?, where id = ?";
        PreparedStatement updateSt = null;
        int updateCount = 0;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            updateSt = con.prepareStatement(sql);
            updateSt.setInt(1, model.getItemId());
            updateSt.setInt(2, model.getUserId());
            updateSt.setInt(3,model.getRating());
            updateSt.setString(4, model.getCommentText());
            updateSt.setDate(5,DaoUtil.convertJavaToSqlDate(model.getCreatedDate()));
            updateSt.setInt(6,model.getCommentId());
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


    public List<CommentDaoModel> getByName(String name) throws SQLException {
        return null;
    }

    public CommentDaoModel getById(int id) throws SQLException {
        String sql = "select * from comment where commentid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        CommentDaoModel model = new CommentDaoModel();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, id);
            rs = getState.executeQuery();
            while(rs.next()) {
                model.setCommentId(rs.getInt("commentid"));
                model.setItemId(rs.getInt("itemid"));
                model.setUserId(rs.getInt("userid"));
                model.setRating(rs.getInt("rating"));
                model.setCommentText(rs.getString("comment_text"));
                model.setCreatedDate(DaoUtil.convertSqlToJavaDate(rs.getDate("created_date")));
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
    public List<CommentDaoModel> getAllCommentsByItemId(int itemId) throws SQLException {
        String sql = "select * from comment where itemid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<CommentDaoModel> listOfCategoryModel = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, itemId);
            rs = getState.executeQuery();
            while(rs.next()) {
                CommentDaoModel model = new CommentDaoModel();
                model.setCommentId(rs.getInt("commentid"));
                model.setItemId(rs.getInt("itemid"));
                model.setUserId(rs.getInt("userid"));
                model.setRating(rs.getInt("rating"));
                model.setCommentText(rs.getString("comment_text"));
                model.setCreatedDate(DaoUtil.convertSqlToJavaDate(rs.getDate("created_date")));
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
    public List<CommentDaoModel> getAllCommentsByUserId(int itemId) throws SQLException {
        String sql = "select * from comment where userid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<CommentDaoModel> listOfCategoryModel = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1, itemId);
            rs = getState.executeQuery();
            while(rs.next()) {
                CommentDaoModel model = new CommentDaoModel();
                model.setCommentId(rs.getInt("commentid"));
                model.setItemId(rs.getInt("itemid"));
                model.setUserId(rs.getInt("userid"));
                model.setRating(rs.getInt("rating"));
                model.setCommentText(rs.getString("comment_text"));
                model.setCreatedDate(DaoUtil.convertSqlToJavaDate(rs.getDate("created_date")));
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
