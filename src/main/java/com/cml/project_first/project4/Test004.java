package com.cml.project_first.project4;


import java.util.Scanner;

/**
 * Creacted by jack on 2019/9/29 17:09
 **/

/**
 * 输入 abc def 返回
 */
public class Test004 {
    public static void main(String[] args) {

        String str1 = null, str2 = null;
        int i1, i2;
        float f1, f2;
        boolean isRecord = true;
        while(isRecord) {
            Scanner sc = new Scanner(System.in);
            System.out.println("输入的第一个字符串");
            str1 = sc.nextLine();
            System.out.println("输入的第二个字符串");
            str2 = sc.nextLine();
            if (tryParseInt(str1) && tryParseInt(str2)) {
                i1 = Integer.parseInt(str1);
                i2 = Integer.parseInt(str2);
                String result2 = strAdd(i1, i2);
                System.out.println("整数处理：" + result2);
                isRecord=false;
            } else if (!tryParseInt(str1) && !tryParseInt(str2)&&tryParseFloat(str1) && tryParseFloat(str2)) {
                f1 = Float.parseFloat(str1);
                f2 = Float.parseFloat(str2);
                String result3 = strAdd(f1, f2);
                System.out.println("浮点数处理：" + result3);
                isRecord=false;
            } else if (!tryParseFloat(str1) && !tryParseFloat(str2)) {
                String result1 = strAdd(str1, str2);
                System.out.println("字符串拼接：" + result1);
                isRecord=false;
            } else {
                System.out.println("请输入两个字母或者两个整数或者两个浮点数");
            }
        }
    }
    static boolean tryParseFloat(String value){
        try{
            Float.parseFloat(value);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    static boolean tryParseInt(String value){
        try{
            Integer.parseInt(value);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }


    public static String strAdd(String str1, String str2) {
        return str1 + str2;
    }

    public static String strAdd(int int1, int int2) {
        return String.valueOf(int1 + int2);
    }

    public static String strAdd(float flt1, float flt2) {
        return String.valueOf(flt1 + flt2);
    }

}