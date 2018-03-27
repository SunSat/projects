package com.sunsat.sathish.j2ee.health.base.service.condition;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
public class WhereClause<RDT extends Object> {

    WhereClause(String leftValue, RDT rightValue, OperatorEnum operatorEnum) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        this.operatorEnum = operatorEnum;
    }

    String leftValue;
    RDT rightValue;
    OperatorEnum operatorEnum;

}
