package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.OneToMany.list;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlIDREF;
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

@NamedQueries({
        @NamedQuery(name = "get_All_City",
        query = "select c from City c"),
        @NamedQuery(name = "get_by_name",
        query = "select c from City c where c.name = :name")
})
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "city")
    @OrderBy("streetName")
    private List<Street> streetList;

    public List<Street> getStreetList() {
        return streetList;
    }

    public void setStreetList(List<Street> streetList) {
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
