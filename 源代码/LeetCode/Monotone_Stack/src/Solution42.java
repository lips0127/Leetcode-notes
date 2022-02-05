
import java.util.Stack;
import java.util.WeakHashMap;

public class Solution42 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     *
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *  
     *
     * 提示：
     *
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     *
     * @param height
     * @return
     */
    public int trap2(int[] height){
        //单调栈
        int totalWater = 0;

        return totalWater;
    }


    public int trap1(int[] height){
        //dynamic program
        /**
        在双指针情况下，我们每次都去寻找了两侧最大高度，但是明显是存在重复问题的，可以先行存储所有最大高度。
         dp公式:
         leftMaxHeight[i] = max(height[i],leftMaxHeight[i-1])
         rightMaxHeight[i] = max(height[i],rightMaxHeight[i+1])
        */
        int totalWater = 0,heightLen = height.length;
        int[] leftMaxHeight = new int[heightLen];
        int[] rightMaxHeight = new int[heightLen];
        leftMaxHeight[0] = height[0];
        rightMaxHeight[heightLen-1] = height[heightLen-1];

        for (int i = 1; i < height.length; i++) {
            leftMaxHeight[i] = Math.max(height[i],leftMaxHeight[i-1]);
        }
        for (int i = heightLen-2; i > -1 ; i--) {
            rightMaxHeight[i] = Math.max(height[i],rightMaxHeight[i+1]);
        }
        for (int i = 0; i < heightLen; i++) {
            totalWater += calWater(leftMaxHeight[i],rightMaxHeight[i],height[i]);
        }
        return totalWater;
    }



    public int trap0(int[] height){
        //双指针
        int totalWater = 0;
        System.out.println(height);
        for (int i = 0; i < height.length; i++) {
//            System.out.println("位置"+i+"左右两侧最高分别为"+leftHighest(height, i)+":"+rightHighest(height,i));
            totalWater += calWater(leftHighest(height,i),rightHighest(height,i),height[i]);
        }
        return totalWater;
    }

    public int leftHighest(int[] height,int index){
        //Get the highest subscript on the left
        int tempHighest = height[index];
        for (int i = index; i > -1; i--) {
            if(height[i] > tempHighest)
                tempHighest = height[i];
        }
        return tempHighest;
    }
    public int rightHighest(int[] height,int index){
        int tempHighest = height[index];
        for (int i = index; i < height.length; i++) {
            if(height[i] > tempHighest)
                tempHighest = height[i];
        }
        return tempHighest;
    }

    public int calWater(int leftHeight,int rightHeight,int height){
        int rowWater = Math.min(leftHeight,rightHeight) - height;
        if(rowWater > 0)
            return rowWater;
        return 0;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] height = new int[]{4,2,0,3,2,5};
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.trap1(height));
    }
}
