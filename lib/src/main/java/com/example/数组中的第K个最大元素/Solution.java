package com.example.数组中的第K个最大元素;

import java.util.PriorityQueue;

/**
 * @author xumingqiang@keepreal.group
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/10 8:29 AM
 */
public class Solution {
    /**
     *  堆排序：
     *  大顶堆：构建一个length长度的大堆，删除k-1个元素就是 第K大
     *  小顶堆：构建一个K长度的小堆，若大于堆顶插入，小于堆顶不插入，以下为小堆方式。
     */
    public int findKthLargest(int[] nums, int k) {
        //前K个元素原地建小顶堆
        buildHeap(nums, k);
        //遍历剩下元素，比堆顶小，跳过；比堆顶大，交换后重新堆化
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < nums[0]) continue;
            swap(nums, i, 0);
            heapify(nums, k, 0);
        }
        //K个元素的小顶堆的堆顶即是第K大元素
        return nums[0];
    }
    /**
     * 建堆函数
     * 从倒数第一个非叶子节点开始堆化，倒数第一个非叶子节点下标为 K/2-1
     */
    public void buildHeap(int[] a, int k) {
        for (int i = k/2 - 1; i >= 0; i--) {
            heapify(a, k, i);
        }
    }
    /**
     * 堆化函数
     * 父节点下标i，左右子节点的下标分别为 2*i+1 和 2*i+2
     */
    public void heapify(int[] a, int k, int i) {
        //临时变量 minPos 用于存储最小值的下标，先假设父节点最小
        int minPos = i;
        while (true) {
            //和左子节点比较
            if (i*2+1 < k && a[i*2+1] < a[i]) minPos = i*2+1;
            //和右子节点比较
            if (i*2+2 < k && a[i*2+2] < a[minPos]) minPos = i*2+2;
            //如果minPos没有发生变化，说明父节点已经是最小了，直接跳出
            if (minPos == i) break;
            //否则交换
            swap(a, i, minPos);
            //父节点下标进行更新，继续堆化
            i = minPos;
        }
    }
    public void swap(int[] a, int n, int m) {
        int tmp = a[n];
        a[n] = a[m];
        a[m] = tmp;
    }



    //使用java现有api

    //通过优先队列构建最小堆
    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len); //构造有len个元素的小顶堆
        for(int num: nums){ //把 len 个元素都放入一个最小堆中
            minHeap.offer(num);
        }
        for(int i=0;i<len-k;i++){ //然后再 poll() 出 len - k 个元素
            minHeap.poll();
        }
        return minHeap.peek(); //此时最小堆只剩下 k 个元素，堆顶元素就是数组中的第 k 个最大元素
    }


}
