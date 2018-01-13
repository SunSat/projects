package com.sunsat.sathish.java.hibernate.model;

/**
 * Created by sathishkumar_su on 12/20/2017.
 CREATE TABLE `balancedetail` (
 `balanceid` int(11) NOT NULL,
 `groupid` int(11) DEFAULT NULL,
 `userid` int(11) DEFAULT NULL,
 `amountpaid` varchar(10) DEFAULT NULL,
 `amountpaiddate` date DEFAULT NULL,
 `amountreturned` varchar(10) DEFAULT NULL,
 `amountreturneddate` date DEFAULT NULL,
 `currentbalance` varchar(10) DEFAULT NULL,
 PRIMARY KEY (`balanceid`)

 */
public class BalanceDetail extends AbstractDaoModel {

    private int groupId;
    private int userId;
    private String amountPaid;
    private String amountPaidDate;
    private String amountReturned;
    private String amountReturnedDate;
    private String currentBalance;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getAmountPaidDate() {
        return amountPaidDate;
    }

    public void setAmountPaidDate(String amountPaidDate) {
        this.amountPaidDate = amountPaidDate;
    }

    public String getAmountReturned() {
        return amountReturned;
    }

    public void setAmountReturned(String amountReturned) {
        this.amountReturned = amountReturned;
    }

    public String getAmountReturnedDate() {
        return amountReturnedDate;
    }

    public void setAmountReturnedDate(String amountReturnedDate) {
        this.amountReturnedDate = amountReturnedDate;
    }

    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }
}
