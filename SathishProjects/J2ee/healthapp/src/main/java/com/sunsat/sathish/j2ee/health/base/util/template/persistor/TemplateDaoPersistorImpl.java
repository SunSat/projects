package com.sunsat.sathish.j2ee.health.base.util.template.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.util.template.pojo.TemplateBusiness;
import com.sunsat.sathish.j2ee.health.base.util.template.pojo.TemplateDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository("templateDaoPersistor")
public class TemplateDaoPersistorImpl extends AbstractGenericDaoPersistor<TemplateDao, TemplateBusiness, BaseDataFilter> implements TemplateDaoPersistor{

    @Override
    public Class getDaoClass() {
        return TemplateDao.class;
    }

    @Transactional
    @Override
    public TemplateBusiness createNewTemplate(TemplateBusiness tm) {
        TemplateDao dao = new TemplateDao();
        dao.setBusinessValue(tm);
        dao  = persist(dao);
        tm.setPrimaryKeyId(dao.getPrimaryKeyId());
        return tm;
    }

    @Override
    public TemplateDao createDao() {
        return new TemplateDao();
    }

    @Override
    public void appendCriteria(List<Criteria> criteriaList, BaseDataFilter dataFilter) {

    }

    @Override
    public TemplateBusiness populateData(TemplateDao templateDao, BaseDataFilter fd) {
        return null;
    }

    @Override
    public TemplateBusiness getByTemplateName(TemplateBusiness tm) {
        String tmName= tm.getTemplateName();
        CriteriaBuilder templateBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TemplateDao> query = templateBuilder.createQuery(TemplateDao.class);
        Root<TemplateDao> root = query.from(TemplateDao.class);
        List<Predicate> criList = new ArrayList<>(2);
        criList.add(templateBuilder.and(templateBuilder.equal(root.get("templateName"),tmName),templateBuilder.equal(root.get("deleted"),0)));
        List<TemplateDao> resultList = getByBusinessKey(root,query,criList);
        if(!CollectionUtils.isEmpty(resultList)) {
            TemplateDao dao = resultList.get(0);
            return dao.getBusinessValue(BaseDataFilter.BY_ALL,null,null);
        }
        return null;
    }

    @Override
    public TemplateBusiness getByPrimaryKeyId(TemplateBusiness tm) {
        return null;
    }
}
