package com.vwr.em.migration.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sathishkumar_su on 7/12/2018.
 */

@Entity
@Table(name = "DOCUMENT")
public class DocumentDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCUMENT_ID")
    private Long skGuid;

    @Column(name = "DOCUMENT_UNIQUE_ID")
    private String documentUniquId;

    //@Column(name = "VCS_ID")
    @Transient
    private Long vcsId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DOCUMENT_TYPE")
    private String documentType;

    @Column(name = "DESCRIPTION")
    private String descritpion;

    @Column(name = "FILENAME")
    private String fileName;

    @Column(name = "SIZE")
    private String size;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DOCUMENT_URL")
    private String documentUrl;

    @Column(name = "IS_SOFTWARE")
    private Integer isSoftware;

    @Column(name = "ORG_ID")
    private Integer orgId;

    @Column(name = "CREATED_BY")
    private String creaatedBy;

    @Column(name = "CREATED_DT")
    private Date createdDt;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "MODIFIED_DT")
    private String modifiedDt;

    @Column(name = "DELETED")
    private Character deleted;

    @Column(name = "REASON_FOR_CHANGE")
    private String reasonForChange;

    @Column(name = "SIGN_OFF_REASON")
    private String signOfReason1;

    @Column(name = "SIGN_OFF_REASON2")
    private String signOfReason2;

    public Long getSkGuid() {
        return skGuid;
    }

    public void setSkGuid(Long skGuid) {
        this.skGuid = skGuid;
    }

    public String getDocumentUniquId() {
        return documentUniquId;
    }

    public void setDocumentUniquId(String documentUniquId) {
        this.documentUniquId = documentUniquId;
    }

    public Long getVcsId() {
        return vcsId;
    }

    public void setVcsId(Long vcsId) {
        this.vcsId = vcsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public Integer getIsSoftware() {
        return isSoftware;
    }

    public void setIsSoftware(Integer isSoftware) {
        this.isSoftware = isSoftware;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getCreaatedBy() {
        return creaatedBy;
    }

    public void setCreaatedBy(String creaatedBy) {
        this.creaatedBy = creaatedBy;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDt() {
        return modifiedDt;
    }

    public void setModifiedDt(String modifiedDt) {
        this.modifiedDt = modifiedDt;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public String getReasonForChange() {
        return reasonForChange;
    }

    public void setReasonForChange(String reasonForChange) {
        this.reasonForChange = reasonForChange;
    }

    public String getSignOfReason1() {
        return signOfReason1;
    }

    public void setSignOfReason1(String signOfReason1) {
        this.signOfReason1 = signOfReason1;
    }

    public String getSignOfReason2() {
        return signOfReason2;
    }

    public void setSignOfReason2(String signOfReason2) {
        this.signOfReason2 = signOfReason2;
    }

    @Override
    public String toString() {
        return "DocumentDao{" +
                "skGuid=" + skGuid +
                ", documentUniquId='" + documentUniquId + '\'' +
                ", vcsId=" + vcsId +
                ", title='" + title + '\'' +
                ", documentType='" + documentType + '\'' +
                ", descritpion='" + descritpion + '\'' +
                ", fileName='" + fileName + '\'' +
                ", size='" + size + '\'' +
                ", status='" + status + '\'' +
                ", documentUrl='" + documentUrl + '\'' +
                ", isSoftware=" + isSoftware +
                ", orgId=" + orgId +
                ", creaatedBy='" + creaatedBy + '\'' +
                ", createdDt=" + createdDt +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedDt='" + modifiedDt + '\'' +
                ", deleted=" + deleted +
                ", reasonForChange='" + reasonForChange + '\'' +
                ", signOfReason1='" + signOfReason1 + '\'' +
                ", signOfReason2='" + signOfReason2 + '\'' +
                '}';
    }
}
