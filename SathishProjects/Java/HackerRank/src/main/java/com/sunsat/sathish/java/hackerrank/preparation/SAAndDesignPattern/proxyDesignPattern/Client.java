package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.externalInterfaces.VmsRegistor;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.pojo.BuildingBlock;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.services.BuildingBlockManager;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.services.BuildingBlockManagerProxy;

import java.util.Arrays;

/**
 * Created by ssundar2 on 20-03-2017.
 */
public class Client {

    public  static void main(String ... args) {
        BuildingBlockManager obj = (BuildingBlockManager)VmsRegistor.getInterface(new BuildingBlockManagerProxy());
        BuildingBlock bb = (BuildingBlock) obj.getBBById(1);
        System.out.println(bb.getId() + "" + bb.getName());
    }
}
