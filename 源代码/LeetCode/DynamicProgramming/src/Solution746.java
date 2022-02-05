import java.text.MessageFormat;

public class Solution746 {
    /**
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     *
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     *
     * 请你计算并返回达到楼梯顶部的最低花费。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：cost = [10,15,20]
     * 输出：15
     * 解释：你将从下标为 1 的台阶开始。
     * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
     * 总花费为 15 。
     * 示例 2：
     *
     * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
     * 输出：6
     * 解释：你将从下标为 0 的台阶开始。
     * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
     * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
     * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
     * 总花费为 6 。
     *  
     *
     * 提示：
     *
     * 2 <= cost.length <= 1000
     * 0 <= cost[i] <= 999
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minCostClimbingStairs(int[] cost) {
        /**
         * totalCost[i] = Math.min(totalCost[i-1] + cost[i-1],totalCost[i-2] + cost[i-2]);
         * totalCost[0] = 0;
         * totalCost[1] = 0;
          */
        int costLength = cost.length;
        int[] totalCost = new int[costLength];
        totalCost[0] = 0;
        totalCost[1] = 0;
        for (int i = 2; i < costLength; i++) {
            totalCost[i] = Math.min(totalCost[i-1] + cost[i-1],totalCost[i-2] + cost[i-2]);
            System.out.println(MessageFormat.format("totalCost[{0}]:{1},location:{2}",i,totalCost[i],i+1));
        }
        return Math.min(totalCost[costLength-1] + cost[costLength-1],totalCost[costLength-2] + cost[costLength-2]);
    }

    public static void main(String[] args) {
//        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        int[] cost = new int[]{10,15,20};
        Solution746 solution746 = new Solution746();
        System.out.println(solution746.minCostClimbingStairs(cost));
    }
}
