package com.sunsat.sathish.java.hackerrank.preparation.interview.PNBPeribas;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssundar2 on 7/7/2017.
 */
public class ChangingType {

    private List<Employee> emp = new ArrayList<>();

    class Employee {
        Integer id;
        String name;
        EmpType empType;

        public Employee(Integer id, String name, EmpType empType) {
            this.id = id;
            this.name = name;
            this.empType = empType;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public EmpType getEmpType() {
            return empType;
        }

        public void setEmpType(EmpType empType) {
            this.empType = empType;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", empType=" + empType +
                    '}';
        }
    }

    enum EmpType {
        Standard,PartTime
    }

    public void createEmployee(int seed) {
        for(int i = 0;i<seed;i++) {
            emp.add(new Employee(i,"Hello"+i, i/2 == 0? EmpType.Standard : EmpType.PartTime));
        }
        System.out.println(emp.get(0).getClass());

    }

    public void printEmployee() {
        for(Employee e : emp) {
            System.out.println(e);
        }
    }

    /**
     *
     * @param cls : The class Name which I need get state of the property values.
     * @param fieldName : Original State Field Name.
     * @param <T> : Unknown Type, Which has to be changed as per the fieldName's Type.
     * @return
     * @throws NoSuchMethodException : Throws When given Getter API not available.
     * @throws InvocationTargetException
     * @throws IllegalAccessException : Throws when Non Accessible API usage throws reflection.
     *
     * Explanation : Defined <T> Unknows Type variable which can change based on the return type
     * of the getter Method.
     */

    public <T> List<T> getAllByGeneric(Class cls, String fieldName) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        List<T> stList = new ArrayList<T>();
        char firstCh = fieldName.charAt(0);
        String method = "get"+fieldName.replace(firstCh,Character.toUpperCase(firstCh));
        Method m = cls.getDeclaredMethod(method,null);
        for(Employee e : emp) {
            stList.add((T)m.invoke(e));
        }
        return stList;
    }

    public static void main(String[] args) {
        ChangingType type = new ChangingType();
        type.createEmployee(10);
        type.printEmployee();
        try {
            List<String> empTypeLi = type.getAllByGeneric(Employee.class, "name");
            System.out.println("This is my SOUT : " + empTypeLi);
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
}
