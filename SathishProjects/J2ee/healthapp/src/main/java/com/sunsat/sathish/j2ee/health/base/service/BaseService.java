package com.sunsat.sathish.j2ee.health.base.service;

import com.sunsat.sathish.j2ee.health.base.pojo.dao.BaseDao;
import com.sunsat.sathish.j2ee.health.base.pojo.model.BaseModel;
import com.sunsat.sathish.j2ee.health.base.service.condition.CriteriaFiltter;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
public interface BaseService<Bm extends BaseModel> {

    public ResultSet getByPrimaryKey(Bm baseModel);
    public ResultSet getAllByType(Bm basemodel);
    public ResultSet getByColumnName(String columnName,String value, Class columnType);
    public Long getMaxRow(Bm baseModel);
    public Long add(Bm baseModel);
    public boolean delete(Bm baseMolel);
    public boolean update(Bm baseModel);
    public ResultSet getByQuery(String query);

}
