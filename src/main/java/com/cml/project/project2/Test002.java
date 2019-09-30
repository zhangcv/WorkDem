package com.cml.project.project2;

import java.util.Scanner;

/**
 * Creacted by jack on 2019/9/29 11:25
 **/
public class Test002 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println("==============");
        //递归调用
        for (int i = 0; i < input; i++) {
            long num =fei(i);
            System.out.println(num);
        }
        //非递归调用
        System.out.println("==============");
        for (int i = 0; i < input; i++) {
            if(i==0)System.out.println(1);
            else {
                long num2 = fei2(i);
                System.out.println(num2);
            }
        }
    }

    /**
     *  递归调用
     * @param n
     * @return
     */
    public static long fei (int n){
       if(n==1||n==0)return 1;
       else{
           return fei(n-1)+fei(n-2);
       }
    }

    /**
     *  非递归调用
     * @param n
     * @return
     */
    public static long fei2(int n){
        long[] arr = new long[n+1];
        arr[0]=1;
        arr[1]=1;
        for (int i = 2; i <=arr.length-1; i++) {
            arr[i]= arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}