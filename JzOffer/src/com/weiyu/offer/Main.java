package com.weiyu.offer;

import java.util.*;
public class Main {
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Map<String,List<String> > map = new HashMap<>();
		while(in.hasNext()){
			int n=Integer.parseInt(in.nextLine() );
			for(int i = 0;i < n;i++){
				String[] functionNames = in.nextLine().split(" ");
				if(map.containsKey(functionNames[0])){
					List<String> list = map.get(functionNames[0]);
					list.add(functionNames[1]);
				}
				else{
					List<String> list = new ArrayList<String>();
					list.add(functionNames[1]);
					map.put(functionNames[0], list);
				}
			}
			
			String[] target = in.nextLine().split("\\ +");
			String start = target[0];
			String end = target[1];
			if(dfs(map,start,end))
				System.out.println("T");
			else
				System.out.println("F");
		}
		in.close();
	}

	public static boolean dfs(Map<String,List<String> > map,String start,String end){
		if(start.equals(end)){
			List<String> list = map.get(start);
			for(String str : list){
				if(str.equals(start)){
					return true;
				}
			}
			return false;
		}
		Stack<String> s = new Stack<>();
		Set<String> set = new HashSet<>();
		s.push(start);
		
		boolean b = false;
		while(!s.isEmpty()){
			String name = s.peek();
			List<String> list = map.get(name);
			if(list == null || list.size() == 0){
				s.pop();
				continue;
			}
			boolean flag=true;
			for(String str : list){
				if(!set.contains(str)){
					if(str.equals(end)){
						 b = true;
						 break;
					}	
					s.push(str);
					set.add(str);
					flag=false;
				}
			}
			if(flag == true)
				s.pop();
		}
		if(b == false)
			return false;
		set.clear();s.clear();
		s.push(end);
		boolean f=false;
		while(!s.isEmpty()){
			String name=s.peek();
			List<String> list=map.get(name);
			if(list == null || list.size()==0){
				s.pop();
				continue;
			}
			boolean flag=true;
			for(String str : list){
				if(!set.contains(str)){
					if(str.equals(start)){
						 f=true;
						 break;
					}	
					s.push(str);
					set.add(str);
					flag=false;
				}
				
			}
			if(flag==true)
				s.pop();
		}
		return f;
	}

}
