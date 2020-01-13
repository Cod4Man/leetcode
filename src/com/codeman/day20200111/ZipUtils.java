package com.codeman.day20200111;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 压缩工具
 */
public class ZipUtils {
    private Map<Character, String> huffmanCode = new HashMap<>();

    public byte[] zip(String srcFile, String tarFile) {
        File srcF = new File(srcFile);
        File tarF = new File(tarFile);

        return null;
    }

    public Map<Character, String> getHuffmanCode() {
        return huffmanCode;
    }

    public void setHuffmanCode(Map<Character, String> huffmanCode) {
        this.huffmanCode = huffmanCode;
    }
}
