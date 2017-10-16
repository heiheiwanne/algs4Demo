package com.example;

/**
 * Created by xmq on 2017/10/16.
 * 参考链接：http://developer.51cto.com/art/201403/430986.htm
 * 快速排序：
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 */

public class QuickSort {
    private static int A[] = {999, 69, 1001, 4, 2009, 2, 30005, 4, 0, 867, 45, 7888, 23, 1, 234, 56, 78, 34, 3, 44, 555, 666, 777, 9, 888, 8, 111, 1111, 22, 222, 2222, 22222, 33, 333, 3333, 33333, 44, 444, 4444, 44444, 444444, 55, 5555, 55555, 66, 6666, 66666, 666666, 77, 7777, 77777, 777777, 8888, 88888, 888888};

    public static void main(String[] args) {
        sort(A, 0, A.length-1);
        show(A);
        isSorted(A);
    }


    private static void sort(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int j = partition(array, left, right);
        sort(array, left, j - 1);
        sort(array, j + 1, right);
    }

    /**
     * 选择分组，并定位中间坐标
     * @param array 临时数组
     * @param left 数组左边界
     * @param right 数组右边界
     * @return 中间分组点
     */
    private static int partition(int[] array, int left, int right) {
        int i = left;       //左指针
        int j = right +1;  //右指针，这里不要忘记+1 ，因为最后一个也要进行比较，下边是--j
        int temp = array[i];//切分元素

        while (true) {
            while (array[++i] < temp) if (i == right) break; //循环找比切分元素大的坐标，if语句是冗余的

            while (temp < array[--j]) if ( j == left) break; //循环找到比切分元素小的坐标 条件j==left 是冗余的，

            if (i >= j) break; //若两头的坐标点相遇说明循环完毕，不进行

            exch(array, i, j);
        }
        exch(array, left, j);
        return j;
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

    private static void exch(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
