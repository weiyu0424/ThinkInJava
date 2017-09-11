package com.weiyu.offer.dji;


import java.util.Scanner;

public class Main31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int len = in.nextInt();
            Car a = new Car(1,in.nextInt(),in.nextInt(),in.nextInt());
            Car b = new Car(1,in.nextInt(),in.nextInt(),in.nextInt());

            int count = solve(len,a,b);
            System.out.println(count);
        }
    }

    private static int solve(int len, Car a, Car b) {
        while(a.getPower() != 0 && b.getPower() != 0){

            if(a.getPower() == 0 && b.getPower() == 0)//ab都静止就跳出
                break;
            else if(Math.abs(a.getLocate() - b.getDirection()) == 1){//两车相遇了
                if(a.getDirection() + b.getDirection() == 0) {//相向而行，就会碰撞
                    if (a.getPower() != 0 && b.getPower() != 0) {//ab校车都没有静止
                        a.setDirection(0 - a.getDirection());
                        b.setDirection(0 - a.getDirection());
                        a.locate += a.direction;
                        a.power--;
                        b.locate += b.direction;
                        b.power--;
                    }else if(a.getPower() == 0 && a.getPower() != 0){//a车静止了，b车撞a
                        a.direction = b.direction;
                        b.power -= 2;
                        a.locate += a.direction;
                        b.locate += a.direction;
                    }else if(a.getPower() != 0 && a.getPower() == 0){//b车静止了，a车撞b

                    }else//ab都静止就跳出
                        break;
                }
            }else if(a.power != 0){//同一时刻，只让一辆有power的车运行。
                a.power--;
                a.locate += a.direction;
            }else if(b.power != 0){
                b.power--;
                b.locate += a.direction;
            }

        }
        int count = 0;
        if(a.locate <= 0 || a.locate > len-1)
            count++;
        if(b.locate <= 0 || b.locate > len-1)
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

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public int getLocate() {
            return locate;
        }

        public void setLocate(int locate) {
            this.locate = locate;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }
    }

}

