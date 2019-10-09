package com.juc.demo201906;

/**
 * Creacted by jack on 2019/10/31 15:15
 **/
public class Test {

    public static void main(String[] args) {

        int a = 1;
        int b = 0;
        boolean flag =true;
        int n = 4;//尝试次数 n-1
        try {
            while (flag) {
                getA(a, a/b);
            }


        } catch (Exception e) {
            System.out.println("出错了");
        }
    }

    private static int getA(int a, int i) {
        a = i;
        return a;
    }

}
