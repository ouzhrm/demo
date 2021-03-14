package com.ouhzrm.算法.回溯;

import org.junit.Test;

/**
 * @description:
 * @author(itcode): zhouyh3
 * @create: 2021-02-02 11:22
 **/
public class 比赛中的匹配对数 {

    @Test
    public void test(){
        System.out.println(numberOfMatches(4));
    }

    int result = 0;
    public int numberOfMatches(int n) {
        digui(n);
        return result;

    }

    void digui(int i){
        if(i == 1 || i == 0){
            return;
        }
        if( i == 2) {
            result +=1;
            return;
        }
        if(i % 2 == 0){
            result +=(i / 2);
            digui(i/2);
        }else{
            result +=((i - 1) / 2);
            digui(((i - 1) / 2 + 1));
        }
    }

}
