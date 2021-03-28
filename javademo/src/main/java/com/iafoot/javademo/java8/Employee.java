package com.iafoot.javademo.java8;


/**
 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/3/28 15:29
 */
//@Data
//@AllArgsConstructor
public class Employee {

    public Employee(Long id, String name, Integer age, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    private Long id;
    private String name;
    private Integer age;
    private Double salary;




}
