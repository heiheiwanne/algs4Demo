package com.example.q54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * 方向变量模拟路径 o(n)
 * 四指针法
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int row = matrix.length;//二维矩阵的维数
        int col = matrix[0].length;
        int up = 0;//四指针(上、下、左、右)
        int down = row - 1;
        int left = 0;
        int right = col - 1;
        while (true) {
            for (int i = left; i <= right; i++) {//1. 先记录上横行
                result.add(matrix[up][i]);
            }
            up++;   //横行下移
            //边界判断
            if (up > down) {
                break;
            }
            //2. 记录右竖行
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            //3. 记录下横行
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            down--;
            if (up > down) {
                break;
            }
            //4. 记录左竖行
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
