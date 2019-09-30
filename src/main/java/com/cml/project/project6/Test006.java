package com.cml.project.project6;


import java.io.*;
import java.util.Scanner;

/**
 * Creacted by jack on 2019/9/30 9:16
 **/
public class Test006 {
    String[] number = new String[5];
    String[] name = new String[5];
    float[][] grade = new float[5][3];
    float[] sum = new float[5];

    public static void main(String[] args) throws Exception {
        Test006 stud = new Test006();
        stud.input();
        stud.output();
    }

    void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isRecord = true;
        while (isRecord) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("请输入学号：");
                    number[i] = br.readLine();
                    System.out.println("请输入姓名：");
                    name[i] = br.readLine();
                    for (int j = 0; j < 3; j++) {
                        System.out.println("请输入第" + (j + 1) + "门成绩：");
                        grade[i][j] = Integer.parseInt(br.readLine());
                    }
                    System.out.println();
                    sum[i] = grade[i][0] + grade[i][1] + grade[i][2];
                }
                isRecord = false;
            } catch (NumberFormatException e) {
                System.out.println("请输入一个数字");
            }
        }
    }

    void output() throws IOException {
        FileWriter fw = new FileWriter("D:/stud.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("No.  " + "Name  " + "grade1  " + "grade2  " + "grade3  " + "average");
        bw.newLine();
        for (int i = 0; i < 5; i++) {
            bw.write(number[i]);
            bw.write(" " + name[i]);
            for (int j = 0; j < 3; j++) {
                bw.write(" " + grade[i][j]);
            }
            bw.write(" " + sum[i] / 5);
            bw.newLine();

        }
        bw.close();
    }
}