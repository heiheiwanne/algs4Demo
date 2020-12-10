package com.example.数组中的第K个最大元素;

import java.util.Random;

/**
 * @author xumingqiang@keepreal.group
 * 快速排序
 * @date 2020/12/10 9:12 AM
 */
public class SolutionQuick {
    //基于快速排序的选择方法
    Random random = new Random();
    int quickSort(int[] nums,int low, int high,int target){
        // index为寻找基准元素的正确索引
        int index = getRandomIndex(nums,low,high);
        if(index == target)  return nums[index];
        else{
            return index < target? quickSort(nums,index+1,high,target):quickSort(nums,low,index-1,target);
        }
    }
    int getRandomIndex(int[] nums, int low, int high){
        int r = random.nextInt(high - low + 1) + low; //random.nextInt(n)返回介于(0,n]的随机数
        swap(nums,low,r); //将随机获取的那个值与low值交换～
        return getIndex(nums,low,high);
    }
    int getIndex(int[] nums, int low, int high){
        //基准数据
        int temp = nums[low];
        while(low < high){
            //当队尾的元素大于等于基准元素时，向前挪动指针
            while(low<high && nums[high]>=temp) high--;
            //若队尾元素小于基准元素了，将其值赋值给low位置的值
            nums[low] = nums[high];
            //当队头的元素小于等于基准元素时，向后挪动指针
            while(low<high && nums[low]<=temp) low++;
            //若队头元素大于基准元素了，将其值赋值给high位置的值
            nums[high] = nums[low];
        }
        //跳出循环时low==high 此时low位置就是temp元素的正确位置啦
        nums[low] = temp;
        return low; //返回这个排序好元素的正确位置
    }
    void swap(int[] nums,int i,int j){ //交换i和j对应位置的值
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length-k;
        return quickSort(nums,0,nums.length-1,target);
    }

}
