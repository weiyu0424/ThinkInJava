package com.weiyu.thinkinginjava;

import java.io.*;
import java.util.Properties;

/**
 * Created by weiyu on 2017/2/10.
 */
public class PropertiesTest {
    public static void main(String... args){
       // writeIntoFile();
        //readFromFile();
        readFromClassPath();
    }

    private static void writeIntoFile() {
        Properties properties = new Properties();

        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream("config.properties");
            properties.put("username","sam");
            properties.put("password","samuel");
            properties.store(outputStream,null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFile(){
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            properties.load(input);
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            System.out.println("username:" + username + ";password:" + password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromClassPath(){
        Properties properties = new Properties();
        InputStream input = null;
        input = PropertiesTest.class.getClassLoader().getResourceAsStream("config.properties");
        if(null == input){
            System.out.println("sorry for not finding the file config.properties");
        }
        try {
            properties.load(input);
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            System.out.println("username:" + username + ";password:" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
