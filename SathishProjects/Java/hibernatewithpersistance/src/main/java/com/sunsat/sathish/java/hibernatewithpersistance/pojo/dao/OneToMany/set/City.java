package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.OneToMany.set;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 CREATE TABLE `004_city_onetomany_list` (
 `id` int(10) NOT NULL AUTO_INCREMENT,
 `name` varchar(40) DEFAULT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8


 */
@Entity
@Table(name = "004_city_onetomany_list")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


    @Access(AccessType.PROPERTY)
    @ElementCollection
    @CollectionTable(name = "004_street_onetomany_list",joinColumns = {@JoinColumn(name = "CITY_ID")})
    @Column(name = "stree_name",table = "004_street_onetomany_list")
    private List<String> streetList;

    public List<String> getStreetList() {
        return streetList;
    }

    public void setStreetList(List<String> streetList) {
        this.streetList = streetList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
