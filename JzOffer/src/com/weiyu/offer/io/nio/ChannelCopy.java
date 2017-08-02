package com.weiyu.offer.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Wei Yu on 2017/7/28.
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String... args){
        try {
            FileChannel in = new FileInputStream("d://helloworld.java").getChannel();
            FileChannel out = new FileOutputStream("d://output.txt").getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

            while(in.read(buffer) != -1){
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
