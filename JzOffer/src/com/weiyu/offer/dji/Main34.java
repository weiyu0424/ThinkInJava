package com.weiyu.offer.dji;

import java.util.Scanner;
public class Main34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int len = in.nextInt();
            int aPower = in.nextInt();
            int aLocation = in.nextInt();
            int aDirection = in.nextInt();

            int bPower = in.nextInt();
            int bLocation = in.nextInt();
            int bDirection = in.nextInt();

            int count = 0;
            if(aDirection + bDirection == 0){
                if(bPower + bLocation > len - 1 || bLocation - bPower < 0){
                    count++;
                }
                if(aPower + aLocation > len - 1 || aLocation - aPower < 0){
                    count++;
                }
            }else{
                if(aDirection == 1 && bDirection == -1 ){
                    while(bLocation - aLocation > 2){
                        aPower--;
                        bPower--;
                        aLocation++;
                        bLocation--;
                        if(aPower == 0 || bPower == 0){
                            break;
                        }
                    }

                    if(bPower != 0 && aPower == 0){
                        while(bLocation - aLocation > 1){
                            bPower--;
                            bLocation--;
                            if(bPower == 0){
                                break;
                            }
                        }
                        if(bPower == 0){
                            break;
                        }
                        while(bPower > 0){
                            if(bPower == 0){
                                break;
                            }
                            bPower -= 2;
                            bLocation--;
                            aLocation--;
                        }
                        if(bLocation < 0){
                            count++;
                        }
                        if(aLocation < 0){
                            count++;
                        }
                    }else if(bPower == 0 && aPower != 0){
                        while(bLocation - aLocation > 1){
                            aPower--;
                            aLocation++;
                            if(aPower == 0){
                                break;
                            }
                        }
                        if(aPower == 0){
                            break;
                        }
                        while(aPower > 0){
                            if(aPower == 0){
                                break;
                            }
                            aPower -= 2;
                            bLocation++;
                            aLocation++;
                        }
                        if(bLocation > len -1){
                            count++;
                        }
                        if(aLocation > len -1){
                            count++;
                        }
                    }else if(bPower != 0 && aPower != 0){
                        if(bPower + bLocation >= len){
                            count++;
                        }
                        if(aLocation - aPower < 0){
                            count++;
                        }
                    }

                }
            }
            System.out.println(count);
        }

        in.close();
    }

}

