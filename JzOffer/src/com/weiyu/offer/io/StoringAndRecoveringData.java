package com.weiyu.offer.io;

import java.io.*;

/**
 * Created by Wei Yu on 2017/7/27.
 */
public class StoringAndRecoveringData {
    public static void main(String... args){
        try {
            DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("d://dataOutputStream.java")));
            output.writeDouble(3.1415926);
            output.writeUTF("That was pi");
            output.writeDouble(1.4143);
            output.writeUTF("Square root of 2");
            output.close();

            DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("d://dataOutputStream.java")));
            System.out.println(input.readDouble());
            System.out.println(input.readUTF());
            System.out.println(input.readDouble());
            System.out.println(input.readUTF());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
