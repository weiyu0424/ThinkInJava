package com.weiyu.thinkinginjava.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by weiyu on 2017/4/21.
 */
public class PokeTest {
    public static void main(String... args){
        Scanner in = new Scanner(System.in);
        int[] cards = new int[5];
        String[] colors = new String[5];
        Map<String,String> params = new HashMap<>();
        params.put("J","11");
        params.put("Q","12");
        params.put("K","13");
        params.put("A","14");
        for(int i = 0;i < 5;i++){
            String temp= in.next();
            int card = 0;
            try{
                card = Integer.parseInt(temp);
            }catch (NumberFormatException e){
                try{
                    card = Integer.parseInt(params.get(temp));
                }catch (NumberFormatException e1){
                    System.out.println("invalid input");
                    return;
                    //e1.printStackTrace();
                }
            }

            cards[i] = card;
            colors[i] = in.next();
        }
        Arrays.sort(cards);

        int result = judgeCardType(cards,colors);
        System.out.println(result);
    }


    private static int judgeCardType(int[] cards, String[] colors) {
        if(colors[0].equals(colors[1]) && colors[1].equals(colors[2]) && colors[3] .equals(colors[4])){
            if((cards[0] + 1 == cards[1]) && (cards[1] + 1 == cards[2]) && (cards[2] + 1 == cards[3]) && (cards[3] + 1 == cards[4])) {
                //同花顺
                return 1;
            }else{
                //同一花色
                return 4;
            }
        }else{
            if(colors[0].equals(colors[1]) && colors[1].equals(colors[2]) && colors[3] .equals(colors[4])){
                //顺子
                return 5;
            }else if(findDuplicate(cards,4)) {
                //四条
                return 2;
            }else if(findDuplicate(cards,3) && findDuplicate(cards,2)){
                //三条加一对
                return 3;
            }else if(findDuplicate(cards,3) && findDuplicate(cards,1)){
                //三条加单张
                return 6;
            }else
                return 7;
        }
    }

    public static boolean findDuplicate(int[] cards,int value){
        Map<Integer,Integer> map = new HashMap<>();
        for(int card : cards){
            if(map.containsKey(card))
                map.put(card,map.get(card) + 1);
            else
                map.put(card,1);
        }
        if(map.containsValue(value))
            return true;
        return false;
    }
}
