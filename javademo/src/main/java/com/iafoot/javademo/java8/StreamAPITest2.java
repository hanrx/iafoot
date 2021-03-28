package com.iafoot.javademo.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 *
 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/3/28 19:13
 */
public class StreamAPITest2 {

    //匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //  * allMatch(Predicate p)：检查是否匹配所有元素。
        //练习：是否所有的员工的年龄都大于18
        System.out.println(employees.stream().allMatch(e -> e.getAge() > 18));

        //  * anyMatch(Predicate p)：检查是否至少匹配一个元素。
        // 练习：是否存在员工的工资大于10000
        System.out.println(employees.stream().anyMatch(e -> e.getSalary() > 10000));

        //  * noneMatch(Predicate p)：检查是否没有匹配所有元素。
        // 练习：是否存在员工姓"雷"
        System.out.println(employees.stream().noneMatch(e -> e.getName().startsWith("雷")));

        //  * findFirst()：返回第一个元素。
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        //  * findAny()：返回当前流中的任意元素。
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
    }

    //终止操作
    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
        //  * count()：返回流中元素总数。
        System.out.println(employees.stream().count());
        //  * max(Comparator c)：返回流中最大值。
        //练习：返回最高的工资
        Optional<Double> max = employees.stream().map(e -> e.getSalary()).max(Double::compare);
//        Optional<Employee> max = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max);
        //  * min(Comparator c)：返回流中最小值。
        // 练习：返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        //  * forEach(Consumer c)：内部迭代（使用Collection接口需要用户去做迭代，称为外部迭代。相反，Stream API使用内部迭代——它帮你把迭代做了）。
        employees.stream().forEach(System.out::println);
        // 使用集合的默认方法
        employees.forEach(System.out::println);
    }

    //2.归约
    @Test
    public void test3(){
        // * reduce(T iden,BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回T。
        //练习：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        //  * reduce(BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回Optional<T>。
        //练习：计算公司中所有员工工资总和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1);
        //  > 备注：map和reduce的连接通常称为map-reduce模式，因Google用它来进行网络搜索而出名。

    }

    //3-收集
    @Test
    public void test4(){
        //collect(Collector c)：将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法。
        //练习1 查找工资大于6000的员工，结果返回一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }













}
