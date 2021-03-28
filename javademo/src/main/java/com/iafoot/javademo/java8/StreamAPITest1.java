package com.iafoot.javademo.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/3/28 17:00
 */
public class StreamAPITest1 {
    // 1-筛选与切片
    @Test
    public void test1(){
        //  * filter(Predicate P)：接受Lambda，从流中排除某些元素。
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        //练习：查询员工表中薪资大于20000的员工信息。
        stream.filter(e -> e.getSalary() > 2000).forEach(System.out::println);

        System.out.println("distinct()");
        //  * distinct()：筛选，通过流所生成元素的hashCode()和equals()去除重复元素。
        list.add(new Employee(1009,"name9",38,193399.1));
        list.add(new Employee(1009,"name9",38,193399.1));
        list.add(new Employee(1009,"name9",38,193399.1));
        list.add(new Employee(1009,"name9",38,193399.1));
        list.stream().distinct().forEach(System.out::println);

        System.out.println("limit(long maxSize)");
        //  * limit(long maxSize)：截断流，使其元素不超过给定数量。
        list.stream().limit(3).forEach(System.out::println);


        System.out.println("skip(long n)");
        //  * skip(long n)：跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补。
        list.stream().skip(3).forEach(System.out::println);
    }

    //映射
    @Test
    public void test2(){
        //* map(Function f)：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(x -> x.toUpperCase()).forEach(System.out::println);
        //练习：获取员工姓名长度大于3的员工的姓名。
        System.out.println("练习：获取员工姓名长度大于3的员工的姓名。");
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() > 3).forEach(System.out::println);
        //  * mapToDouble(ToDoubleFunction f)：接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的DoubleStream。
        //  * mapToInt(ToIntFunction f)：接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的IntStream。
        //  * mapToLong(ToLongFunction f)：接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的LongStream。

        //  * flatMap(Function f)：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流拼接成一个流。
        // 练习2：
        System.out.println("flatMap(Function f)");
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println();
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c: str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //3-排序
    @Test
    public void test3(){
        //  * sorted()：产生一个新流，其中按自然顺序排序。
        //  * sorted(Comparator com)：产生一个新流，其中按比较器顺序排序。
        List<Integer> list = Arrays.asList(12,43,65,34,87,0,-99,7);
        list.stream().sorted().forEach(System.out::println);

        System.out.println();
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2) -> Integer.compare(e2.getAge(),e1.getAge()))
                .forEach(System.out :: println);

    }
















}
