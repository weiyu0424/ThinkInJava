package com.weiyu.offer.io.nio;

import java.nio.*;

/**
 * Created by Wei Yu on 2017/7/28.
 */
public class ViewBuffer {
    public static void main(String... args){
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
        bb.rewind();
        System.out.println("Byte Buffer");
        while(bb.hasRemaining()){
            System.out.println(bb.position() + ":" + bb.get());
        }

        System.out.println("============Char Buffer==============");
        bb.rewind();
        CharBuffer cb = bb.asCharBuffer();
        while(cb.hasRemaining()){
            System.out.println(cb.position() + ":" + cb.get());
        }


        System.out.println("===============Float Buffer================");
        FloatBuffer fb = bb.asFloatBuffer();
        while(fb.hasRemaining()){
            System.out.println(fb.position() + ":" + fb.get());
        }

        System.out.println("===============IntBuffer================");
        IntBuffer ib = bb.asIntBuffer();
        while(ib.hasRemaining()){
            System.out.println(ib.position() + ":" + ib.get());
        }

        System.out.println("===============LongBuffer================");
        LongBuffer lb = bb.asLongBuffer();
        while(lb.hasRemaining()){
            System.out.println(lb.position() + ":" + lb.get());
        }

        System.out.println("===============ShortBuffer================");
        ShortBuffer sb = bb.asShortBuffer();
        while(sb.hasRemaining()){
            System.out.println(sb.position() + ":" + sb.get());
        }

    }
}
