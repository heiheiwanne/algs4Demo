package com.example;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by xmq on 2017/10/13.
 * 简单基础排序 ：选择，插入 ，希尔
 * 此排序是以升序为目的
 */

public class SortAlgs {

    private static int A[] = {999, 69, 1001, 4, 2009, 2, 30005, 4, 0, 867, 45, 7888, 23, 1, 234, 56, 78, 34, 3, 44, 555, 666, 777, 9, 888, 8,111,1111,22,222,2222,22222,33,333,3333,33333,44,444,4444,44444,444444,55,5555,55555,66,6666,66666,666666,77,7777,77777,777777,8888,88888,888888};
    private static int B[] = {97, 6, 5, 10, 4, 3, 2};

    public static void main(String[] args) {
        int[] C = A;
        long start = System.currentTimeMillis();
//        sortOfselect(C);
//        sortOfInsert(C);
//        sortOfShell(C);
        sortOfBubble(C);
//        sortOfShell2(C);
        long  dif= (System.currentTimeMillis() - start);
        System.out.println("耗时: "+String.valueOf(dif));
        show(C);
        StdOut.print(isSorted(C));
    }

    /**
     * 希尔排序，将整个数组按递增序列分组，然后由大于3／length 处开始循环分组进行插入排序
     * 此递增序列为  h = h*3 +1;==> 1,4,13,40,121,364,1093....
     * @param array
     */
    public static void sortOfShell(int[] array) {
        int length = array.length;
        int h = 1;
        while (h<(length/3)) {
            h = h*3 +1;
        } //初始化h

        for (;h>0;h/=3) {
            //h 为递增序列
            //下边为插入排序 ，从h处开始循环分组往后（j-h）插入排序
            for (int i = h; i < length; i++) {
                for (int j = i; j >=h; j-=h) { //最小为h
                    if (array[j] < array[j-h]) {
                        exch(array,j, j-h);
                    }
                }
            }
        }
    }

    /**
     * 希尔排序
     * 递增序列为2N
     * @param data
     */
    public static void sortOfShell2(int[] data) {
        int h = data.length / 2;

        for (; h > 0; h /= 2) {
            for (int i = h; i < data.length; i++) {
                for (int j = i ; j >= h; j -= h) {
                    if (data[j] < data[j-h]) {
                        exch(data,j ,j-h);
                    }
                }
            }
        }
    }



    /**
     * 插入排序
     * 类似摸牌，从头开始摸牌，然后将摸到的牌进行排序，当然此时的左侧的数组总是有序的
     * 这种排序对于部分有序的数组是很高效的
     *
     * @param array
     */
    public static void sortOfInsert(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    exch(array,j,j-1);
                }
            }
        }
    }


    /**
     * 选择排序算法:  从数组里面找到最小的／最大的，与最头上的进行交换，依次循环
     *
     * @param a
     */
    public static void sortOfselect(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) { //在剩余数组中循环找到最小的元素坐标并记录
                if (a[j] < a[min]) min = j;
            }

            exch(a, i,min);//数据交换
        }
    }

    /**
     * 冒泡排序
     * 从头开始进行循环比对，顺序相反的对调。第一次循环将最大的放到末尾，第二次倒数第二个为最大，依次类推
     * @param a
     */
    public static void sortOfBubble(int[] a) {
        for (int length = a.length; length > 0; length--) {
            for (int j = 1; j < length; j++) {
                if (a[j] < a[j-1]) {
                    exch(a,j, j-1);
                }
            }
        }

    }


    private static void exch(int[] array ,int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
                return false;
            }
        }
        return true;
    }
}
