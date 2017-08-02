package com.weiyu.thinkinginjava.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Wei Yu on 2017/6/9.
 * 击鼓传花笔试题
 */
public class ChuanHua {
    static class Person implements Comparable<Person>{
        private int id;
        private String gender;
        private int height;


        @Override
        public int compareTo(Person o) {
            if(height > o.height)
                return 1;
            else if(height < o.height)
                return -1;
            if(gender.equals(o.gender) && height == o.height)
                return -1;
            return 0;
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public static void getLastPerson(Person[] persons,int step){
        int count = 0;
        int n = persons.length;
        int i = -1;
        boolean[] visited = new boolean[n];
        while(n > 0){
            i++;
            if(i >= persons.length){
                i = 0;
            }
            if(visited[i])
                continue;
            count++;
            if(step == count){
                visited[i] = true;
                count = 0;
                n--;
            }
        }
        System.out.println(persons[i].getId());
    }

    public static void main(String... args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = Integer.parseInt(in.nextLine());
            Person[] persons = new Person[n];
            List<Person> males = new ArrayList<>();
            List<Person> females = new ArrayList<>();
            for(int i = 0;i < n;i++){
                String line = in.nextLine();
                String[] attributes = line.split(" ");
                int id = Integer.parseInt(attributes[0]);
                String gender = attributes[1];
                int height = Integer.parseInt(attributes[2]);
                Person person = new Person();
                person.setId(id);
                person.setGender(gender);
                person.setHeight(height);

                if("MALE".equals(gender)){
                    males.add(person);
                }else{
                    females.add(person);
                }
            }
            Collections.sort(males);
            Collections.sort(females);
            for(int i = 0;i < females.size();i++){
                persons[i] = females.get(i);
            }
            for(int i = 0;i < males.size();i++){
                persons[i + females.size()] = males.get(i);
            }
            int step = in.nextInt();
            getLastPerson(persons,step);
        }
        in.close();
    }
}
