package com.sunsat.sathish.java.mapstrct.employee;

public class EmployeeDTO {

    public EmployeeDTO() {
    }

    public EmployeeDTO(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    private int employeeId;
    private String employeeName;
    private String date;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public EmployeeDTO(int employeeId, String employeeName, String date) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
