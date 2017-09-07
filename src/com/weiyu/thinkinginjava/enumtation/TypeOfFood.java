package com.weiyu.thinkinginjava.enumtation;

/**
 * Created by Wei Yu on 2017/9/4.
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        System.out.println(food);
        food = Food.MainCourse.LASAGNE;
        System.out.println(food);
        food = Food.Dessert.GELATO;
        System.out.println(food);
        food = Food.Coffee.CAPPUCCINO;
        System.out.println(food);
    }
}
