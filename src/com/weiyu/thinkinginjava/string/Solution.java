package com.weiyu.thinkinginjava.string;

/**
 * Created by weiyu on 2017/3/6.
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        if(str == null) return null;
        String s = null;
        int len = str.length();
        int newLen = len;
        System.out.println("len:" + len);
        char c;
        for(int i=0; i < len; i++){
            c = str.charAt(i);
            if(c == ' '){
                newLen += 2;
            }
        }

        if(newLen == len)
            return str.toString();
        char[] newStr = new char[newLen];
        for(int i = len - 1;i >= 0;i--){
            if(str.charAt(i) != ' '){
                newStr[--newLen] = str.charAt(i);
            }else{
                newStr[newLen - 1] = '0';
                newStr[newLen - 2] = '2';
                newStr[newLen - 3] = '%';
                newLen -= 3;
            }
        }
        return new String(newStr);
    }

    public static void test(){
        int a;
        //System.out.println(a);
    }
    public static void main(String[] args){
       /* StringBuffer str = new StringBuffer("a   b c  d");
        String result = new Solution().replaceSpace(str);
        System.out.println("result:" + result);*/

    }
}