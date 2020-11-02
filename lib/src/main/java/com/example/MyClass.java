package com.example;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by xmq on 2017/10/12.
 */

public class MyClass {
   public static void main(String[] args ) {
//       StdOut.print(1.0 /0.0);
//       double d  = 2.0e-6;
//       StdOut.print( d* 100000000.1);
//       StdOut.print(true && false || true && true);
//       StdOut.print(1+2+"3");
       int[] in = new int[]{10,1};
       System.out.println(largestNumber(in));
   }

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String numStrList[] = new String[nums.length];
        for (int i = 0; i < numStrList.length; i++) {
            numStrList[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };
        Arrays.sort(numStrList, comparator);
        String s = "";
        for (String string : numStrList) {
            s += string;
        }
        if (s.charAt(0) == '0') {
            return "0";
        }
        return s;
    }
}
