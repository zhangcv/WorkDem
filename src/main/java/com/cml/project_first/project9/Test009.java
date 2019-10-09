package com.cml.project_first.project9;

/**
 * Creacted by jack on 2019/9/30 10:25
 **/
public class Test009 {
    public static void main(String[] args) {
        man man = new man();
        man.theftproof();
        man.OpenDoor();
        man.bulletproof();
    }
}

abstract class Door {
    public void OpenDoor() {
        System.out.println("开门");
    }

    public void CloseDoor() {
        System.out.println("关门");
    }
}


interface TheftProof {
    //防盗
    void theftproof();
}

interface waterproof {
    //防水
    void waterproof();
}

interface bulletproof {
    //防弹
    void bulletproof();
}

class man extends Door implements TheftProof, waterproof, bulletproof {

    @Override
    public void OpenDoor() {
        System.out.println("开门");
    }

    @Override
    public void theftproof() {
        System.out.println("防盗");
    }

    @Override
    public void waterproof() {
        System.out.println("防水");
    }

    @Override
    public void bulletproof() {
        System.out.println("防弹");
    }
}