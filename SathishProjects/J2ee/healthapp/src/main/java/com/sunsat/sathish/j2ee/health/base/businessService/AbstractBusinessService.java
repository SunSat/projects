package com.sunsat.sathish.j2ee.health.base.businessService;

import com.sunsat.sathish.j2ee.health.base.pojo.model.AbstractBaseModel;
import com.sunsat.sathish.j2ee.health.base.pojo.model.BaseModel;

import java.util.List;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
public abstract class AbstractBusinessService<BM extends AbstractBaseModel> implements BaseBusinessService<BM> {

   /* DaoPersistor persistor = DaoPersistor.getInstance();

    @Override
    public ResultSet getByPrimaryKey(BM baseModel) {
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
    public ResultSet getAllByType(BM basemodel) {
        return null;
    }

    @Override
    public ResultSet getByColumnName(String columnName, String value, Class columnType) {
        return null;
    }

    @Override
    public Long getMaxRow(BM baseModel) {
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
    public Long save(BM baseModel) {
        return null;
    }

    @Override
    public boolean delete(BM baseMolel) {
        return false;
    }

    @Override
    public boolean update(BM baseModel) {
        return false;
    }

    @Override
    public ResultSet getByQuery(String query) {
        return null;
    }*/



    @Override
    public BM getByPrimarykey(BM baseModel) {
        return null;
    }

    @Override
    public List<BM> getAllByType(BM baseModel) {
        return null;
    }

    @Override
    public List<BM> getByQuery(String query) {
        return null;
    }

    @Override
    public Long getMaxRow(BM baseModel) {
        return null;
    }

    @Override
    public BM save(BM baseModel) {
        return null;
    }

    @Override
    public boolean delete(BM baseMolel) {
        return false;
    }

    @Override
    public boolean update(BM baseModel) {
        return false;
    }

    @Override
    public Long getCount(BM baseModel) {
        return null;
    }

    public boolean sendMail(BM mailModel) {
        return false;
    }
}
