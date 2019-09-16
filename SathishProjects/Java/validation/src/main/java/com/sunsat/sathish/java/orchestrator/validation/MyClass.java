package com.sunsat.sathish.java.orchestrator.validation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public class MyClass {

    @JsonProperty("name")
    private String name;
    @JsonProperty("startDayOfWeek")
    private MyClass.StartDayOfWeek startDayOfWeek;
    /**
     * The ID of a timezone returned by the timezones route.
     *
     */
    @JsonProperty("timezone")
    private String timezone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The startDayOfWeek
     */
    @JsonProperty("startDayOfWeek")
    public MyClass.StartDayOfWeek getStartDayOfWeek() {
        return startDayOfWeek;
    }

    /**
     *
     * @param startDayOfWeek
     *     The startDayOfWeek
     */
    @JsonProperty("startDayOfWeek")
    public void setStartDayOfWeek(MyClass.StartDayOfWeek startDayOfWeek) {
        this.startDayOfWeek = startDayOfWeek;
    }

    public static enum StartDayOfWeek {

        MONDAY("Monday"),
        TUESDAY("Tuesday"),
        WEDNESDAY("Wednesday"),
        THURSDAY("Thursday"),
        FRIDAY("Friday"),
        SATURDAY("Saturday"),
        SUNDAY("Sunday");
        private final String value;
        private static Map<String, MyClass.StartDayOfWeek> constants = new HashMap<String, MyClass.StartDayOfWeek>();

        static {
            for (MyClass.StartDayOfWeek c: values()) {
                constants.put(c.value, c);
            }
        }

        private StartDayOfWeek(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static MyClass.StartDayOfWeek fromValue(String value) {
            MyClass.StartDayOfWeek constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
