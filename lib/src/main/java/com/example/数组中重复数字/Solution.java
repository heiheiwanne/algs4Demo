package com.example.数组中重复数字;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xumingqiang@keepreal.group
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/7 11:26 PM
 */
class Solution {
    /**
     * 方法一：时间复杂度o(n),空间复杂度o(n)
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }


    /**
     * 原地置换:
     * 如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，所以思路是重头扫描数组，
     * 遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换。
     * 在交换过程中，如果有重复的数字发生，那么终止返回ture
     *
     *
     * 一个萝卜一个坑的想法,
     * 因为题目里说明确说了要么不满足条件,要么是 range(0,n)的数组
     * 依次给每个萝卜放回自己的坑
     * 如果这个萝卜的坑被占了就说明重复了就返回
     *
     */
    public int findRepeatNumber2(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }

}
