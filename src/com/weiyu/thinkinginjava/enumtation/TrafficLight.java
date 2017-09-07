package com.weiyu.thinkinginjava.enumtation;

/**
 * Created by Wei Yu on 2017/9/4.
 */
public class TrafficLight {
    enum Signal{
        GREEN, RED, YELLOW
    }
    Signal color = Signal.RED;

    public void change(){
        switch (color){
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        for(int i = 0;i < 6;i++){
            System.out.println(light);
            light.change();
        }
    }

}
