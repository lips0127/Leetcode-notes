import com.sun.xml.internal.txw2.output.CharacterEscapeHandler;

import java.text.MessageFormat;
import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 *
 *
 *
 * 输入： heights = [2,4]
 * 输出： 4
 *  
 *
 * 提示：
 *
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        //双指针
        int tempMax = 0;
        for (int i = 0; i < heights.length; i++) {
            int tempCal = calMaxColumnRectangle(i,heights);
            if (tempCal > tempMax)
                tempMax = tempCal;
        }
        return tempMax;
    }
    public int largestRectangleArea1(int[] heights){
        /**
         * 左侧边界.leftFirstLow[0] = 0;纠正，这里需要明确地是leftFirstLow[i]存放的是i左侧的首个比其小的元素
         * 如果按照我原有的思路,是左右边界，会导致死循环。
         */
        int tempMax = 0;
        int heightsLength = heights.length;
        int[] leftFirstLow = new int[heightsLength];
        int[] rightFirstLow = new int[heightsLength];
        leftFirstLow[0] = -1;
        rightFirstLow[rightFirstLow.length-1] = heightsLength;
        //left
        for (int i = 1; i < heightsLength; i++) {
            int left = i-1;
            while(left >= 0 && heights[left] >= heights[i])
                left = leftFirstLow[left];
            leftFirstLow[i] = left;
        }
        //right
        for (int i = heightsLength-2; i > -1 ; i--) {
            int right = i+1;
            while(right < heightsLength && heights[right] >= heights[i])
                right = rightFirstLow[right];
            rightFirstLow[i] = right;
        }
        for (int i = 0; i < heightsLength; i++) {
            System.out.println(MessageFormat.format("index:{0},left:{1},right:{2},height:{3}", i, leftFirstLow[i], rightFirstLow[i], heights[i]));
            int tempArea =  ((rightFirstLow[i] - 1)- (leftFirstLow[i] + 1)+ 1) * heights[i];
            if(tempArea > tempMax)
                tempMax = tempArea;
        }
        return tempMax;
    }
    /**
     * Calculates the maximum rectangle for a column
     * O(N^2)
     */
    public int calMaxColumnRectangle(int index,int heights[]) {
        //both side
        int left,right;
        right = left = index;
        //right
        while(right < heights.length-1){
            if(heights[index] > heights[right+1])
                break;
            right += 1;
        }
        while(left > 0){
            if(heights[index] > heights[left-1])
                break;
            left -= 1;
        }
        System.out.println("index:" + index + ",left:" + left + ",right:" + right + ",height:" + heights[index]);
        return heights[index] * (right - left + 1);
    }

    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
//        int[] heights = new int[]{2,1,5,6,2,3};
        int[] heights = new int[]{2,4};
//        int[] heights = new int[]{4,2,0,3,2,4,3,4};
        System.out.println(solution84.largestRectangleArea(heights));
        System.out.println(solution84.largestRectangleArea1(heights));
    }

}
