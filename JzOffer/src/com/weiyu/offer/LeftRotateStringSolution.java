package com.weiyu.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Wei Yu on 2017/7/10.
 */
public class LeftRotateStringSolution {

    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），
     * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if(null == str || str.length() == 0 || 1 == str.length())
            return str;
        if(n > str.length()){
            n %= str.length();
        }

        char[] array = str.toCharArray();

        if(n > 0 && n < array.length){
            reverse(array,0,n - 1);
            reverse(array,n, array.length - 1);
            reverse(array,0, array.length - 1);
        }

        return new String(array);
    }

    public void reverse(char[] array, int left, int right){
        while(left <= right){
            char c = array[left];
            array[left] = array[right];
            array[right] = c;
            left++;
            right--;
        }
    }

    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
     * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
     * 但却读不懂它的意思。例如，“student. a am I”。
     * 后来才意识到，这家伙原来把句子单词的顺序翻转了，
     * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if("".equals(str.trim()))
            return str;
        String[] splits = str.split("\\s");
        int left = 0;
        int right = splits.length - 1;
        while(left <= right){
            String temp = splits[left];
            splits[left] = splits[right];
            splits[right] = temp;
            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < splits.length;i++){
            String phrase = splits[i];
            if(i != splits.length - 1){
                sb.append(phrase).append(" ");
            }else{
                sb.append(phrase);
            }
        }

        return sb.toString();
    }

    public static void main(String... args){
        //String result = new LeftRotateStringSolution().ReverseSentence(" ");
        String result = new LeftRotateStringSolution().LeftRotateString("abcdefg",2);
        System.out.println(result);
    }
}
