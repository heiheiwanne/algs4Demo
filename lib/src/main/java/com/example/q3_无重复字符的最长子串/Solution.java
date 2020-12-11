package com.example.q3_无重复字符的最长子串;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * Hash+双指针滑动窗口 o(n)
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            Integer index = map.get(s.charAt(right));
            map.put(s.charAt(right), right);
            if (index != null && index >= left) {
                left = index + 1; //找到左边的位置，因为与当前的有重复的，所以需要+1
            }
            if (right - left + 1 > len) {
                len = right - left + 1;
            }
            right++;
        }
        return len;
    }
}
