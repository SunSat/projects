package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.services;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.pojo.BuildingBlock;

/**
 * Created by ssundar2 on 20-03-2017.
 */
public class BuildingBlockManagerProxy implements BuildingBlockManager {
    @Override
    public BuildingBlock getBBByName(String... bbNmae) {
        return new BuildingBlock(12,"hello");
    }

    @Override
    public BuildingBlock getBBById(int id) {
        return new BuildingBlock(14,"kumar");
    }
}
