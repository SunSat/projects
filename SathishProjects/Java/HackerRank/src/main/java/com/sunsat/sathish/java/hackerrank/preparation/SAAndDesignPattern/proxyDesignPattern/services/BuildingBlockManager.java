package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.services;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.pojo.BuildingBlock;

/**
 * Created by ssundar2 on 20-03-2017.
 */
public interface BuildingBlockManager {

    public BuildingBlock getBBByName(String... bbNmae);
    public BuildingBlock getBBById(int id);

}
