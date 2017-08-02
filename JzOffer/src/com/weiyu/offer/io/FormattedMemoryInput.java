package com.weiyu.offer.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created by Wei Yu on 2017/7/27.
 */
public class FormattedMemoryInput {
    public static void main(String... args){
        try{
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedReaderInputFile.read("d://helloworld.java").getBytes()));
            while(in.available() != 0)
                System.out.print((char)in.readByte());
        }catch(EOFException e){
            System.err.println("End of stream");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
