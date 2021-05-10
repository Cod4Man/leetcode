package com.codeman.before210510.day20200407;

import java.util.*;

/**
 * @author: zhanghongjie
 * @description: 前 K 个高频元素
 * @date: 2020/4/7 21:47
 * @version: 1.0
 */
public class No347 {

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new No347().topKFrequent(nums, 2));
    }

    /**
     * 试试桶排序： 空间换时间, 把次数放到对应的桶中，然后倒序遍历前k个不为空得即可
     * 因此先要获得次数，就可以利用map key得唯一性
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> resultIn = new ArrayList<>(k);
        Map<Integer, Integer> mapNums = new HashMap<>();
        for (int num : nums) {
            mapNums.put(num, mapNums.getOrDefault(num, 0) + 1);
        }
        // 创建nums长度个桶，因为最坏得情况就是一个都没有重复， 这里有个数组越界得问题，如果数组长度为1，则会越界
        ArrayList<Integer>[] listArrs = new ArrayList[nums.length + 1];
        for (Integer key : mapNums.keySet()) {
            if (listArrs[mapNums.get(key)] == null) {
                listArrs[mapNums.get(key)]  = new ArrayList();
            }
            // 会按出现得次数，塞进下标为次数得集合中
            listArrs[mapNums.get(key)].add(key);
        }

        // 取数,直至resultIn.size() = k
        for (int i = listArrs.length - 1; i >= 0 && resultIn.size() < k; i--) {
            if (listArrs[i] == null) {
                continue;
            }
            // 如果小于剩余长度，则可全部加入resultIn
            if (listArrs[i].size() <= k - resultIn.size()) {
                resultIn.addAll(listArrs[i]);
            } else {
                resultIn.addAll(listArrs[i].subList(0, k - resultIn.size()));
            }
        }
        return resultIn;
    }

    /**
     * 堆排序，最小堆
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }
}
