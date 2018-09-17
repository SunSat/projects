package com.vwr.em.migration.taskData;

import com.vwr.em.migration.dao.DocumentDao;

/**
 * Created by sathishkumar_su on 7/12/2018.
 */
public class MigrationTask {

    Long taskId;
    String currentState;
    String nextState;
    DocumentDao documentdao;
    String downloadPath;
    String downloadStatus;
    String uploadStatus;
    Long vcsUniqueId;

    public MigrationTask(Long taskId, String currentState, String nextState, DocumentDao documentdao, String downloadPath, String downloadStatus, String uploadStatus, Long vcsUniqueId) {
        this.taskId = taskId;
        this.currentState = currentState;
        this.nextState = nextState;
        this.documentdao = documentdao;
        this.downloadPath = downloadPath;
        this.downloadStatus = downloadStatus;
        this.uploadStatus = uploadStatus;
        this.vcsUniqueId = vcsUniqueId;
    }

    public MigrationTask(Long taskId, String currentState, String nextState, DocumentDao documentdao) {
        this.taskId = taskId;
        this.currentState = currentState;
        this.nextState = nextState;
        this.documentdao = documentdao;
    }

    public MigrationTask() {

    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public DocumentDao getDocumentdao() {
        return documentdao;
    }

    public void setDocumentdao(DocumentDao documentdao) {
        this.documentdao = documentdao;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(String downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public String getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public Long getVcsUniqueId() {
        return vcsUniqueId;
    }

    public void setVcsUniqueId(Long vcsUniqueId) {
        this.vcsUniqueId = vcsUniqueId;
    }

    @Override
    public String toString() {
        return "MigrationTask{" +
                "taskId=" + taskId +
                ", currentState='" + currentState + '\'' +
                ", nextState='" + nextState + '\'' +
                ", documentdao=" + documentdao +
                ", downloadPath='" + downloadPath + '\'' +
                ", downloadStatus='" + downloadStatus + '\'' +
                ", uploadStatus='" + uploadStatus + '\'' +
                ", vcsUniqueId=" + vcsUniqueId +
                '}';
    }
}
