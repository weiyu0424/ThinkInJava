package com.weiyu.thinkinginjava.enumtation;

import static com.weiyu.thinkinginjava.enumtation.Burritor.Spiciness.HOT;
import static com.weiyu.thinkinginjava.enumtation.Burritor.Spiciness.MEDIUM;
import static com.weiyu.thinkinginjava.enumtation.Burritor.Spiciness.NOT;

/**
 * Created by Wei Yu on 2017/9/4.
 */
public class Burritor {
    public enum Spiciness {
        NOT, MILD, MEDIUM, HOT, FLAMING
    }
    Spiciness degree;
    public Burritor(Spiciness spiciness){
        this.degree = spiciness;
    }

    @Override
    public String toString() {
        return "Burritor is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burritor(NOT));
        System.out.println(new Burritor(MEDIUM));
        System.out.println(new Burritor(HOT));
    }
}
