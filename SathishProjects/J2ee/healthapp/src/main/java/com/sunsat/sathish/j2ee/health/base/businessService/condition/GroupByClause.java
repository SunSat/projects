package com.sunsat.sathish.j2ee.health.base.businessService.condition;

import java.util.List;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
public class GroupByClause {

    private List<String> columnNames;

    public GroupByClause(List<String> columnNames) {
        this.columnNames = columnNames;
    }
}
