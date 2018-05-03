package com.sunsat.sathish.j2ee.health.base.business.condition;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
public class CriteriaFiltter {

    private WhereClause whereClause;
    private OrderByClause orderByClause;
    private GroupByClause groupByClause;

    public CriteriaFiltter() {
    }

    public CriteriaFiltter(WhereClause whereClause, OrderByClause orderByClause, GroupByClause groupByClause) {
        this.whereClause = whereClause;
        this.orderByClause = orderByClause;
        this.groupByClause = groupByClause;
    }

    public WhereClause getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(WhereClause whereClause) {
        this.whereClause = whereClause;
    }

    public OrderByClause getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(OrderByClause orderByClause) {
        this.orderByClause = orderByClause;
    }

    public GroupByClause getGroupByClause() {
        return groupByClause;
    }

    public void setGroupByClause(GroupByClause groupByClause) {
        this.groupByClause = groupByClause;
    }
}
