package com.sunsat.sathish.j2ee.store.dao.service.impl;

import com.sunsat.sathish.j2ee.store.dao.manager.DaoManager;
import com.sunsat.sathish.j2ee.store.dao.model.AddressDaoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 1/11/2018.
 */
public class AddressServiceImpl extends BaseServiceImpl {

    public int delete(AddressDaoModel model) throws SQLException {
        String sql = "delete from address where addressid=?";
        PreparedStatement delSt = null;
        int deleteCount = 0 ;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            delSt = con.prepareStatement(sql);
            delSt.setInt(1, model.getAddressId());
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

    public int add(AddressDaoModel model) throws SQLException {
        String sql = "insert into address (addressid,userid,type,address1,address2,city,state,country,zip_code,landmark) " +
                "values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedSt = null;
        int maxId = getMaxId("address","addressid");
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            preparedSt = con.prepareStatement(sql);
            preparedSt.setInt(1, maxId);
            preparedSt.setInt(2, model.getUserId());
            preparedSt.setString(3, model.getType());
            preparedSt.setString(4, model.getAddress1());
            preparedSt.setString(5, model.getAddress2());
            preparedSt.setString(6, model.getCity());
            preparedSt.setString(7, model.getState());
            preparedSt.setString(8, model.getCity());
            preparedSt.setString(9, model.getZipCode());
            preparedSt.setString(10, model.getLandmark());
            preparedSt.execute();
            con.commit();
            con.setAutoCommit(true);
        } finally {
            if(null != preparedSt)
                preparedSt.close();
        }
        return maxId;
    }

    public int update(AddressDaoModel model) throws SQLException {
        String sql = "update address set userid=?,type=?,address1=?,address2=?,city=?,state=?,country=?,zip_code=?, landmark=?"
                + " where addressid=?";
        PreparedStatement preparedSt = null;
        int updateCount = 0;
        Connection con = DaoManager.getConnection();
        try {
            con.setAutoCommit(false);
            preparedSt = con.prepareStatement(sql);
            preparedSt.setInt(1, model.getUserId());
            preparedSt.setString(2, model.getType());
            preparedSt.setString(3, model.getAddress1());
            preparedSt.setString(4, model.getAddress2());
            preparedSt.setString(5, model.getCity());
            preparedSt.setString(6, model.getState());
            preparedSt.setString(7, model.getCity());
            preparedSt.setString(8, model.getZipCode());
            preparedSt.setString(9, model.getLandmark());
            preparedSt.setInt(10,model.getAddressId());
            updateCount = preparedSt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        }finally {
            if(preparedSt != null) {
                preparedSt.close();
            }
        }
        return updateCount;
    }


    public List<AddressDaoModel> getByName(String name) throws SQLException {
        /*
        String sql = "select * from address where address1 like %?%";
        PreparedStatement getState = null;
        ResultSet rs = null;
        List<AddressDaoModel> userLi = new ArrayList<>();
        Connection con = null;
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            rs = getState.executeQuery();
            while(rs.next()) {
                AddressDaoModel model = new AddressDaoModel();
                model.setAddressId(rs.getInt("addressid"));
                model.setUserId(rs.getInt("userid"));
                model.setType(rs.getString("type"));
                model.setAddress1(rs.getString("address1"));
                model.setAddress2(rs.getString("address2"));
                model.setCity(rs.getString("city"));
                model.setState(rs.getString("state"));
                model.setCountry(rs.getString("country"));
                model.setZipCode(rs.getString("zip_code"));
                model.setLandmark(rs.getString("landmark"));
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
        return userLi; */
        return null;
    }

    public AddressDaoModel getById(int addressId) throws SQLException {
        String sql = "select * from address where addressid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        AddressDaoModel model = new AddressDaoModel();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1,addressId);
            rs = getState.executeQuery();
            while(rs.next()) {
                model.setAddressId(rs.getInt("addressid"));
                model.setUserId(rs.getInt("userid"));
                model.setType(rs.getString("type"));
                model.setAddress1(rs.getString("address1"));
                model.setAddress2(rs.getString("address2"));
                model.setCity(rs.getString("city"));
                model.setState(rs.getString("state"));
                model.setCountry(rs.getString("country"));
                model.setZipCode(rs.getString("zip_code"));
                model.setLandmark(rs.getString("landmark"));
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

    public List<AddressDaoModel> getAllAddressByUserId(int userId) throws SQLException {
        String sql = "select * from address where userid = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        Connection con = null;
        List<AddressDaoModel> addressLi = new ArrayList<>();
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setInt(1,userId);
            rs = getState.executeQuery();
            while(rs.next()) {
                AddressDaoModel model = new AddressDaoModel();
                model.setAddressId(rs.getInt("addressid"));
                model.setUserId(rs.getInt("userid"));
                model.setType(rs.getString("type"));
                model.setAddress1(rs.getString("address1"));
                model.setAddress2(rs.getString("address2"));
                model.setCity(rs.getString("city"));
                model.setState(rs.getString("state"));
                model.setCountry(rs.getString("country"));
                model.setZipCode(rs.getString("zip_code"));
                model.setLandmark(rs.getString("landmark"));
                addressLi.add(model);
            }
        }finally {
            if(getState != null) {
                getState.close();
            }
            if(rs!= null){
                rs.close();
            }
        }
        return addressLi;
    }
    public List<AddressDaoModel> getAllByName(String objName) throws SQLException{
        /*
        String sql = "select * from user where first_name = ?";
        PreparedStatement getState = null;
        ResultSet rs = null;
        List<AddressDaoModel> userLi = new ArrayList<>();
        Connection con = null;
        try {
            con = DaoManager.getConnection();
            getState = con.prepareStatement(sql);
            getState.setString(1,objName);
            rs = getState.executeQuery();
            while(rs.next()) {
                AddressDaoModel model = new AddressDaoModel();
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
        return userLi;*/
        return null;
    }

    public static void main(String[] args) {
        AddressDaoModel daoModel = new AddressDaoModel();
        //daoModel.setAddressId(1);
        daoModel.setUserId(5);
        daoModel.setType("Home");
        daoModel.setAddress1("127/24");
        daoModel.setAddress2("Helloworld");
        daoModel.setCity("Chennai");
        daoModel.setState("Tamil Nadu");
        daoModel.setCountry("India");
        daoModel.setZipCode("600100");
        daoModel.setLandmark("near");

        AddressServiceImpl impl = new AddressServiceImpl();
        try {
            impl.add(daoModel);
        }catch (SQLException sqe) {
            sqe.printStackTrace();
        }

        /*try {
            List<AddressDaoModel> liModel = impl.getAllByName("Anitha");
            System.out.println(liModel);
            AddressDaoModel model = liModel.get(0);
            AddressDaoModel model1 = impl.getById(model.getId());
            System.out.println(model1.getFirstName());
            impl.delete(model1);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

}