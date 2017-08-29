package com.weiyu.offer.offer.pingduoduo.second;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xpZhu on 2017/8/17.
 */
public class P1 {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1,1,1}, {0,1,1,1,1,1}, {0,0,0,0,1,1}, {0,1,1,1,1,1}};
        List<String> list = getMostOne(matrix);
        for(String item : list){
            System.out.print(item + " ");
        }
    }

    public static List<String> getMostOne(int[][] matrix){
        List<String> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j = cols - 1;
        int count = 0;
        while(i <= rows - 1 && j >=0){
            if(matrix[i][j] == 1){
                j--;
                count++;
            }else{
                i++;
            }
        }
        if(0 == count){
            return list;
        }
        for(int k = 0;k < rows;k++){
            if(1 == matrix[k][j + 1]){
                list.add("[" + (k + 1) + "," + count + "]");
            }
        }
        return list;
    }
}
