package medium;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 *  
 *
 * 提示：
 *
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution62 {

    public int uniquePaths(int m, int n) {
        /**
         * dp
         * numberOfPath[i][j]
         */
        int[][] numberOfPath = new int[m][n];

        for (int i = 0; i < n; i++) {
            numberOfPath[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            numberOfPath[i][0] = 1;
        }
//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(numberOfPath[i]));
//        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(numberOfPath[i][j] != 0)
                    continue;
                if(i-1 >= 0)
                    numberOfPath[i][j] += numberOfPath[i-1][j];
                if(j-1 >= 0)
                    numberOfPath[i][j] += numberOfPath[i][j-1];
                System.out.println(MessageFormat.format("numberOfPath[{0}][{1}]:{2}", i, j, numberOfPath[i][j]));
            }
        }
//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(numberOfPath[i]));
//        }
        return numberOfPath[m-1][n-1];
    }
    public int checkBoard(int m,int n,int i,int j){// m为第一个维度，n为第二个维度
        /**
         * Abort.
         */
        //上边界
        //下边界
        //左侧边界
        //右侧边界
        return -1;
    }

    public static void main(String[] args) {
//        int m = 3,n = 7;
//        int m = 3,n = 3;
        int m = 1,n = 1;
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePaths(m, n));
    }
}
