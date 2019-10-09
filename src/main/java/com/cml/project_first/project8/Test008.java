package com.cml.project_first.project8;

/**
 * Creacted by jack on 2019/9/30 10:19
 **/
public class Test008 {
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.start();
        Bus bus = new Bus();
        bus.stop(null);
    }
}

interface Vehicle {
    void start();

    void stop(String cars);
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("自行车起步");
    }

    public void stop(String cars) {
        System.out.println("自行车停车");
    }
}

class Bus implements Vehicle {
    public void start() {
        System.out.println("公交车起步");
    }

    public void stop(String cars) {
        System.out.println("公交车停车");
    }
}