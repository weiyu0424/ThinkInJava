package com.weiyu.thinkinginjava.enumtation;

/**
 * Created by Wei Yu on 2017/9/4.
 */
public class EnumClass {
    enum Shrubbery{
        GROUND,GRAWLING,HANGLING
    }
    public static void main(String[] args) {
        for(Shrubbery s : Shrubbery.values()){
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.println(s.compareTo(Shrubbery.GRAWLING) + " ");
            System.out.println(s.equals(Shrubbery.GRAWLING) + " ");
            System.out.println(s == Shrubbery.GRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("===========================");
        }

        for(String s : "HANGLING GRAWLING GROUND".split("\\s")){
            Shrubbery shrub = Enum.valueOf(Shrubbery.class,s);
            System.out.println(shrub);
        }
    }
}
