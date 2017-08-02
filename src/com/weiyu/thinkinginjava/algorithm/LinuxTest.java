package com.weiyu.thinkinginjava.algorithm;

import java.util.Arrays;

/**
 * Created by weiyu on 2017/4/11.
 */
public class LinuxTest {
    public static void main(String... args){
        String order = "/foo,/foo/bar,/foor/house";
        String[] orders = order.split(",");

        String temp = null;
        int count = 0;
        for(String sentence : orders){
            String str = sentence.substring(1,sentence.length());
            String[] sentences = str.split("/");
            //System.out.println(Arrays.toString(sentences));
            if(sentences.length == 1){
                if(0 == count){
                    System.out.println("mkdir " + sentence);
                    count++;
                }else{
                    if(!sentence.contains(temp)){
                        System.out.println("mkdir " + sentence);
                        count++;
                    }
                }
                temp = sentence;
            }else{
                if(sentence.contains(temp)){
                    String resude = sentence.substring(temp.length(),sentence.length());
                    //System.out.println(resude);
                    resude = resude.substring(1,resude.length());
                    String[] resudes = resude.split("/");
                }
            }
        }
    }
}
