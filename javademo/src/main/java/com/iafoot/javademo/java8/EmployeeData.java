package com.iafoot.javademo.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/3/28 15:31
 */
public class EmployeeData {

    @Test
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"111",31,1999.1));
        list.add(new Employee(1002,"222",31,2999.1));
        list.add(new Employee(1003,"name3",31,2999.1));
        list.add(new Employee(1004,"name4",31,2999.1));
        list.add(new Employee(1005,"name5",38,3999.1));
        list.add(new Employee(1006,"name6",38,3999.1));
        list.add(new Employee(1007,"name7",38,133999.1));
        list.add(new Employee(1008,"name8",38,193399.1));
        return list;
    }













}
