package com.ouhzrm.算法.other;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<String> productData = new ArrayList<>();
        productData.add("1");
        productData.add("2");
        productData.add("3");
        List<String> productData2 = new ArrayList<>();
        String[] str1 = new String[]{"1","2","3"};
        for(String str : str1){
            productData2.add(str);
        }
        List<String> productData3 = new ArrayList<>();

        for(String productRecommendedInfo: productData){
            productData2.remove(productRecommendedInfo);
        }
        System.out.println(productData2.toString());


    }
}
