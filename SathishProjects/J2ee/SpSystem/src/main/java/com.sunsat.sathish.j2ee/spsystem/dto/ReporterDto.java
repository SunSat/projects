package com.sunsat.sathish.j2ee.spsystem.dto;

import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by ssundar2 on 30-03-2017.
 */
@Scope(value = "prototype")
public class ReporterDto {

    private int userId;
    private String name;
    private Date startDate;
    private Date endDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ReporterDto{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
