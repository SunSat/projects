package com.sunsat.sathish.j2ee.health.base.businessService;

import com.sunsat.sathish.j2ee.health.base.pojo.model.BaseModel;

import java.util.List;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
public interface BaseBusinessService<BM extends BaseModel> {

   public BM getByPrimarykey(BM baseModel);
   public List<BM> getAllByType(BM baseModel);
   public List<BM> getByQuery(String query);
   public Long getMaxRow(BM baseModel);
   public BM save(BM baseModel);
   public boolean delete(BM baseMolel);
   public boolean update(BM baseModel);
   public Long getCount(BM baseModel);
   public boolean sendMail(BM mailModel);
}
