package com.iafoot.javademo.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Stream关注的对数据的运算，与CPU打交道，
 *      集合关注的是数据的存储，与内存打交道
 * 2.
 * * 1.Stream自己不会存储元素。
 * * 2.Stream不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * * 3.Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 * 3.Stream 执行流程
 *      Stream的实例化
 *      一系列的中间操作（过滤、映射、...）
 * 4. 说明
 *      一个中间操作链，对数据源的数据进行处理。
 *      一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用。
 *
 *
 *
 * @author ：iAfoot
 * @description：TODO
 * @date ：2021/3/28 15:17
 */
public class StreamAPITest {
   //* 创建Stream的方式一：通过集合。Java8中的Collection接口被扩展，提供了两个获取流的方式：
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //  * default Stream<E> stream()：返回一个顺序流。
        Stream<Employee> stream = employees.stream();

        //  * default Stream<E parallelStream()：返回一个并行流。
        Stream<Employee> employeeStream = employees.parallelStream();

    }

    // 创建Stream方式二：通过数组。Java8中的Arrays的静态方法stream()可以获取数组流：
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //  调用Arrays类的static<T> Stream<T> stream(T[] array)：返回一个流。
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(10001L,"Tom",12,12.3);
        Employee e2 = new Employee(10002L,"Jom",14,12.3);
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);

    }

    //创建Stream方式三：通过Stream的of()。可以调用Stream类静态方法of()，通过显示值创建一个流。它可以接收任意数量的参数。
    @Test
    public void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);
    }

    // 创建Stream方式四：创建无限流。可以使用静态方法Stream.iterate()和Stream.generate()，创建无限流。
    @Test
    public void test4(){
        // 迭代：public static<T> Stream<T> iterate(final T seed，final UnaryOperator<T> f)；
        //遍历前10个偶数
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);
        // 生成：public static<T> Stream<T> generate(Supplier<T> s);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }


























}
