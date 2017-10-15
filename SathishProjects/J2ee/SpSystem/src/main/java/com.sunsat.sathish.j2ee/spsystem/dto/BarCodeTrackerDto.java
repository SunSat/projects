package com.sunsat.sathish.j2ee.spsystem.dto;

import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by ssundar2 on 28-03-2017.
 */
@Scope("prototype")
public class BarCodeTrackerDto {

    private int trackerId;
    private String barcodeId;
    private String type;
    private Date createdDate;
    private String status;
    private String isRejected;
    private int count;
    private String message;

    public int getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }

    public String getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(String barcodeId) {
        this.barcodeId = barcodeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsRejected() {
        return isRejected;
    }

    public void setIsRejected(String isRejected) {
        this.isRejected = isRejected;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "BarCodeTrackerDto{" +
                "trackerId=" + trackerId +
                ", barcodeId='" + barcodeId + '\'' +
                ", type='" + type + '\'' +
                ", createdDate=" + createdDate +
                ", status='" + status + '\'' +
                ", isRejected='" + isRejected + '\'' +
                ", count=" + count +
                ", message='" + message + '\'' +
                '}';
    }
}
