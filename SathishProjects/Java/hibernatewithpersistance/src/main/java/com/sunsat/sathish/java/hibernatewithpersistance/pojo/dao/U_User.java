package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao;

import javax.persistence.*;

@Table(name = "u_user")
@Entity
public class U_User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "firstname")
    String userName;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    U_Address address;

    public U_Address getAddress() {
        return address;
    }

    public void setAddress(U_Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
