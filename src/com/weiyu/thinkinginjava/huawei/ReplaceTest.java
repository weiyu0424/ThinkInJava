package com.weiyu.thinkinginjava.huawei;

/**
 * Created by xpZhu on 2017/5/31.
 */
public class ReplaceTest {
    public String replaceSpace(StringBuffer str) {
        String line = str.toString();
        int offset = 0;
        int length = line.length();
        for(int i = 0;i < length;i++){
            if(' ' == line.charAt(i)){
                offset += 2;
            }
        }
        int newLength = length + offset;
        if(0 == offset){
            return line;
        }

        char[] newLine = new char[newLength];
        int i = 0,j = 0;
        while(i < length && j < newLength){
            char c = line.charAt(i);
            if(c != ' '){
                newLine[j] = c;
                i++;
                j++;
            }else{
                newLine[j] = '%';
                newLine[j + 1] = '2';
                newLine[j + 2] = '0';
                i++;
                j += 3;
            }
        }
        return new String(newLine);
    }


    public static void main(String... args){
        String line = new ReplaceTest().replaceSpace(new StringBuffer("Hello world"));
        System.out.println(line);
    }
}
