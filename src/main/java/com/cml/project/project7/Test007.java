package com.cml.project.project7;

/**
 * Creacted by jack on 2019/9/30 10:11
 **/
public class Test007 {
    public static void main(String[] args) {
        Car car = new Car();
        car.SpeedUp();
        car.Park();
    }
}

class Auto {
    public int tire;//轮胎数量

    public String color;//汽车颜色

    public int weight;//车身重量

    public int speed;//速度

    Auto() {

    }

    public Auto(int tire, String color, int weight, int speed) {
        this.tire = tire;
        this.color = color;
        this.weight = weight;
        this.speed = speed;
    }

    public void SpeedUp() {
        System.out.println("Auto加速");
    }

    public void SlowDown() {
        System.out.println("Auto减速");
    }

    public void Park() {
        System.out.println("Auto停车");
    }


}

class Car extends Auto {
    public String Cold;//空调

    public String CD;

    public void SpeedUp() {
        System.out.println("car加速");
    }

    public void SlowDown() {
        System.out.println("car减速");
    }
}