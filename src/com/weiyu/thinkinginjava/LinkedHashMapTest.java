package com.weiyu.thinkinginjava;

import com.weiyu.thinkinginjava.domain.Employee;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by weiyu on 2017/2/6.
 * LinkedHashMap用来记住插入元素的顺序
 * 因为一般散列表中插入的元素的顺序都是随机的
 */
public class LinkedHashMapTest {
    public static void main(String... args){
        Map staff = new LinkedHashMap<String,Employee>();
        staff.put("144-24",new Employee("Amy Lee"));
        staff.put("24-2545",new Employee("Harry Hacker"));
        staff.put("62-7935",new Employee("Gary Cooper"));
        staff.put("62-5527",new Employee("Francesca Cruz"));

        Iterator<Map.Entry<String,Employee>> iterator = staff.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Employee> employee = iterator.next();
            System.out.println("key:" + employee.getKey() + ";value:" + employee.getValue());
        }

    }
}
