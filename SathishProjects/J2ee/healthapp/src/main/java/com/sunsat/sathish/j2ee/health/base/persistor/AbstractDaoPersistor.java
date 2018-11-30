package com.sunsat.sathish.j2ee.health.base.persistor;

import com.sunsat.sathish.j2ee.health.base.pojo.business.BaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.BaseDao;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.UserDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sathishkumar_su on 4/16/2018.
 */
@Repository("abstractDaoPersistor")
public abstract class  AbstractDaoPersistor<BD extends BaseDao,BB extends BaseBusiness> implements BaseDaoPersistor<BD,BB> {

    @Autowired
    SessionFactory factory;

    @Override
    public BD persist(BB bb) {
        Session ses = factory.openSession();
        Transaction tx = ses.beginTransaction();
        BD bd = this.createDao();
        bd.setBusinessValue(bb);
        ses.save(bd);
        tx.commit();
        ses.close();
        return bd;
    }

    @Override
    public BD getByPrimaryKey(BB bb) {
        Session ses = factory.openSession();
        Transaction tx = ses.beginTransaction();
        BD baseDao = (BD)ses.get(this.getDaoClass(),bb.getPrimarykeyId());
        return baseDao;
    }

    @Override
    public List<BD> getByBusinessKey(BB bb, List<Criteria> criteriaList) {
        Session ses = factory.openSession();
        Transaction tx = ses.beginTransaction();
        Criteria cr = ses.createCriteria(bb.getClass());
        return null;
    }

    @Override
    public BD update(BB bb) {
        return null;
    }

    @Override
    public BD deleteByPrimaryKey(BB bb) {
        return null;
    }

    @Override
    public BD getMaxNumber(BB bb) {
        return null;
    }

    @Override
    public List<BD> getByQuery(Class type, String queryst) {
        Session ses = factory.openSession();
        Transaction tx = ses.beginTransaction();
        Query<BD> query = ses.createQuery(queryst,type);

        List<BD> resLi = query.getResultList();
        tx.commit();
        ses.close();
        return resLi;
    }

    @Override
    public List<BD> getByQuery(String queryst) {
        Session ses = factory.openSession();
        Transaction tx = ses.beginTransaction();
        Query<BD> query = ses.createQuery(queryst);
        List<BD> resLi = query.getResultList();
        tx.commit();
        ses.close();
        return resLi;
    }
}
