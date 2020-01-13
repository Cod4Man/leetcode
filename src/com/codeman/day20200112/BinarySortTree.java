package com.codeman.day20200112;

/**
 * BST ： 二叉排序树
 */
public class BinarySortTree {
    private Node root;

    /**
     * 增加元素
     * @param node
     */
    public void addTreeNode(Node node) {
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.addNode(node);
        }
    }

    public void midOrder() {
        if (this.root == null) {
            System.out.println("空树！");
            return;
        }
        this.root.midOrder();
    }

}


class Node {
    private int no;
    private Node left;
    private Node right;

    public Node(int no) {
        this.no = no;
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    /**
     * 增加节点
     * @param node
     */
    public void addNode(Node node) {
        if (node == null) {
            return;
        }
        if (node.no >= this.no) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        } else {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
