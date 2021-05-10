package com.codeman.before210510.day20200112;

/**
 * 二叉排序树测试类
 */
public class BinarySortTreeTest {
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.addTreeNode(new Node(3));
        binarySortTree.addTreeNode(new Node(7));
        binarySortTree.addTreeNode(new Node(1));
        binarySortTree.addTreeNode(new Node(5));
        binarySortTree.addTreeNode(new Node(2));
        binarySortTree.addTreeNode(new Node(0));
        binarySortTree.midOrder();
    }
}
