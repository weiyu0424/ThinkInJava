package com.weiyu.thinkinginjava.enumtation;

/**
 * Created by Wei Yu on 2017/9/4.
 */
public enum OzWitch implements Base{
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Miss Gulch, aka the Wicked Witch of the North"),
    SOUTH("Miss Sam, aka the Wicked Witch of the South"),
    EAST("Miss Tina, aka the Wicked Witch of the East");

    private String description;
    OzWitch(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name() + ": " + description;
    }

    public static void main(String[] args) {
        for(OzWitch witch : OzWitch.values()){
//            System.out.println(witch + ": " + witch.getDescription());
            System.out.println(witch);
        }
    }
}
