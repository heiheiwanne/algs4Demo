package com.example;

/**
 * Created by xmq on 2017/10/16.
 * 参考链接：http://www.cnblogs.com/chengxiao/p/6194356.html
 * 归并排序：
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，
 * 该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，
 * 而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 */

public class MergeSort {
    private static int A[] = {999, 69, 1001, 4, 2009, 2, 30005, 4, 0, 867, 45, 7888, 23, 1, 234, 56, 78, 34, 3, 44, 555, 666, 777, 9, 888, 8, 111, 1111, 22, 222, 2222, 22222, 33, 333, 3333, 33333, 44, 444, 4444, 44444, 444444, 55, 5555, 55555, 66, 6666, 66666, 666666, 77, 7777, 77777, 777777, 8888, 88888, 888888};

    public static void main(String[] args) {

        sort(A,0,A.length-1,new int[A.length]);
        show(A);
        isSorted(A);
    }


    public static void sort(int[] array , int left ,int right ,int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array,left,mid,temp);
            sort(array,mid+1,right,temp);
            merge(array,left,mid,right,temp);
        }
    }
    /**
     * 合并
     *
     * @param array 要排序的单元arry
     * @param left  左序列的起指针
     * @param mid   数组的中间指针
     * @param right 数组的最高元素的指针
     * @param temp  创建的临时数组，防止临时开辟很多数组，所以传入
     */
    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left; //左序列最低指针
        int j = mid + 1;//右序列最低指针
        int t = 0; // 临时指针

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = array[i++];
        }

        while (j <= right) {
            temp[t++] = array[j++];
        }

        t = 0;
        //使用判断条件取出相对应的数据进行赋值，这里的temp是所有的合并分支共用一个数组
        while (left <= right) {
            array[left++] = temp[t++];
        }
    }


    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + ":  " + a[i] + "   ");
        }
        System.out.println();
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < (a[i - 1])) {
                System.out.println(false);
                return false;
            }
        }
        System.out.println(true);
        return true;
    }

}
