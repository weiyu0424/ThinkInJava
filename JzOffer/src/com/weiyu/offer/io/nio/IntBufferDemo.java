package com.weiyu.offer.io.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created by Wei Yu on 2017/7/28.
 */
public class IntBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String... args){
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = buffer.asIntBuffer();

        ib.put(new int[]{11,42,47,99,143,811,1016});
        System.out.println(ib.get(3));
        ib.put(3,1811);
        ib.flip();

        while(ib.hasRemaining()){
            int i = ib.get();
            System.out.println(i);
        }
    }
}
