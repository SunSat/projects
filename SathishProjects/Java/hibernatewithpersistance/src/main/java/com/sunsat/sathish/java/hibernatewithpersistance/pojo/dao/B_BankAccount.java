package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "b_bankaccount")
public class B_BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "account")
    int account;

    @Column(name = "bankname")
    String bankName;

    @Column(name = "shift")
    String shift;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B_BankAccount that = (B_BankAccount) o;
        return id == that.id &&
                account == that.account &&
                Objects.equals(bankName, that.bankName) &&
                Objects.equals(shift, that.shift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, bankName, shift);
    }
}
