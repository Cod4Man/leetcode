package com.codeman.day20200111;

/**
 * 树节点
 */
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {

        private int times;
        private Character letter;
        private HuffmanTreeNode leftNode;
        private HuffmanTreeNode rightNode;

        public HuffmanTreeNode(int times, Character letter) {
            this.times = times;
            this.letter = letter;
        }

        /**
         * 前序遍历二叉树 ： 中-左-右
         */
        public void preOrder() {
            System.out.println(this);
            if (this.leftNode != null) {
                this.leftNode.preOrder();
            }
            if (this.rightNode != null) {
                this.rightNode.preOrder();
            }
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "times=" + times +
                    ", letter=" + letter +
                    '}';
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }

        public Character getLetter() {
            return letter;
        }

        public void setLetter(Character letter) {
            this.letter = letter;
        }

        public HuffmanTreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(HuffmanTreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public HuffmanTreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(HuffmanTreeNode rightNode) {
            this.rightNode = rightNode;
        }

    @Override
    public int compareTo(HuffmanTreeNode o) {
        return this.times - o.times;
    }
}