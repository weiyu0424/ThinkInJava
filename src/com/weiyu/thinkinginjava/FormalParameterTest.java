package com.weiyu.thinkinginjava;

import com.weiyu.thinkinginjava.domain.Person;

/**
 * Created by weiyu on 2017/2/17.
 * 值传递跟引用传递的区别
 */
public class FormalParameterTest {
    public static void main(String... args){
        //String str = new String("hello,world");
        Person person = new Person();
        person.age = 50;
        changePerson(person);
        System.out.println("age:" + person.age);
    }

    public static void changePerson(Person person){
        //person = new Person();
        person.age = 30;
    }
}
