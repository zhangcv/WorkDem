package com.cml.project_reflect1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * ClassLoader读取配置文件的两种方式 idea maven工程
 * Creacted by jack on 2019/10/22 12:50
 **/
public class ClassLoaderTest {

    @Test
    public void test01() {
        //自定义类，系统加载器加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //无法获得引导类加载器
        //引导类加载器是 负责加载java的核心库
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);

    }

    @Test
    public void test02() throws Exception {
        Properties pros = new Properties();
        //此时的文件默认在当前的Moudle下
        //读取配置文件的方式一：
        /*FileInputStream fis = new FileInputStream("jdbc.properties");
        FileInputStream fis2 = new FileInputStream("src\\main\\resources\\jdbc1.properties");
        pros.load(fis);*/
        //读取配置文件的方式二：
//        配置文件默认识别为当前module的resources下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
//        Reader reader = new InputStreamReader(new FileInputStream("src\\main\\resources\\jdbc1.properties"));
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println(user + " " + password);
    }
}