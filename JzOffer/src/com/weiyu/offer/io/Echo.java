package com.weiyu.offer.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Wei Yu on 2017/7/28.
 */
public class Echo {
    public static void main(String... args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try{
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
