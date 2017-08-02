package com.weiyu.offer;

/**
 * Created by Wei Yu on 2017/6/23.
 */
public class BackTrackSearchTree {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int length = sequence.length;
        if(0 == length)
            return false;
        if(1 == length)
            return true;
        return search(sequence,0,length - 1);
    }

    public boolean search(int[] sequence, int start, int end){
        if(start >= end)
            return true;
        int item = sequence[end];
        int i = start;
        while(i <= end && sequence[i] < item){
            i++;
        }

        for(int j = i;j < end;j++){
            if(sequence[j] < item)
                return false;
        }

        return search(sequence,start,i - 1) && search(sequence,i,end - 1);
    }

    public static void main(String... args){
        int[] array = {4,8,6,12,16,14,10};
        boolean result = new BackTrackSearchTree().VerifySquenceOfBST(array);
        System.out.println(result);
    }
}
