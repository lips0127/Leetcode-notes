import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * 小顶堆：对于一棵完全二叉树，非叶子结点的值要小于其左右节点。
 * 需要注意的一个点：如果需要找到前k高频的元素，那么反而需要使用到小顶堆，为什么？
 * 因为小顶堆将整个数组（堆排序使用的数据结构其实是数组）的最小值放到最后（小顶堆堆顶同数组队尾交换
 *
 *
 */

public class Solution347 {
    static Comparator<Map.Entry<Integer,Integer>> com = new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
    };
    public static int[] topKFrequent(int[] nums, int k) {
        // 哈希表统计次数
        int[] result = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        // 这里是第一次使用，是将一个kv实体键值对作为一个元素，放置到一个set集合
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
        // 初始化一个优先队列，并且明确了排序的规则
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(com);
        for (Map.Entry<Integer,Integer> entry:entries) {
            queue.offer(entry);
            if(queue.size() > k){
                queue.poll();
            }
        }
//        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
//        // 根据map的value值正序排，相当于一个小顶堆
//        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
//        for (Map.Entry<Integer, Integer> entry : entries) {
//            queue.offer(entry);
//            if (queue.size() > k) {
//                queue.poll();
//            }
//        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));

    }
}
