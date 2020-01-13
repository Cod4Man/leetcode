package com.codeman.day20200111;

import java.util.*;

/**
 * huffman树
 */
public class HuffmanTree {
    private HuffmanTreeNode root;
    private Map<Character, String> huffmanCode = new HashMap<>();

    public HuffmanTree(HuffmanTreeNode[] huffmanTreeNodes) {
        if (huffmanTreeNodes == null || huffmanTreeNodes.length == 0) {
            throw new RuntimeException("空树！");
        }

        createHuffmanTree(huffmanTreeNodes);
        createHuffmanCode(this.root, new StringBuffer());
        System.out.println(huffmanCode);
    }

    /**
     * 构造Huffman编码:前序遍历
     */
    private void createHuffmanCode(HuffmanTreeNode node, StringBuffer sb) {
        if (node.getLetter() != null) { // 说明是带参数的叶子节点，直接装入编码中
            huffmanCode.put(node.getLetter(), sb.toString());
        }

        // 左递归
        if (node.getLeftNode() != null) {
            StringBuffer tempSB = new StringBuffer(sb);
            tempSB.append("0");
            createHuffmanCode(node.getLeftNode(), tempSB);
        }
        // 右递归
        if (node.getRightNode() != null) {
            StringBuffer tempSB = new StringBuffer(sb);
            tempSB.append("1");
            createHuffmanCode(node.getRightNode(), tempSB);
        }
    }

    /**
     * 构造huffman树
     * @param huffmanTreeNodes
     */
    private void createHuffmanTree(HuffmanTreeNode[] huffmanTreeNodes) {
        // 转换为集合，可增减长度
        List<HuffmanTreeNode> huffmanTreeNodeList = new ArrayList<>(Arrays.asList(huffmanTreeNodes));
        while (huffmanTreeNodeList.size() > 1) {
            // 从小到大排序
            Collections.sort(huffmanTreeNodeList);
            // 取 前2个最小的组合成新节点
            HuffmanTreeNode huffmanTreeNode0 = huffmanTreeNodeList.get(0);
            HuffmanTreeNode huffmanTreeNode1 = huffmanTreeNodeList.get(1);
            HuffmanTreeNode temp =  new HuffmanTreeNode(huffmanTreeNode0.getTimes() + huffmanTreeNode1.getTimes(), null);
            temp.setLeftNode(huffmanTreeNode0);
            temp.setRightNode(huffmanTreeNode1);
            // 重新组装集合
            huffmanTreeNodeList.remove(huffmanTreeNode0);
            huffmanTreeNodeList.remove(huffmanTreeNode1);
            huffmanTreeNodeList.add(temp);
        }
        // 循环结束后，集合中唯一的一个节点即为Huffman树的根节点
        this.root = huffmanTreeNodeList.get(0);
        this.root.preOrder();

    }

    public HuffmanTreeNode getRoot() {
        return root;
    }

    public void setRoot(HuffmanTreeNode root) {
        this.root = root;
    }

    public Map<Character, String> getHuffmanCode() {
        return huffmanCode;
    }

    public void setHuffmanCode(Map<Character, String> huffmanCode) {
        this.huffmanCode = huffmanCode;
    }
}


