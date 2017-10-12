package com.example;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by xmq on 2017/10/12.
 * 二分法查找算法
 * 注意点： 1. 数组要首先有序
 *         2. 整数相除不是四舍五入，直接去掉多余的小数部分，所以  low = mid+1   ; high =  mid-1
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {3, 5, 6, 7, 8, 10, 11, 13, 14, 15};     // 此数组是有序数组
        StdOut.print(rank(3,numbers));
    }

    public static int rank(int target, int[] array){
        int low = 0;
        int high = array.length -1;

        for (int i = 0; i < array.length; i++) {
            int mid = low + ( high -low )/2; //整数除法 小数点直接删除（存储结构决定）   3／2 =1
            if (target > array[mid]) {
                low = mid +1;
            } else if (target < array[mid]) {
                high = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
