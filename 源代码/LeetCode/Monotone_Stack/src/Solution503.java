import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class Solution503 {
    /*
    给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

    示例 1:

    输入: [1,2,1]
    输出: [2,-1,2]
    解释: 第一个 1 的下一个更大的数是 2；
    数字 2 找不到下一个更大的数；
    第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
    注意: 输入数组的长度不会超过 10000。
    * */

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int index = stack.pop();
                ans[index] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int index = stack.pop();
                ans[index] = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        int[] nums = new int[]{1,2,1};
        solution503.nextGreaterElements(nums);
    }
}
