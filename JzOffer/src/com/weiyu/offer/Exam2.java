package com.weiyu.offer;

import java.util.Scanner;

public class Exam2 {
    final static String table="FGRSTLMNOPQWXYZUAGHIJKBCDElmnopijkfghabcdeqrwxyzstuz";
	public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        while(in.hasNext()){  
        	String str=in.nextLine();        	
        	if((str.indexOf('.')<0)&&(str.indexOf('-')<0)){
        		System.out.println("");
        	}
        	else{
	        	str=str.replace('#', ' ');
	        	str=str.replace('.', '1');
	        	str=str.replace('-', '0');
	        	String[] strArray=str.split("\\s+");
	        	for(int i=0;i<strArray.length;i++){
	        		String tmp=converter(strArray[i]);
	        		if(tmp.equals("ERROR")){
	        			sb.setLength(0);
	        			sb.append(tmp);
	        			break;
	        		}
	        		sb.append(tmp);
	        	}
	        	System.out.println((sb.equals("ERROR")?"ERROR":sb));
        	}
        }
        in.close();
	}
	
	public static String converter(String str){
		//二进制转换为整数
		int num=Integer.valueOf(str,2);
		return (num>=0&&num<=51)?Character.toString(table.charAt(num)):"ERROR";
	}
}