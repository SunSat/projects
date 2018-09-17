package com.vwr.em.migration.dao.service;

import java.util.List;

/**
 * Created by sathishkumar_su on 7/12/2018.
 */
public interface DocumentService<DocumentDao> {
    public List<DocumentDao> getAllDocument();
    public DocumentDao getById();
    public List<Integer> getUniqueOrgIdFromDocument();
    public List<DocumentDao> getAllByOrgId(Integer argId);
    public List<Integer> getAllDocumentIds();
    public List<DocumentDao> getAllDocumentByOrg(Integer orgId, Integer from, Integer to);
    public void updateDocumentDao(DocumentDao dao);
}
