package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao;

@org.hibernate.annotations.GenericGenerator(
        name = "helloworld",
        strategy = "enhanced_sequence",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence_name",
                        value = "john"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "length_check",
                        value = "1000"

                )
        }

)
public class CustomizedSequenceGenerator {
}
