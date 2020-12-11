package com.example.q258_各位相加;

/**
 * 找规律 o(1) xyz=100*x+10*y+z=99*x+9*y+x+y+z
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(addDigits1(12434343));
    }

    public int addDigits(int num) {
        if (num % 9 == 0 && num != 0) {
            num = 9;
        } else {
            num %= 9;
        }
        return num;
    }

    public static int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }
}
