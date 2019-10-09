package com.jdk8test;

import java.util.ArrayList;
import java.util.List;

/**
 * Creacted by jack on 2019/12/4 10:37
 **/
public class EmployeeData {
    public static List<Employee> getEmployee(){
        List<Employee> list =new ArrayList<>();

        list.add(new Employee(1001,"马化腾",35,6000.38));
        list.add(new Employee(1002,"马云",25,5000.38));
        list.add(new Employee(1003,"刘强东",37,3000.38));
        list.add(new Employee(1004,"雷军",45,4000.38));
        list.add(new Employee(1005,"李彦宏",15,7000.38));
        list.add(new Employee(1006,"扎克伯格",26,8000.38));
        list.add(new Employee(1007,"乔布斯",29,8023.8));
        return list;
    }
}
