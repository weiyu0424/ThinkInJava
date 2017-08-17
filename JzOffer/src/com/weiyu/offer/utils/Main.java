package com.weiyu.offer.utils;

import java.util.*;

public class Main{
    public static void minStep(int[] x,int [] y,int n){
		int[] result=new int[n];
		result[0]=0;
		for(int i=1;i<n;i++){
			result[i]=Integer.MAX_VALUE;
		}
		//System.out.println(Arrays.toString(result));
		int[][] array=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i!=j){
					array[i][j]=Math.abs(x[j]-x[i])+Math.abs(y[j]-y[i]);
				}
			}
			Arrays.sort(array[i]);
			//System.out.println(Arrays.toString(array[i]));
		}
		for(int i=0;i<n;i++){
			for(int j=1;j<n;j++){
				int sum=Sum(array[i], 1, j);
				if(result[j]>sum)
					result[j]=sum;					
			}
		}
		for(int i=0;i<n-1;i++){
			System.out.print(result[i]+" ");
		}
		System.out.println(result[n-1]);
	}
	private static int Sum(int[] a,int start,int end){
		int sum=0;
		for(int i=start;i<=end;i++)
			sum+=a[i];
		return sum;
	}
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in 

);
		while(scan.hasNext()){
			int n=Integer.parseInt(scan.nextLine());
			String[] xStrings=scan.nextLine().split(" ");
			String[] yStrings=scan.nextLine().split(" ");
			int[] x=new int[n];
			int[] y=new int[n];
			for(int i=0;i<n;i++){
				x[i]=Integer.parseInt(xStrings[i]);
				y[i]=Integer.parseInt(yStrings[i]);
			}
			minStep(x,y,n);
		}
		scan.close();
		
		
	}
}