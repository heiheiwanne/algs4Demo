package com.example.子数组最大和;

/**
 * @author xumingqiang@keepreal.group
 * @description TODO
 * @date 2020/12/4 3:56 AM
 */
//输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

public class Solution {
    public static void main(String []args) {
        int[] test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int a = maxSubArray(test);
        System.out.print(a);
    }

    public static Integer maxSubArray(int[] nums){
        int a = Integer.MIN_VALUE;
        if(nums == null || nums.length==0) return null;

        int sum = 0;

        for(int i=0;i<nums.length;i++){
            if(sum>0){
                sum+=nums[i];
            } else {
                sum = nums[i];
            }
            a = Math.max(a,sum);
        }

        return a;
    }
}