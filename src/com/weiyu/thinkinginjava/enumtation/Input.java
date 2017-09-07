package com.weiyu.thinkinginjava.enumtation;

import java.util.Random;

/**
 * Created by Wei Yu on 2017/9/4.
 */
public enum Input {
    NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),
    TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION{
        public int amount(){
            throw new RuntimeException(name() + ": ABORT.amount()");
        }
    },
    STOP{
        public int amount(){
            throw new RuntimeException(name() + ": SHUT_DOWN.amount()");
        }
    };

    int value;
    Input(){}
    Input(int value){
        this.value = value;
    }

    int amount(){
        return value;
    }

    static Random random = new Random(47);

    public static Input randomSelection(){
        return values()[new Random().nextInt(values().length - 1)];
    }

    @Override
    public String toString() {
        return name() + ":" + amount();
    }

    public static void main(String[] args) {
        System.out.println(Input.randomSelection());
    }
}
