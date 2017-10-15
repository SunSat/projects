package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.pojo;

/**
 * Created by ssundar2 on 20-03-2017.
 */
public class BuildingBlock {

    int id;
    String name;

    public BuildingBlock() {
    }

    public BuildingBlock(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
