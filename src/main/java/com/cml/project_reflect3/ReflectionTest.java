package com.cml.project_reflect3;

import com.cml.project_reflect2.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构： 属性、方法、构造器
 * Creacted by jack on 2019/10/22 17:38
 **/
public class ReflectionTest {


    /**
     * 获取属性值
     */
    @Test
    public void test1() throws Exception {
        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        //获取指定属性:要求运行时类中的属性为public
        Field id = clazz.getField("age");

        /**
         * 设置当前属性的值
         * set(): 参数1 指明哪个对象的属性， 参数2：将此属性值设置多少
         */
        id.set(p, 1001);
        /**
         * 获取当前属性的值
         * get(): 参数1 获得哪个对象的当前属性值
         */
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        //1. getDeclaredField（）:获取运行时类的指定变量名的属性:
        Field name = clazz.getDeclaredField("name");
        //2. 保证当前属性是可访问的
        name.setAccessible(true);
        //3. 获取、设置指定对象的属性值
        name.set(p, "Siri");
        System.out.println(name.get(p));


    }

    /**
     * 如何操作运行时类中的指定的方法 -- Important
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        /**
         * 1. getDeclaredField（）:获取运行时类某个方法
         * getDeclaredMethod(): 参数1. 指明获取的方法的名称 参数2 指明获取的方法的形参列表
         */

        Method show = clazz.getDeclaredMethod("show", String.class);
        /**
         * 2.确保当前方法可访问
         */
        show.setAccessible(true);
        /**
         * 3. invoke(): 参数1：方法的调用者 参数2：给方法传递的实参
         */
        Object returnValue = show.invoke(p, "CHN");//String nation = p.show("CHN");
        System.out.println(returnValue);
        System.out.println("***************如何调用静态方法********************");
        //private static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类中的方法中没有返回值，则invoke()返回null
        Object returnVal = showDesc.invoke(Person.class);
//        Object returnVal = showDesc.invoke(null);//可以运行
        System.out.println(returnVal);//null
    }
    /**
     * 运行时类的构造器
     *
     */
    @Test
    public void testConstrutor()throws Exception{
        Class clazz = Person.class;
        //private Person(String name)
        /**
         * 1. 获取指定的构造器
         * getDeclaredConstructor()参数：指明构造器的参数列表
         */
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        //2. 确保此构造器是可访问
        constructor.setAccessible(true);
        //3. 调用此构造器创建运行时类的对象
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per.toString());
    }
}