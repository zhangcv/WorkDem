package com.cml.project.project5;

import java.io.*;

/**
 * Creacted by jack on 2019/9/30 9:16
 **/
public class Test005 {
    public static void main(String[] args) throws IOException
    {
        String Buffer[] = {"100","101","102","103","104","105"};

        FileWriter file = new FileWriter("d:/test.txt");
        BufferedWriter bw = new BufferedWriter(file);
        for (int i=0;i<6 ;i++ )
        {
            bw.write(Buffer[i]+',');
        }
        bw.close();
        BufferedReader br =new BufferedReader(new FileReader("d:/test.txt"));
        String content = br.readLine();
//        System.out.println(content);
        int[] newAry = strToArray(content.trim());
        for (int i =5; i>=0; i-- )
        {
            System.out.println(newAry[i]);
        }
    }
    private static int[] strToArray(String str)
    {
        String[] strAry = str.split(",");
        int[] ary = new int[strAry.length];
        for(int i =0; i< strAry.length; i++)
        {
            ary[i]= Integer.parseInt(strAry[i]);
        }
        return ary;
    }
}