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
        list.add(new Employee(1001L,"name1",31,1999.1));
        list.add(new Employee(1002L,"name2",31,2999.1));
        list.add(new Employee(1003L,"name3",31,2999.1));
        list.add(new Employee(1004L,"name4",31,2999.1));
        list.add(new Employee(1005L,"name5",38,3999.1));
        list.add(new Employee(1006L,"name6",38,3999.1));
        list.add(new Employee(1007L,"name7",38,133999.1));
        list.add(new Employee(1008L,"name8",38,193399.1));
        return list;
    }













}
