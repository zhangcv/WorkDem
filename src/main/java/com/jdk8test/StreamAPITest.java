package com.jdk8test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Creacted by jack on 2019/12/4 10:17
 **/
public class StreamAPITest {

    /**
     * 创建Stream 方式一： 通过集合
     */
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployee();

        //default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        // default Stream<E> paralleStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    /**
     * 创建Stream 方式二： 通过数组
     */
    @Test
    public void test2() {
        int[] numArr = new int[]{1, 2, 3, 4, 5, 6};
        // 调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流

        IntStream stream = Arrays.stream(numArr);

        Employee e1 = new Employee(1001, "tom");
        Employee e2 = new Employee(1002, "jack");
        Employee[] empArr = new Employee[]{e1, e2};
        Stream<Employee> empStream = Arrays.stream(empArr);
    }

    /**
     * 创建Stream 方式三： 通过stream.of
     */
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    /**
     * 创建Stream 方式四： 创建无限流
     */
    @Test
    public void test4() {

       /* 迭代
        public static<T > Stream < T > iterate( final T seed, final UnaryOperator<T> f)
        */
       // 遍历前是个偶数
       Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
        /*生成
        public static<T > Stream < T > generate(Supplier < T > s)
        */
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
