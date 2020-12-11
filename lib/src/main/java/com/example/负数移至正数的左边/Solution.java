package com.example.负数移至正数的左边;

import java.util.Arrays;

/**
 * @author xumingqiang@keepreal.group
 * 有一个整形数组，包含正数和负数，然后要求把数组内的所有负数移至正数的左边，且保证相对位置不变，
 * 要求时间复杂度为O(n), 空间复杂度为O(1)。例如，{10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35}变化后是{-2, -4，-3, -88, -23,5, 8 ,10, 2, 7, 12, 35}。
 * @date 2020/12/11 3:41 AM
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] arr =  {8, 6, 4, -3, 5, -2, -1, 0, 1, -9, 1, -1};
        int left = 0; //定义指针，从左侧开始
        int right = arr.length-1; // 定义指针，从右侧开始
        while(left<right) {		//当左指针小于右指针时
            if(arr[left]<0 && arr[right]>=0) {//如果左边为负，右边为正，则交换值
                arr[left] = arr[left]+arr[right];
                arr[right] = arr[left]-arr[right];
                arr[left] = arr[left]-arr[right];
            }
            if(arr[left]>=0) { //如果左数为正，则切换成下一个左数
                left++;
            }
            if(arr[right]<0) { //如果右数为负，则切换成下一个右数
                right--;
            }
        }
        System.out.println(Arrays.asList(arr));
    }
}
