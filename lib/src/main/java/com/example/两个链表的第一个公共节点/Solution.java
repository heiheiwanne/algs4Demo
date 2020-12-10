package com.example.两个链表的第一个公共节点;

import com.example.q19_删除链表的倒数第N个节点.ListNode;

/**
 * @author xumingqiang@keepreal.group
 * 输入两个链表，找出它们的第一个公共节点。
 * @date 2020/12/10 9:33 AM
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //tempA和tempB我们可以认为是A,B两个指针
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            //如果指针tempA不为空，tempA就往后移一步。
            //如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
            tempA = tempA == null ? headB : tempA.next;
            //指针tempB同上
            tempB = tempB == null ? headA : tempB.next;
        }
        //tempA要么是空，要么是两链表的交点
        return tempA;
    }


}
