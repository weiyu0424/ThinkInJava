package com.weiyu.offer.didi;

/**look for the max sum of sub sequence
 * @author acer
 *
 */
public class MAxSumSubSeq {

    
    public static void main(String[] args) {
        int[] a = {-12, -11, -4, -13, -5, -32};
        getMaxSumSeq(a);
    }
    private static void getMaxSumSeq(int[] nums){
        int rmax = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        int temp = -1;
        for(int i = 0 ;i < nums.length;i++){
            if(sum > 0){
                sum += nums[i];
            }else{
                sum = nums[i];
                temp = i;
            }
            if(sum > rmax){
                start = temp;
                rmax = sum;
                end = i;
            }
        }
        for(int j = start;j <= end;j++){
            System.out.print(nums[j]+" ");
        }        
    }
}
