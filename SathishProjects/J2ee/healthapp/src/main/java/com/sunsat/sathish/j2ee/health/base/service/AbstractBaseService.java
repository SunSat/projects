package com.sunsat.sathish.j2ee.health.base.service;

import com.sunsat.sathish.j2ee.health.base.exceptionHandler.PersistorException;
import com.sunsat.sathish.j2ee.health.base.persistor.DaoPersistor;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.BaseDao;
import com.sunsat.sathish.j2ee.health.base.pojo.model.BaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
public abstract class AbstractBaseService<Bm extends BaseModel> implements BaseService<Bm> {

    DaoPersistor persistor = DaoPersistor.getInstance();

    @Override
    public ResultSet getByPrimaryKey(Bm baseModel) {
        String tableName = baseModel.getType().toLowerCase();
        String sql = "select * from " +tableName+ " where id = ?";
        Connection con = persistor.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1,baseModel.getPrimarykeyId());
            return ps.executeQuery();
        }catch (SQLException sqe) {
            throw new PersistorException(sqe.getMessage(),"Error while fetching primary key id.","Tahle may not have primarykey for the key" +baseModel.getPrimarykeyId());
        }
    }

    @Override
    public ResultSet getAllByType(Bm basemodel) {
        return null;
    }

    @Override
    public ResultSet getByColumnName(String columnName, String value, Class columnType) {
        return null;
    }

    @Override
    public Long getMaxRow(Bm baseModel) {
        String tableName = baseModel.getType();
        String sql = "select max(id) from "+tableName;
        Connection con = persistor.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs == null) {
                return 0l;
            }
            return rs.getLong(1);
        } catch (SQLException sqe) {
            throw new PersistorException(sqe.getMessage(),"Error while fetching primary key id.","Tahle may not have primarykey for the key" +baseModel.getPrimarykeyId());
        }
    }

    @Override
    public Long add(Bm baseModel) {
        return null;
    }

    @Override
    public boolean delete(Bm baseMolel) {
        return false;
    }

    @Override
    public boolean update(Bm baseModel) {
        return false;
    }

    @Override
    public ResultSet getByQuery(String query) {
        return null;
    }
}
