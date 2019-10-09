package com.cml.project_reflect1;

import org.junit.Test;

import java.util.Random;

/**
 * Creacted by jack on 2019/10/22 13:58
 **/
public class NewInstanceTest {

    @Test
    public void test01() throws Exception {
        Class<Person> clazz = Person.class;

        /**
         * new Instance() 调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造方法
         * 要求：
         * 1.运行时类必须提供空参的的构造器
         * 2.空参的构造器的访问权限得够，通常public
         *
         * 在javabean中 要求提供一个public 的空参构造器。原因：
         * 1.便于通过反射，创建运行时类的对象
         * 2.便于子类继承此运行时类，默认调用super()，保证父类有此构造器
         *
         */
        Person obj = clazz.newInstance();
        System.out.println(obj);

    }
    //反射的动态性
    @Test
    public void test02() {
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 2:
                    classPath = "com.cml.project_reflect1.Person";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
            }
            try {
                Object instance = getInstance(classPath);
                System.out.println(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public Object getInstance(String ClassPath) throws Exception {

        Class clazz = Class.forName(ClassPath);
        return clazz.newInstance();
    }
}