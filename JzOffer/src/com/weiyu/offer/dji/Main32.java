package com.weiyu.offer.dji;

import java.util.Scanner;

public class Main32 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int len = in.nextInt();
            Car carA = new Car(1,in.nextInt(),in.nextInt(),in.nextInt());
            Car carB = new Car(2,in.nextInt(),in.nextInt(),in.nextInt());

            int count = solution(len,carA,carB);
            System.out.println(count);
        }
        in.close();
    }

    private static int solution(int len, Car a, Car b) {
        while(a.power != 0 && b.power != 0){
            if(a.power == 0 && b.power == 0)
                break;
            else if(Math.abs(a.locate-b.locate)==1){
                if(a.direction+b.direction==0) {
                    if (a.power != 0 && b.power != 0) {
                        a.direction=0-a.direction;
                        b.direction=0-b.direction;
                        a.locate+=a.direction;
                        a.power--;
                        b.locate+=b.direction;
                        b.power--;
                    }else if(a.power==0 && a.power!=0){
                        a.direction=b.direction;
                        b.power-=2;
                        a.locate+=a.direction;
                        b.locate+=a.direction;
                    }else if(a.power!=0 && a.power==0){
                        b.direction=a.direction;
                        a.power-=2;
                        a.locate+=a.direction;
                        b.locate+=b.direction;
                    }else
                        break;
                }
            }else if(a.power!=0){
                a.power--;
                a.locate+=a.direction;
            }else if(b.power!=0){
                b.power--;
                b.locate+=a.direction;
            }

        }

        int count=0;
        if(a.locate<=0||a.locate>len-1)
            count++;
        if(b.locate<=0||b.locate>len-1)
            count++;
        return count;
    }


    private static class Car{
        int no;
        int power;
        int locate;
        int direction;

        public Car(int no, int power, int locate, int direction) {
            this.no = no;
            this.power = power;
            this.locate = locate;
            this.direction = direction;
        }

    }

}

