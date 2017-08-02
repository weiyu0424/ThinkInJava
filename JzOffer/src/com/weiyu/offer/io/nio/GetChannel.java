package com.weiyu.offer.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Wei Yu on 2017/7/28.
 */
public class GetChannel {
    private static final int BSIZE = 1024;
    public static void main(String... args){
        try {
            FileChannel fc = new FileOutputStream("d://data.txt").getChannel();
            fc.write(ByteBuffer.wrap("Some text".getBytes()));
            fc.close();

            //add to the end of file
            fc = new RandomAccessFile("d://data.txt","rw").getChannel();
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap(",some more text".getBytes()));
            fc.close();

            //read the file
            fc = new FileInputStream("d://data.txt").getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
            fc.read(buffer);
            buffer.flip();

            while(buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
