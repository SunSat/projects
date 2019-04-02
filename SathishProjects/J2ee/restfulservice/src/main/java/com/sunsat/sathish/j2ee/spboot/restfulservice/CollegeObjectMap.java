package com.sunsat.sathish.j2ee.spboot.restfulservice;

import com.sunsat.sathish.j2ee.spboot.restfulservice.pojo.model.Department;
import com.sunsat.sathish.j2ee.spboot.restfulservice.pojo.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CollegeObjectMap {

    private CollegeObjectMap() {

    }
    private static CollegeObjectMap objMap;

    public Map<String,Map<Integer,Object>> getCollegeObjectMap() {
        return fillStudent();
    }

    public static CollegeObjectMap getInstance() {
        if(objMap == null) {
            objMap = new CollegeObjectMap();
        }
        return objMap;
    }

    public Map<String,Map<Integer,Object>> fillStudent() {
        Random random = new Random(10);
        Map<Integer, Object> deptMap = new HashMap<>();
        for(int i=0;i<10;i++) {
            Integer id = random.nextInt(10);
            Department dep = new Department();
            dep.setId(id);
            dep.setName("Dep Name : "+ id + " " + id);
            deptMap.put(id,dep);
        }

        random = new Random(10);
        Random deptId = new Random(10);
        Map<Integer, Object>stuMap = new HashMap<>();
        for(int i=0;i<10;i++) {
            Integer id = random.nextInt(10);
            Student stu = new Student();
            stu.setId(id);
            stu.setName("Name is : " + id+" " + id + " " + id);
            stu.setAddress("Address is : " + id + " " + " ");
            stuMap.put(id,stu);
            int depId = deptId.nextInt(10);
            while(true) {
                if(deptMap.containsKey(depId)) {
                    stu.setDepartmentId(depId);
                    break;
                } else {
                    depId = deptId.nextInt(10);
                }
            }
        }
        Map<String,Map<Integer,Object>> map = new HashMap<>();
        map.put("student",stuMap);
        map.put("department",deptMap);
        return map;
    }
}
