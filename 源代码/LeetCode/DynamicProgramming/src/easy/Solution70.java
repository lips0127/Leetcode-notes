package easy;

public class Solution70 {
    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     *
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     *
     *
     * 提示：
     *
     * 1 <= n <= 45
     */
    public int climbStairs(int n) {
        if(n <= 3)
            return n;
        int[] totalPath = new int[n+1];
        totalPath[1] = 1;
        totalPath[2] = 2;
        totalPath[3] = 3;
        for (int i = 4; i < n+1; i++) {
            totalPath[i] = totalPath[i-1] + totalPath[i-2];
        }
        return totalPath[n];
    }

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        for (int i = 1; i < 10; i++) {
            System.out.println("i = "+ i +","+solution70.climbStairs(i));
        }
    }
}
