package com.weiyu.thinkinginjava.domain;

/**
 * Created by weiyu on 2017/2/6.
 */
public class Employee {
    private int employeeId;
    private String name;
    private int age;
    private String deptNo;
    public Employee(){}

    public Employee(String name){
        this.name = name;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", deptNo='" + deptNo + '\'' +
                '}';
    }
}
