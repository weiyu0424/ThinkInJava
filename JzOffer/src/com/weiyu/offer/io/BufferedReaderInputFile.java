package com.weiyu.offer.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Wei Yu on 2017/7/25.
 * //缓冲输入文件
 */
public class BufferedReaderInputFile {
    public static String read(String fileName){
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
            String line = null;
            while((line = reader.readLine()) != null){
                sb.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static void main(String... args){
        String result = BufferedReaderInputFile.read("d://helloworld.java");
        System.out.println(result);
    }
}
