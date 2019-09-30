package com.cml.project.project3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Creacted by jack on 2019/9/29 11:00
 **/
public class Test003 {
    public static void main(String[] args){
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        quickSort(arr,0,arr.length-1);
        int arr1[] = { 1, 8, 10, 89, 1000,1000,1000,1000, 1234 };
        System.out.println(Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        List<Integer> resIndexList = binarySearch(arr, 0, arr.length - 1, val);
        if(resIndexList.size()==0){
            System.out.println(-1);
        }else {
            System.out.println(resIndexList);
            System.out.println("第一次出现的位置为数组中的位置为a[" + (resIndexList.get(0)) + "]");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;

        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort(arr, left, r);// 把左边的变成有序的
        }
        if (right > l) {
            quickSort(arr, l, right);// 把右边的变成有序的
        }
    }

    public static List<Integer> binarySearch(int[] arr, int left , int right, int findVal)
    {


        if (left > right)
            return new ArrayList<Integer>();
        int mid =(left+right)/2;
        int midVal=arr[mid];

        if(findVal>midVal) {
            return binarySearch(arr, mid+1,right, findVal);
        }
        if(findVal<midVal) {
            return binarySearch(arr, left,mid-1, findVal);
        }
        else {
            ArrayList<Integer> resIndexlist =  new ArrayList<Integer>();
            //向mid 索引值的左边扫描，将所有满足1000，的元素的下标，加入到集合ArrayList
            int temp =mid-1;
            while(true)
            {
                if(temp<0||arr[temp]!=findVal)
                {//temp到左边，退出
                    break;
                }
                //否则，就将temp放入到resIndexlist中
                resIndexlist.add(temp);
                temp-=1;//temp左移
            }
            resIndexlist.add(mid);

            temp=mid+1;
            while(true)
            {
                if(temp>arr.length-1||arr[temp]!=findVal)
                {
                    //退出
                    break;
                }
                //否则，就将temp放入到resIndexlist
                resIndexlist.add(temp);
                temp+=1;//temp右移
            }
            return resIndexlist;
        }
    }

}

