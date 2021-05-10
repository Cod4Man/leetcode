package com.codeman.before210510.day20200111;

public class HuffmanTreeTest {
    public static void main(String[] args) {
        HuffmanTreeNode[] huffmanTreeNodes = {
                new HuffmanTreeNode(2, 'b'),
                new HuffmanTreeNode(3, 'c'),
                new HuffmanTreeNode(1, 'a'),
                new HuffmanTreeNode(4, 'e'),
                new HuffmanTreeNode(4, 'f'),
                new HuffmanTreeNode(5, 'g'),
                new HuffmanTreeNode(6, 'h'),
                new HuffmanTreeNode(4, 'd')
        };
        HuffmanTree huffmanTree = new HuffmanTree(huffmanTreeNodes);
    }
}
