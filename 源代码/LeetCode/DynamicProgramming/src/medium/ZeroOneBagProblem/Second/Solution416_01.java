package medium.ZeroOneBagProblem.Second;

public class Solution416_01 {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num:nums) {
            sum += num;
        }
        if(sum % 2 != 0)
            return false;
        int target = sum / 2;
        int[] bag = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                bag[j] = Math.max(bag[j],bag[j-nums[i]] + nums[i]);
            }
        }
        return bag[target] == target;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
