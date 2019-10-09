package com.cml.project_reflect2;

/**
 * Creacted by jack on 2019/10/22 14:58
 **/
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {

    private String name;
    int age;
    public int id;

    public Person() {
    }
    @MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国家是" + nation);
        return nation;
    }
    public String display(String intrests,int age) throws NullPointerException,ClassCastException{
        return intrests+age;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个Person");
    }

    private static void showDesc(){
        System.out.println("我是一个程序员");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}