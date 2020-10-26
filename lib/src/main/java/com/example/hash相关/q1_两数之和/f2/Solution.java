package com.example.hash相关.q1_两数之和.f2;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用hashmap解决两个数之和相加问题
 * 一遍hash o(n)
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
