package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.OneToMany.list;

import javax.persistence.*;

/**
 CREATE TABLE `004_street_onetomany_list` (
 `id` int(10) NOT NULL AUTO_INCREMENT,
 `city_id` int(10) DEFAULT NULL,
 `stree_name` varchar(40) DEFAULT NULL,
 PRIMARY KEY (`id`),
 KEY `004_street_onetomany_list_004_city_onetomany_list_id_fk` (`city_id`),
 CONSTRAINT `004_street_onetomany_list_004_city_onetomany_list_id_fk` FOREIGN KEY (`city_id`) REFERENCES `004_city_onetomany_list` (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8


 */
@Entity
@Table(name = "004_street_onetomany_list")
public class Street {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stree_name")
    private String streetName;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = City.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "Street{" +
                "streetName='" + streetName + '\'' +
                '}';
    }
}
