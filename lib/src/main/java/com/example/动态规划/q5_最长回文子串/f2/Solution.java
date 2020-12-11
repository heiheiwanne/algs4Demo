package com.example.动态规划.q5_最长回文子串.f2;

/**
 * 动态规划 o(n^2)
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 转移方程：字符串两边界值相等并且子字符串是回文字符串则该字符串是回文字符串
 * dp数组含义：字符串s从i到j的索引子字符串是否是回文字符串
 */
public class Solution {
    /* public String longestPalindrome(String s) {
         int len = s.length();

         if (len < 2) {
             return s;
         }
         boolean[][] dp = new boolean[len][len];
         for (int i = 0; i < len; i++) {
             dp[i][i] = true;
         }

         int maxLen = 1;
         int start = 0;

         for (int j = 1; j < len; j++) {
             for (int i = 0; i < j; i++) {
                 if (s.charAt(i) == s.charAt(j)) {
                     if (j - i < 3) {
                         dp[i][j] = true;
                     } else {
                         dp[i][j] = dp[i + 1][j - 1];
                     }
                 } else {
                     dp[i][j] = false;
                 }

                 if (dp[i][j]) {
                     int curLen = j - i + 1;
                     if (curLen > maxLen) {
                         maxLen = curLen;
                         start = i;
                     }
                 }

             }
         }
         return s.substring(start, start + maxLen);
     }*/

    /**
     * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

}
