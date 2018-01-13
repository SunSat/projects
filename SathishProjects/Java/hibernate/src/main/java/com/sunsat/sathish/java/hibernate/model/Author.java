package com.sunsat.sathish.java.hibernate.model;

/**
 * Created by sathishkumar_su on 12/20/2017.
 *
 CREATE TABLE `author` (
 `authorid` int(11) NOT NULL,
 `authorname` varchar(45) DEFAULT NULL,
 PRIMARY KEY (`authorid`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Author extends AbstractDaoModel {

    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
