package com.weiyu.offer.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Wei Yu on 2017/7/27.
 */
public class TestEOF {
    public static void main(String... args){
        try{
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("D://helloworld.java")));
            while(in.available() > 0){
                System.out.print((char)in.readByte());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
