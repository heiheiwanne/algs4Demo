package com.example.第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xumingqiang@keepreal.group
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/10 9:24 AM
 */
public class Solution {
    public char firstUniqChar(String s) {
        if (s == null || s.length() <= 0) {
            return ' ';
        }

        int length = s.length();

        /*
            先记录 每个出现的字符 和其 出现次数
         */
        int[] letters = new int[26];
        char curChar;
        for (int i = 0; i < length; i++) {
            curChar = s.charAt(i);
            letters[curChar - 'a']++;
        }

        /*
            再次按顺序遍历 字符串，找到只出现一次的字符并返回
         */
        for (int i = 0; i < length; i++) {
            curChar = s.charAt(i);
            if (letters[curChar - 'a'] == 1) {
                return curChar;
            }
        }
        return ' ';
    }


    /**
     * 方法二
     */

    public char firstUniqChar1(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }




}
