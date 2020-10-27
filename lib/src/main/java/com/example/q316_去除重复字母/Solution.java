package com.example.q316_去除重复字母;

import java.util.Stack;

/**
 * 栈操作 o(n*log(n))
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 * 首先要知道什么叫 “字典序”。字符串之间比较跟数字之间比较是不太一样的。
 * 字符串比较是从头往后一个字符一个字符比较的。哪个字符串大取决于两个字符串中 第一个对应不相等的字符 。
 * 根据这个规则，任意一个以 a 开头的字符串都大于任意一个以 b 开头的字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            //若栈中已经有当前元素，则直接去除当前元素
            if (stack.contains(c)) {
                continue;
            }
            //若当前的栈顶元素比当前的元素字典序大，且当前元素的位置后面还有栈顶元素,
            //将栈顶元素出栈, 将当前元素入栈, 这样来找到最优的排列
            //判断栈顶元素大于当前元素且在字符串中有此元素
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        String rs = "";
        for (int i = 0; i < stack.size(); i++) {
            rs += stack.get(i);
        }
        return rs;
    }
}
