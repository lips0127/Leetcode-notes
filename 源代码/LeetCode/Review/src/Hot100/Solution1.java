package Hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    /** 经典题目-两数之和
     * O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum0(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 优化.
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int target = 9;
        int[] nums = new int[]{2,7,11,15};
        int[] ints = solution1.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

}
