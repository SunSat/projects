package com.sunsat.sathish.j2ee.health.base.pojo.helper;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class RestrictionHelper<A1,A2> {
    String name;
    A1 a1;
    A2 a2;
    RestrictionType resType;

    public RestrictionHelper(String name, A1 a1, A2 a2, RestrictionType resType) {
        this.name = name;
        this.a1 = a1;
        this.a2 = a2;
        this.resType = resType;
    }

    public RestrictionHelper(String name, A1 a1, RestrictionType resType) {
        this.name = name;
        this.a1 = a1;
        this.resType = resType;
    }


}
