package com.cml.project_reflect2;

import java.io.Serializable;

/**
 * Creacted by jack on 2019/10/22 14:58
 **/
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物需要呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}