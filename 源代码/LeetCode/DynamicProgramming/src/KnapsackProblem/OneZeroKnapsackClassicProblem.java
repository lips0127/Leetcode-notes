package KnapsackProblem;

import java.text.MessageFormat;
import java.util.Arrays;

public class OneZeroKnapsackClassicProblem {
    /**
     * 1kg:$1
     * 1kg:$2
     * 2kg:$2
     * 4kg:$10
     * 12kg:$4
     * limit of knapsack = 15kg
     * 动态规划求解该问题.
     * dfs同样可以求解该问题
     * dp[i][j]表示任选中0到i-1号物体，且背包容量为j时，所有物体的总价值
     * dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]] + value[i-1])
     */
    public void calMaxValueByDp(int[] weight,int[] value,int bagSpace){
        /**
         */
        int length = weight.length;
        int[][] dp = new int[length+1][bagSpace+1];
        // 初始化
        for (int i = 0; i < length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= bagSpace ; j++) {
                if(j < weight[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
            }
        }
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= bagSpace ; j++) {
                System.out.println(MessageFormat.format("dp[{0}][{1}]={2}", i, j, dp[i][j]));
            }
            System.out.println("\n");
        }
    }
    public void calMaxValueOneDimension(int[] weight,int[] value,int bagSpace){
        /**
         * 一维数组解决01背包问题
         */
        int[] bag = new int[bagSpace + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSpace; j >= weight[i] ; j--) {
                bag[j] = Math.max(bag[j],bag[j-weight[i]] + value[i]);
            }
        }
        // 打印数组情况
        System.out.println(Arrays.toString(bag));
    }


    public static void main(String[] args) {
        OneZeroKnapsackClassicProblem oneZeroKnapsackClassicProblem = new OneZeroKnapsackClassicProblem();
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        // oneZeroKnapsackClassicProblem.calMaxValueByDp (weight,value,bagsize);
        oneZeroKnapsackClassicProblem.calMaxValueOneDimension (weight,value,bagsize);
    }
}
