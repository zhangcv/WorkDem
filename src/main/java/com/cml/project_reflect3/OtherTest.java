package com.cml.project_reflect3;

import com.cml.project_reflect2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Creacted by jack on 2019/10/22 16:40
 **/
public class OtherTest {

    /**
     * 构造器
     */
    @Test
    public void test1(){
        Class clazz = Person.class;
        //getConstructors(): 获取当前运行时类的声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }
        System.out.println();
        //getDeclaredConstructuors(): 获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }
    }
    /**
     * 获取运行时类的父类
     *
     */
    @Test
    public void test2(){
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }
    /**
     * 获取运行时类的带泛型的父类
     */
    @Test
    public void test3(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
    /**
     * 获取运行时类的带泛型的父类的泛型
     */
    @Test
    public void test4(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parmeType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        ParameterizedType parameterizedType = parmeType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }
    /**
     * 获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class Ainterface : interfaces) {
            System.out.println(Ainterface.getName());
        }
        //获取运行时类父类的接口
        System.out.println();
        Class[] interfaces_f = clazz.getSuperclass().getInterfaces();
        for (Class Ainterface_f : interfaces_f) {
            System.out.println(Ainterface_f.getName());
        }
    }

    /**
     * 获取运行时类的所在的包
     */
    @Test
    public void test6(){
        Class clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }
    /**
     * 获取运行时类声明的注解
     */
    @Test
    public void test7(){
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}