package com.weiyu.offer.test;

import java.util.Scanner;

public class PerThread extends Thread {

	private static int[] chopstick;
    private int i;
	public PerThread(int i) {
		this.i = i;
	}
	@Override
	public void run() {
		synchronized (chopstick) {  //若注释此行，打开下行，不同步，5个per只拿到左筷子
			eat();
			think();
		}
	}

	private void think() {
		chopstick[i] = 1;
		chopstick[(i + 1) % chopstick.length] = 1;
		System.out.println("哲学家-" + (i+1) + " : 在思考");
	}

	private void eat() {
			try {
				Thread.sleep(1000 + (int)(Math.random() * 2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("哲学家-" + (i+1) + " : 在吃饭");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		chopstick = new int[count];
		for(int i = 0;i < count;i++){
			chopstick[i] = 1;
		}
		for (int i = 0; i < count; i++) {
			Thread t = new PerThread(i);
			t.start();
		}
	}
}
