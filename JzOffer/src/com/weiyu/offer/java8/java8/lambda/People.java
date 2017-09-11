package com.weiyu.offer.java8.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class People {
    private List<Person> persons = new ArrayList<Person>();

    public List<Person> getMaleList(PersonInterface filter) {
        List<Person> res = new ArrayList<Person>();

        for(Person person : persons){
            if(filter.test(person)){
                res.add(person);
            }
        }
        persons.forEach(
                (Person person) ->
                {
                    if (filter.test(person)) {//调用 PersonInterface 的方法
                        res.add(person);
                    }
                }
        );
        return res;
    }
}