package com.weiyu.thinkinginjava;

import com.weiyu.thinkinginjava.domain.Employee;

import java.util.*;

/**
 * Created by weiyu on 2017/2/10.
 */
public class CollectionsTest {
    public static void main(String... args){
        List<String> values = new ArrayList<>(10);
        values.add("nihao");
        Collections.fill(values,"hello");
        System.out.println(values);

        Hashtable<String,Employee> staff = new Hashtable<>();
        staff.put("one",new Employee("zhangsan"));
        staff.put("second",new Employee("Lisi"));
        staff.put("three",new Employee("Wangwu"));
        Enumeration<Employee> elements = staff.elements();
        while(elements.hasMoreElements()){
            Employee employee = elements.nextElement();
            System.out.println(employee);
        }

        Set<Map.Entry<String,Employee>> set = staff.entrySet();
        Iterator<Map.Entry<String, Employee>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Employee> item = iterator.next();
            System.out.println("key:" + item.getKey() + ":value:" + item.getValue());
        }

        for(Map.Entry<String,Employee> employee : staff.entrySet()){
            System.out.println("key:" + employee.getKey() + ";value:" + employee.getValue());
        }


        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("world");
        System.out.println(vector);

        for(String value : vector){
            System.out.println(value);
        }

    }
}
