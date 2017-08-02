package com.weiyu.offer;

import java.util.*;

/**
 * Created by Wei Yu on 2017/7/6.
 */
public class DFSTest {
    private List<String> collections = new ArrayList<>();
    //private int[] status = new int[];
    public boolean dfs(int[][] matrix){
        int[] status = new int[matrix.length];
        for(int i = 0;i < matrix.length;i++){
            if(status[i] == 0){
                boolean result =  dfsVisited(matrix,i,status);
                if(false == result)
                    return false;
            }
        }
        return true;
    }

    public boolean dfsVisited(int[][] matrix,int index,int[] status){
        status[index] = 1;
        for(int j = 0;j < matrix[index].length;j++){
            if(1 == matrix[index][j]){
                if(status[j] == 0){
                    boolean flag = dfsVisited(matrix,j,status);
                    if(false == flag)
                        return false;
                }else if(1 == status[j]){
//                    collections.add();
                    return false;
                }
            }
        }
        status[index] = 2;
        return true;
    }

    public static void main(String... args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        int LENGTH = 5;
        int[][] matrix = new int[LENGTH][LENGTH];
        String[] lines = new String[num];
        /*for(int i = 0;i < matrix.length;i++)
            for(int j = 0;j < matrix[0].length;j++)
                matrix[i][j] = 0;*/
        Map<String,Integer> map = new HashMap<>();
        int index = 0;
        for(int i = 0;i < num;i++){
            lines[i] = in.nextLine();
            String[] strs = lines[i].split(" ");
            if(!map.containsKey(strs[0])){
                map.put(strs[0],index++);
            }

            if(!map.containsKey(strs[1])){
                map.put(strs[1],index++);
            }
            int m = map.get(strs[0]);
            int n = map.get(strs[1]);
            System.out.println(m + ":" + n);
            matrix[map.get(strs[0])][map.get(strs[1])] = 1;
        }

        boolean result = new DFSTest().dfs(matrix);
        System.out.println(result);
    }
}
