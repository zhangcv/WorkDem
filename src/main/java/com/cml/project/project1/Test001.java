package com.cml.project.project1;

import java.util.Scanner;

/**
 * Creacted by jack on 2019/9/29 10:42
 **/
public class Test001 {
    public static void main(String[] args){

        System.out.println("请输入一个不多于5位的正整数");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if(input>99999)System.exit(1);
        int len = LengthNum(input);
        System.out.println("该数为"+len+"位数");
        String str = String.valueOf(input);
        char[] c = str.toCharArray();
        System.out.println("逆序打印的数为");
        for (int i = str.length()-1; i>= 0; i--) {
            System.out.print(c[i]+" ");
        }
        sc.close();
    }

    private static int LengthNum(int num) {
        int count = 0;
        while(num>=1){
            num/=10;
            count++;
        }
        return count;
    }
}