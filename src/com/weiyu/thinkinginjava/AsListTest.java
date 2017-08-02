package com.weiyu.thinkinginjava;

import java.util.*;

/**
 * Created by weiyu on 2017/2/10.
 */
public class AsListTest {

    public static void asList(){
        String[] words = ("Southeast university is world famous university").split(" ");
        //如果是直接Arrays.asList(words)，则调用Collections的shuffle方法之后，将会改变words的值，打印
        //[university, world, is, Southeast, university, famous]
        //List<String> list = Arrays.asList(words);
        List<String> list = new ArrayList<>(Arrays.asList(words));
        Collections.shuffle(list,new Random(40));
        //打印：[Southeast, university, is, world, famous, university]
        System.out.println(Arrays.toString(words));
        //list.add("hello");
    }
    public static void main(String... args){
        String[] persons = {"person1","person2"};
        //asList方法返回的对象不是一个ArrayList对象，而是一个视图对象，
        // 带有访问底层数组的get和set方法。改变数组大小的所有方法都会抛出一个 Unsupported OperationException异常
        //Array可以转化为List,同样，List类中也有一个方法toArray方法转化为Array
//        List list = Arrays.asList(persons);
//
////        list.add("hello");
//        System.out.println(list);
//
//
//
//        List<String> names = Collections.nCopies(10,"Samuel");
//        System.out.println(names);

        asList();
    }


    public void reOrderArray(int [] array) {
        List<Integer> list = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for(int i = 0;i < array.length;i++){
            if(array[i] % 2 != 0){
                list.add(array[i]);
            }else{
                even.add(array[i]);
            }
        }

        list.addAll(even);
        for(int i = 0;i < list.size();i++){
            array[i] = list.get(i);
        }
    }
}
