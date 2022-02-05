package medium;

import java.util.Arrays;

public class Solution63 {
    /**
     *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     *
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     *
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2
     * 解释：3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     * 示例 2：
     *
     *
     * 输入：obstacleGrid = [[0,1],[0,0]]
     * 输出：1
     *  
     *
     * 提示：
     *
     * m == obstacleGrid.length
     * n == obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] 为 0 或 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] numberOfPath = new int[height][width];// 初始时每个位置都是1.
        //
        for (int i = 0; i < width; i++) {// 初始化首行
            if(obstacleGrid[0][i] == 1)
                break;
            numberOfPath[0][i] = 1;
        }
        for (int i = 0; i < height; i++){// 初始化首列
            if(obstacleGrid[i][0] == 1)
                break;
            numberOfPath[i][0] = 1;
        }

        //
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(obstacleGrid[i][j] == 1)
                    continue;
                if(i-1 >= 0 && obstacleGrid[i-1][j] == 0)
                    numberOfPath[i][j] += numberOfPath[i-1][j];
                if(j-1 >= 0 && obstacleGrid[i][j-1] == 0)
                    numberOfPath[i][j] += numberOfPath[i][j-1];
            }
        }
        for (int i = 0; i < height; i++) {
            System.out.println(Arrays.toString(numberOfPath[i]));
        }
        return numberOfPath[height-1][width-1];
    }

    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
    }

}
