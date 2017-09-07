package com.weiyu.thinkinginjava.enumtation;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Wei Yu on 2017/9/4.
 */
public enum ConstantSpecificMethod {
    DATE_TIME{
        String getInfo(){
            return DateFormat.getDateInstance().format(new Date());
        }

        public void hello(){
            System.out.println(name());
        }
    },
    CLASSPATH{
        String getInfo(){
            return System.getenv("CLASSPATH");
        }

        public void hello(){
            System.out.println(name());
        }
    },
    VERSION{
        String getInfo(){
            return System.getProperty("java.version");
        }

        @Override
        void hello() {
            System.out.println(name());
        }
    };

    abstract String getInfo();
    abstract void hello();

    public static void main(String[] args) {
        for(ConstantSpecificMethod csm : values()){
            System.out.println(csm.getInfo());
            csm.hello();
        }
    }
}
