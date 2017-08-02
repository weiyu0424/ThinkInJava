package com.weiyu.offer.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by Wei Yu on 2017/7/28.
 */
public class TransferTo {
    public static void main(String... args){
        try {
            FileChannel in = new FileInputStream("d://helloworld.java").getChannel();
            FileChannel out = new FileOutputStream("d://output11.txt").getChannel();
            in.transferTo(0,in.size(),out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
