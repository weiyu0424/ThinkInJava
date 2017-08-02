package com.weiyu.offer.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Wei Yu on 2017/7/27.
 */
public class UsingRandomAccessFile {
    static String file = "rtest.dat";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file,"r");
        for(int i = 0;i < 7;i++){
            System.out.println("Value: " + i + ": " + rf.readDouble());
        }
    }

    public static void main(String... args){
        try {
            RandomAccessFile rf = new RandomAccessFile(file,"rw");
            for(int i = 0;i < 7;i++){
                rf.writeDouble(i*1.414);
            }
            rf.writeUTF("The end of the file");
            rf.close();
            display();
            System.out.println("====================");
            rf = new RandomAccessFile(file,"rw");
            rf.seek(5 * 8);
            rf.writeDouble(47.001);
            rf.close();
            display();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
