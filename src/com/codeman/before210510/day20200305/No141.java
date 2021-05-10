package com.codeman.before210510.day20200305;

/**
 * @author: zhanghongjie
 * @description: 判断链表中是否有环:慢快指针，因为对象的地址是唯一的
 * @date: 2020/3/5 22:39
 * @version: 1.0
 */
public class No141 {
    public static void main(String[] args) {
        ListNode node1 =  new ListNode(3);
        ListNode node2 =  new ListNode(2);
        ListNode node3 =  new ListNode(0);
        ListNode node4 =  new ListNode(-4);
        node4.next = node2;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        System.out.println(new No141().hasCycle(null));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode tempFst = head;
        ListNode tempSlow = head;

        // 慢追快
        while (tempSlow.next != null && tempFst.next != null && tempFst.next.next != null) {
            tempSlow = tempSlow.next;
            tempFst = tempFst.next.next;
            System.out.println("slow=>" + tempSlow.val + "><><>fast=>" + tempFst.val);
            if (tempSlow == tempFst) {
                return true;
            }
        }
        return false;
    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }