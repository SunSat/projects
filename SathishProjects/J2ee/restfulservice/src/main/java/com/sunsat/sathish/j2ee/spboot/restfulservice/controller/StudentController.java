package com.sunsat.sathish.j2ee.spboot.restfulservice.controller;

import com.sunsat.sathish.j2ee.spboot.restfulservice.CollegeObjectMap;
import com.sunsat.sathish.j2ee.spboot.restfulservice.pojo.model.Department;
import com.sunsat.sathish.j2ee.spboot.restfulservice.pojo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    Map<String, Map<Integer,Object>> collegeObjectMap = CollegeObjectMap.getInstance().getCollegeObjectMap();

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable(name = "studentId") int studentId) {
        Map<Integer,Object> studentMap = collegeObjectMap.get("student");
        if(studentMap.containsKey(studentId)) {
            return (Student)studentMap.get(studentId);
        }
        return null;
    }
    @GetMapping("/student")
    public List<Student> getAllStudent() {
        Map<Integer,Object> studentMap = collegeObjectMap.get("student");
        List<Student> stuList = new ArrayList<>(studentMap.size());
        for(Integer i : studentMap.keySet()) {
            stuList.add((Student)studentMap.get(i));
        }
        return stuList;
    }

    @GetMapping("/department")
    public List<Department> getAllDepartment() {
        Map<Integer,Object> departmentMap = collegeObjectMap.get("department");
        List<Department> deptList = new ArrayList<>(departmentMap.size());
        for(Integer i : departmentMap.keySet()) {
            deptList.add((Department)departmentMap.get(i));
        }
        return deptList;
    }
}
