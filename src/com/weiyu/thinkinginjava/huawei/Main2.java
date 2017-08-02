package com.weiyu.thinkinginjava.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    public static class People implements Comparable<People>{
        int id;
        String gender;
        int height;
        public People(int id, String gender, int height) {
            this.id=id;
            this.gender = gender;
            this.height=height;
        }
        @Override
        public int compareTo(People o) {
            if(this.height>o.height)
                return 1;
            if(this.height<o.height)
                return -1;
            if(this.gender.equals(o.gender)&&this.height==o.height)
                return -1;
            return 0;
        }
        public String toString(){
            return String.valueOf(id);
        }
    }

    public static void getLastPeople(People[] peoples,int step){
        boolean[] visited = new boolean[peoples.length];
        int n=peoples.length;
        int count=0,i=-1;
        while(n>0){
            i++;
            if(i>=peoples.length){
                i=0;
            }
            if(visited[i])
                continue;
            count++;
            if(count==step){
                visited[i]=true;
                count=0;
                n--;
            }
        }
        System.out.println(peoples[i]);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int n=Integer.parseInt(scan.nextLine());
            People[] peoples=new People[n];
            ArrayList<People> males=new ArrayList<>();
            ArrayList<People> females=new ArrayList<>();
            for(int i=0;i<n;i++){
                String[] strs=scan.nextLine().split(" ");
                String sex=strs[1];
                if(sex.equals("MALE")){
                    males.add(new People(Integer.parseInt(strs[0]), sex, Integer.parseInt(strs[2])));
                }else{
                    females.add(new People(Integer.parseInt(strs[0]), sex, Integer.parseInt(strs[2])));
                }
            }
            Collections.sort(males);
            Collections.sort(females);
            for(int i=0;i<females.size();i++){
                peoples[i]=females.get(i);
            }
            for(int i=0;i<males.size();i++){
                peoples[females.size()+i]=males.get(i);
            }
            int step=Integer.parseInt(scan.nextLine());
            getLastPeople(peoples, step);
        }
        scan.close();
    }

}

