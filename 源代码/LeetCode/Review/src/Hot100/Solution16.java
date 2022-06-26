package Hot100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 * 通过次数347,884提交次数761,787
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3)
            return nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int minusDistance = 3104;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1,right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                // 唯一解
                if(sum == target)
                    return sum;
                if(sum > target){
                    int minusDis = sum - target;
                    if(minusDis < minusDistance){
                        map.put(minusDis,sum);
                        minusDistance = minusDis;
                    }
                    right--;
                    continue;
                }
                if(sum < target){
                    int minusDis = target - sum;
                    if(minusDis < minusDistance){
                        map.put(minusDis,sum);
                        minusDistance = minusDis;
                    }
                    left++;
                }
            }

        }
        return map.get(minusDistance);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        Solution16 solution16 = new Solution16();
        System.out.println("最接近的解:" + solution16.threeSumClosest(nums, 1));
    }
}
