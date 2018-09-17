package com.vwr.em.migration.dao.service;

import com.vwr.em.migration.dao.DocumentDao;
import com.vwr.em.migration.dao.manager.PersistanceManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sathishkumar_su on 7/12/2018.
 */
public class DocumentServiceImpl<DocumentDao> implements DocumentService {

    PersistanceManager manager = PersistanceManager.getInstance();

    @Override
    public List<DocumentDao> getAllDocument() {
        SessionFactory factory = manager.getFactory();
        Session ses = null;
        List<DocumentDao> liDocu = null;
        try {
            ses = factory.openSession();
            Query<DocumentDao> query = ses.createQuery("from DocumentDao");
            liDocu = query.list();
        } finally {
            if(null != ses) {
                ses.close();
            }
        }
        return liDocu;
    }

    public Integer getDocumentCount() {
        SessionFactory factory = manager.getFactory();
        Session ses = null;
        Integer totalCount;
        try {
            ses = factory.openSession();
            totalCount = (Integer)ses.createQuery("select count(*) from DocumentDao").uniqueResult();
        } finally {
            if(null != ses) {
                ses.close();
            }
        }
        return totalCount;
    }

    @Override
    public Object getById() {
        return null;
    }

    @Override
    public List<Integer> getUniqueOrgIdFromDocument() {
        SessionFactory factory = manager.getFactory();
        Session ses = null;
        List<Integer> orgIdList = null;
        try {
            ses = factory.openSession();
            Query<Integer> query =ses.createQuery("select distinct orgId from DocumentDao");
            //query.setMaxResults(1);
            orgIdList = query.list();
            System.out.println("DocumentService IMpl, The full list ORGID is " + orgIdList);
        } finally {
            if(null != ses) {
                ses.close();
            }
        }
        return orgIdList;
    }

    @Override
    public List<DocumentDao> getAllByOrgId(Integer orgId) {
        SessionFactory factory = manager.getFactory();
        Session ses = null;
        List<DocumentDao> orgIdList = null;
        try {
            ses = factory.openSession();
            Query<DocumentDao> fromQuery = ses.createQuery("from DocumentDao where orgId = :orgId");
            fromQuery.setParameter("orgId",orgId);
            orgIdList = fromQuery.list();
            System.out.println("Total number of Dodumcnets is : " + orgIdList.size() + " For the ORg_ID : " + orgId);
        } finally {
            if(null != ses) {
                ses.close();
            }
        }
        return orgIdList;
    }

    public List<Integer> getAllDocumentIds() {
        SessionFactory factory = manager.getFactory();
        Session ses = null;
        List<Integer> orgIdList = null;
        try {
            ses = factory.openSession();
            Query<Integer> query = ses.createQuery("select skGuid from DocumentDao ");
            orgIdList = query.list();
        } finally {
            if(null != ses) {
                ses.close();
            }
        }
        return orgIdList;
    }

    public List<DocumentDao> getAllDocumentByOrg(Integer orgId, Integer from, Integer to) {
        SessionFactory factory = manager.getFactory();
        Session ses = null;
        List<DocumentDao> orgIdList = null;
        try {
            ses = factory.openSession();
            Query<DocumentDao> fromQuery = ses.createQuery("from DocumentDao where orgId = :orgId");
            fromQuery.setParameter("orgId",orgId);
            fromQuery.setFirstResult(from.intValue());
            fromQuery.setMaxResults(to.intValue());
            orgIdList = fromQuery.list();
        } finally {
            if(null != ses) {
                ses.close();
            }
        }
        return orgIdList;
    }

    @Override
    public void updateDocumentDao(Object dao) {
        SessionFactory factory = manager.getFactory();
        Session ses = null;
        try {
            ses = factory.openSession();
            Transaction sec = ses.beginTransaction();
            ses.saveOrUpdate(dao);
            ses.flush();
            sec.commit();
            ses.close();
        } finally {
            if(null != ses) {
                ses.close();
            }
        }
    }
}
