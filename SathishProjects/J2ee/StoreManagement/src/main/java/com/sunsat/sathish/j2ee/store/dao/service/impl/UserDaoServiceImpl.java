package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;
import com.sunsat.sathish.j2ee.store.dao.model.UserDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 1/4/2018.
 */
public class UserDaoServiceImpl extends BaseDaoServiceImpl {

    public int add(UserDaoModel model) throws SQLException {
        String sql = "insert into u_user (userid,first_name,last_name,user_name,password,email,mobile_no,admin,type,rank) " +
                "values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement insertSt = null;
        int maxId = getMaxId("user","userid");
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            insertSt = con.prepareStatement(sql);
            insertSt.setInt(1, maxId);
            insertSt.setString(2, model.getFirstName());
            insertSt.setString(3, model.getLastName());
            insertSt.setString(4, model.getUserName());
            insertSt.setString(5, model.getPassword());
            insertSt.setString(6, model.getEmail());
            insertSt.setString(7, model.getMobileNo());
            insertSt.setString(8, model.isAdmin());
            insertSt.setString(9, model.getType());
            insertSt.setInt(10, model.getRank());
            insertSt.execute();
            con.commit();
            con.setAutoCommit(true);
        } finally {
            if(null != insertSt)
                insertSt.close();
        }
        return maxId;
    }

    public int delete(UserDaoModel model) throws SQLException {
        String sql = "delete from u_user where userid=?";
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

    public int update(UserDaoModel model) throws SQLException {
        String sql = "update u_user set first_name=?,last_name=?,user_name=?,password=?,email=?,mobile_no=?,admin=?,type=?,rank=?"
                + " where userid=?";
        PreparedStatement updateSt = null;
        int updateCount = 0;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            updateSt = con.prepareStatement(sql);
            updateSt.setString(1,model.getFirstName());
            updateSt.setString(2,model.getLastName());
            updateSt.setString(3,model.getUserName());
            updateSt.setString(4,model.getPassword());
            updateSt.setString(5,model.getEmail());
            updateSt.setString(6,model.getMobileNo());
            updateSt.setString(7,model.isAdmin());
            updateSt.setString(8,model.getType());
            updateSt.setInt(9,model.getRank());
            updateSt.setInt(10,model.getId());
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


    public List<UserDaoModel> getByName(String name) throws SQLException {
        String sql = "select * from u_user where user_name = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        List<UserDaoModel> userLi = new ArrayList<>();
        Connection con = null;
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            rs = getState.executeQuery();
            while(rs.next()) {
                UserDaoModel model = new UserDaoModel();
                model.setId(rs.getInt("userid"));
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setUserName(rs.getString("user_name"));
                model.setPassword(rs.getString("password"));
                model.setEmail(rs.getString("email"));
                model.setMobileNo(rs.getString("mobile_no"));
                model.setIsAdmin(rs.getString("admin"));
                model.setType(rs.getString("type"));
                model.setRank(rs.getInt("rank"));
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

    public UserDaoModel getById(int id) throws SQLException {
        String sql = "select * from u_user where userid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        UserDaoModel model = new UserDaoModel();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1,id);
            rs = getState.executeQuery();
            while(rs.next()) {
                model.setId(rs.getInt("userid"));
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setUserName(rs.getString("user_name"));
                model.setPassword(rs.getString("password"));
                model.setEmail(rs.getString("email"));
                model.setMobileNo(rs.getString("mobile_no"));
                model.setIsAdmin(rs.getString("admin"));
                model.setType(rs.getString("type"));
                model.setRank(rs.getInt("rank"));
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

    public List<UserDaoModel> getAllByName(String objName) throws SQLException{
        String sql = "select * from u_user where first_name = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        List<UserDaoModel> userLi = new ArrayList<>();
        Connection con = null;
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setString(1,objName);
            rs = getState.executeQuery();
            while(rs.next()) {
                UserDaoModel model = new UserDaoModel();
                model.setId(rs.getInt("userid"));
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setUserName(rs.getString("user_name"));
                model.setPassword(rs.getString("password"));
                model.setEmail(rs.getString("email"));
                model.setMobileNo(rs.getString("mobile_no"));
                model.setIsAdmin(rs.getString("admin"));
                model.setType(rs.getString("type"));
                model.setRank(rs.getInt("rank"));
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
        UserDaoModel daoModel = new UserDaoModel();
        daoModel.setFirstName("Anitha");
        daoModel.setLastName("Sathish");
        daoModel.setUserName("AniSat");
        daoModel.setPassword("AniSat");
        daoModel.setEmail("lksdjf@gmail.com");
        daoModel.setMobileNo("222222222");
        daoModel.setIsAdmin("true");
        daoModel.setRank(5);
        daoModel.setType("good");
        UserDaoServiceImpl impl = new UserDaoServiceImpl();
        try {
            impl.add(daoModel);
        }catch (SQLException sqe) {
            sqe.printStackTrace();
        }

        try {
            List<UserDaoModel> liModel = impl.getAllByName("Anitha");
            System.out.println(liModel);
            UserDaoModel model = liModel.get(0);
            UserDaoModel model1 = impl.getById(model.getId());
            System.out.println(model1.getFirstName());
            impl.delete(model1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
