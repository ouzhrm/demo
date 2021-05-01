package com.ouhzrm.牛客top200;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-04-21 14:37
 **/
public class 寻找第K大 {

    @Test
    public void etts(){
        System.out.println(findKth(new int[]{1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663},49,24));
    }



    public int findKth(int[] a, int n, int K) {
        // write code here 14:28
        //quickSort(a,0,a.length-1,K);
        Arrays.sort(a);
        return a[K-1];
    }

    void quickSort(int[] a, int left, int right,int k){
        if(left >= right) return;
        int ltmp = left;
        int rtmp = right;
        int middle = right;
        while(ltmp < rtmp){
            while(ltmp <= a.length-1 && a[ltmp] <= a[middle]){
                ltmp++;
            }
            if(ltmp < rtmp){
                a[ltmp] ^= a[middle];
                a[middle] ^= a[ltmp];
                a[ltmp] ^= a[middle];
                middle = ltmp;
            }
            while(rtmp >= 0 && a[middle] <= a[rtmp]){
                rtmp--;
            }
            if(ltmp < rtmp){
                a[rtmp] ^= a[middle];
                a[middle] ^= a[rtmp];
                a[rtmp] ^= a[middle];
                middle = rtmp;
            }
        }
//        if(k < middle+1){
            quickSort(a,  left,  middle-1, k);
//        }else{
            quickSort(a,  middle+1,  right, k);
//        }
    }

}
