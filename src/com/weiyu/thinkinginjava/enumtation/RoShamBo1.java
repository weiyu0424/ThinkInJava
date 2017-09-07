package com.weiyu.thinkinginjava.enumtation;

import java.util.Random;

/**
 * Created by Wei Yu on 2017/9/4.
 */

public class RoShamBo1 {
    enum Outcome{
        WIN,LOSE,DRAW
    }

    interface Item{
        Outcome compute(Item item);
        Outcome eval(Paper paper);
        Outcome eval(Scissors s);
        Outcome eval(Rock rock);
    }

    static class Paper implements Item{

        @Override
        public Outcome compute(Item item) {
            return item.eval(this);
        }

        @Override
        public Outcome eval(Paper paper) {
            return Outcome.DRAW;
        }

        @Override
        public Outcome eval(Scissors s) {
            return Outcome.WIN;
        }

        @Override
        public Outcome eval(Rock rock) {
            return Outcome.LOSE;
        }
    }

    static class Scissors implements Item{

        @Override
        public Outcome compute(Item item) {
            return item.eval(this);
        }

        @Override
        public Outcome eval(Paper paper) {
            return Outcome.LOSE;
        }

        @Override
        public Outcome eval(Scissors s) {
            return Outcome.DRAW;
        }

        @Override
        public Outcome eval(Rock rock) {
            return Outcome.WIN;
        }
    }


    static class Rock implements Item{

        @Override
        public Outcome compute(Item item) {
            return item.eval(this);
        }

        @Override
        public Outcome eval(Paper paper) {
            return Outcome.WIN;
        }

        @Override
        public Outcome eval(Scissors s) {
            return Outcome.LOSE;
        }

        @Override
        public Outcome eval(Rock rock) {
            return Outcome.DRAW;
        }
    }

    static final int SIZE = 20;
    private static Random random = new Random(47);
    public static Item newItem(){
        switch (random.nextInt(3)){
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item a, Item b){
        System.out.println(a + " VS " + b + ": " + a.compute(b));
    }

    public static void main(String[] args) {
        for(int i = 0;i < SIZE;i++){
            match(newItem(),newItem());
        }
    }
}
