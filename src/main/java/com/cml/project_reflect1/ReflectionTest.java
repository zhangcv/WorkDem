package com.cml.project_reflect1;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Creacted by jack on 2019/10/22 10:38
 **/
public class ReflectionTest {

    @Test
    public void test01() {
        Person p1 = new Person("Tom", 13);

        p1.age = 15;
        System.out.println(p1.age);

        p1.show();
//        反射之前，Person类外部，不可以通过Person类的对象调用内部私有结构，
//        比如： name、showNation以及私有的构造器
    }


    @Test
    public void test02() throws Exception {
        Class clazz = Person.class;
        //通过反射创建Person类
        Constructor constructor = clazz.getConstructor(String.class, int.class);

        Object tom = constructor.newInstance("Tom", 12);//多态
        Person p = (Person) tom;
        System.out.println(p.toString());
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //反射可以操作Person类私有的构造器
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person p1 = (Person) declaredConstructor.newInstance("jack");
        System.out.println(p1);

        //反射调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Hanmeimei");
        System.out.println(p1);
        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");//相当于 p1.showNation("中国")
        System.out.println(nation);

    }
    //疑问： 通过new 的方式和反射的方式都可以调用公开的结构，开发用哪个？
//    反射的特征： 动态性
    //疑问： 反射机制与面向对象中的封装性是不是矛盾？
//    不矛盾，不建议使用私有，作为提醒。 反射 是 能不能调用。 封装性， 建议能不能调

    //获取Class的实例的方式
    @Test
    public void test3() throws Exception {
        //方式一： 调用运行时类的属性: .class
        Class clazz = Person.class;
        System.out.println(clazz);
        //方式二：通过运行时类的对象 .getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class<?> clazz3 = Class.forName("com.cml.project_reflect1.Person"); //"java.lang.String"
        System.out.println(clazz3);

        System.out.println(clazz==clazz2);
        System.out.println(clazz==clazz3);
        //方式四： ClassLoader

        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.cml.project_reflect1.Person");
        System.out.println(clazz4);

    }
    @Test
    public void test4(){
        int[] a = new int[10];
        int[] b = new int[100];
        Class<? extends int[]> aClass = a.getClass();
        Class<? extends int[]> bClass = b.getClass();
        //只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(aClass==bClass);

    }

}