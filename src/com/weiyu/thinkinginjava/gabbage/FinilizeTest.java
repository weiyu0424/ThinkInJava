package com.weiyu.thinkinginjava.gabbage;

/**
 * Created by weiyu on 2017/3/24.
 */

class Book{
    private boolean isCheckout;

    public void checkIn(){
        isCheckout = false;
    }

    public Book(boolean checkout){
        this.isCheckout = checkout;
    }

    @Override
    protected void finalize() throws Throwable {
//            super.finalize();
        if(isCheckout){
            System.out.println("Error,checkedout");
        }
    }
}

public class FinilizeTest {
    public static void main(String... args){
        Book novel = new Book(true);
        novel.checkIn();

       // new Book(true);

        System.gc();
    }
}
