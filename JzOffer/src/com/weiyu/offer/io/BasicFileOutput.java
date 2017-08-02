package com.weiyu.offer.io;

import java.io.*;

/**
 * Created by Wei Yu on 2017/7/27.
 */
public class BasicFileOutput {
    static String file = "d://output.java";
    public static void main(String... args){
        BufferedReader in = new BufferedReader(new StringReader(new BufferedReaderInputFile().read("d://helloworld.java")));
        PrintWriter output = null;
        try {
            output = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            String line = null;
            int lineCount = 1;
            while((line = in.readLine()) != null){
                output.println(lineCount++ + ":" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(output != null){
                output.close();
            }
        }
    }
}
