package com.sunsat.sathish.j2ee.spsystem.dao.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by ssundar2 on 28-03-2017.
 */

@Entity
@Table(name = "barcodetracker")
public class BarCodeTrackerDao {

    @Id
    @Column(name = "trackingid")
    private int trackingId;

    @Column(name = "barcodeid")
    private int barcodeId;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private Date createdDate;

    @Column(name = "status")
    private String status;

    @Column(name = "isrejected")
    private String isRejected;

    @Column(name = "count")
    private int count;

    @Column(name = "message")
    private String message;

    public int getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(int trackingId) {
        this.trackingId = trackingId;
    }

    public int getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(int barcodeId) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BarCodeTrackerDao)) return false;

        BarCodeTrackerDao that = (BarCodeTrackerDao) o;

        if (getTrackingId() != that.getTrackingId()) return false;
        if (getBarcodeId() != that.getBarcodeId()) return false;
        if (getCount() != that.getCount()) return false;
        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) return false;
        if (getCreatedDate() != null ? !getCreatedDate().equals(that.getCreatedDate()) : that.getCreatedDate() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getIsRejected() != null ? !getIsRejected().equals(that.getIsRejected()) : that.getIsRejected() != null)
            return false;
        return !(getMessage() != null ? !getMessage().equals(that.getMessage()) : that.getMessage() != null);

    }

    @Override
    public int hashCode() {
        int result = getTrackingId();
        result = 31 * result + getBarcodeId();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getIsRejected() != null ? getIsRejected().hashCode() : 0);
        result = 31 * result + getCount();
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        return result;
    }

}
