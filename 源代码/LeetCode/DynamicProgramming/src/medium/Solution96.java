package medium;

public class Solution96 {
    /**
     *给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：n = 3
     * 输出：5
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：1
     *  
     *
     * 提示：
     *
     * 1 <= n <= 19
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        /**
         * 一言以概之：对于任意一个有n个节点的二叉搜索树，如果左子树有i个节点，那么右子树就会有n-i个。
         * 那么显然，dp[n] = ∑(i from 0 -> n)dp[i]*dp[n-i]
         */
        // Types of binary search tree composed of N nodes
        int[] typeOfBiTree = new int[n+1];
        typeOfBiTree[0] = 1;
        typeOfBiTree[1] = 1;
        typeOfBiTree[2] = 2;
        typeOfBiTree[3] = 5;
        if(n <= 3)
            return typeOfBiTree[n];
        for (int i = 4; i <= n; i++) {
            for (int j = 0; j <= i-1; j++) {
                typeOfBiTree[i] += typeOfBiTree[j]*typeOfBiTree[i-1-j];
            }
        }
        return typeOfBiTree[n];
    }

    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees(4));
        System.out.println(solution96.numTrees(5));
        System.out.println(solution96.numTrees(6));
    }
}
