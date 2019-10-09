package com.jdk8test;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Creacted by jack on 2019/12/4 11:19
 **/
public class StreamAPITestIntermediate {

    // 1- 筛选与分片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployee();

//        filter(predicate p) 接受lambada 从流中排除某些元素
        Stream<Employee> stream = list.stream();
        stream.filter(e->e.getSalary()>7000).forEach(System.out::println);

//        limit(n) 截断流， 使其元素不超过给定数量。
        list.stream().limit(3).forEach(System.out::println);
//        skip(n) 跳过元素，返回一个扔掉了前n个元素的流，若流中元素不n个，则返回一个空流
        System.out.println();
        list.stream().skip(3).forEach(System.out::println);
//        distinct() 筛选 通过流所产生元素的hashCode() 和equeals()去除重复元素
        list.add(new Employee(1010,"刘",10,800));
        list.add(new Employee(1010,"刘",10,800));
        list.add(new Employee(1010,"刘",10,800));
        list.add(new Employee(1010,"刘",10,800));
        list.add(new Employee(1010,"刘",10,800));

        list.stream().distinct().forEach(System.out::println);


    }
}
