package com.weiyu.thinkinginjava.huawei;

/**
 * Created by xpZhu on 2017/5/31.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChuanHua {
    static List<Integer> ids = new ArrayList<>();
    static List<String> genders = new ArrayList<>();
    static List<Integer> heights = new ArrayList<>();
    public static void swap(int i,int j){
        int tmpint;
        String tmpstr;
        int tmpint1;
        tmpint = ids.get(i);
        tmpstr = genders.get(i);
        tmpint1 = heights.get(i);
        ids.set(i, ids.get(j));
        genders.set(i, genders.get(j));
        heights.set(i, heights.get(j));
        ids.set(j, tmpint);
        genders.set(j, tmpstr);
        heights.set(j, tmpint1);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int id = 0;
        String gender = null;
        int height = 0;
        for(int i = 0; i < num; i++){
            id = in.nextInt();
            gender = in.next();
            height = in.nextInt();
            ids.add(id);
            genders.add(gender);
            heights.add(height);
//            ids.add(in.nextInt());
//            genders.add(in.next());
//            heights.add(in.nextInt());
        }


        int step = in.nextInt();

        //排序
        for(int i=0;i<ids.size()-1;i++){
            for(int j=i+1;j<ids.size();j++){
                if(heights.get(j)< heights.get(i)){
                    swap(i, j);
                }
                else if (heights.get(j)== heights.get(i)){
                    if ("FEMALE".equals(genders.get(j))) {
                        swap(i, j);
                    } else if (genders.get(j).equals(genders.get(i))) {
                        swap(i, j);
                    }
                }
            }
        }


        int begin = -1;
        for(int i = 0; i< genders.size(); i++){
            if(genders.get(i).equals("FEMALE")){
                begin = i;
                break;
            }
        }

        int temp = 0;
        int size = ids.size();
        boolean flag=true;
        int k;
        while(size > 1){
            /*if(flag==true){
                k = begin;
                flag = false;
            }else{
                k=0;
            }*/
            k = 0;
            for(int i = k;i < ids.size();i++){
                if(ids.get(i)>0){
                    temp++;
                    if(temp==step){
                        temp=0;
                        ids.set(i, -1);
                        size--;
                    }
                }
            }
        }
        for (Integer i : ids) {
            if (i != -1) {
                System.out.println(i);
            }
        }
    }
}

