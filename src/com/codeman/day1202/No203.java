package com.codeman.day1202;

/**
 * 移除链表元素
 */
public class No203 {
    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        for (int i = 0; i <= 10; i ++) {
            ListNode insertNode = new ListNode((int) (Math.random() * 9));
            insertNode.next = node.next;
            node.next = insertNode;
        }
        printNode(node);
        removeElements(node, 5);
        printNode(node);
    }

    private static ListNode removeElements(ListNode node, int val) {
        ListNode temp = node;
        // 先不考虑链表第一个元素
        while (temp.next != null) {
            if (temp.next.val == val) { // 下一个元素需要删除
                temp.next = temp.next.next;
            }
            // 指针移动前需要判断下一个元素是否为val
            if (temp.next != null && temp.next.val != val) {
                temp = temp.next; // 指针后移
            }
        }
        // 判断最后一个元素
        if (temp.val == val) {
            temp = null;
        }
        // 再判断是否删除第一个元素
        if (node.val ==  val) {
            node = node.next;
        }
        return node;
    }

    private static void printNode(ListNode node) {
        ListNode temp = node;
        System.out.printf("%s, ", node.val);
        while (temp.next != null) {
            System.out.printf("%s, ", temp.next.val);
            temp = temp.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
