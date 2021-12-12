public class Solution11 {
    /*
    给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    说明：你不能倾斜容器。
    输入：[1,8,6,2,5,4,8,3,7]
    输出：49
    解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    示例 2：

    输入：height = [1,1]
    输出：1
    示例 3：

    输入：height = [4,3,2,1,4]
    输出：16
    示例 4：

    输入：height = [1,2,1]
    输出：2
     

    提示：

    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104
    * */
    public int maxArea(int[] height) {
        int low=0,high = height.length-1;//设置左右
        int tempMax = 0;
        //计算容积的公式:Math.min(height[low],height[high]) * (high - low)
        while(low < high) {
            int capacity = Math.min(height[low], height[high]) * (high - low);
            if (capacity > tempMax)
                tempMax = capacity;
            if(height[low] < height[high])
                low++;
            else if(height[low] > height[high])
                high--;
            else{
                int leftPlusCapacity = Math.min(height[low+1], height[high]) * (high - low-1);
                int rightMinusCapacity = Math.min(height[low], height[high-1]) * (high - low-1);
                if(leftPlusCapacity > rightMinusCapacity){
                    low++;
                }else if(leftPlusCapacity < rightMinusCapacity){
                    high--;
                }else{
                    if(height[low+1] > height[high-1])
                        low++;
                    else
                        high--;
                }
            }
        }
        return tempMax;
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
//        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
//        int[] height = new int[]{1,2,4,3};
//        int[] height = new int[]{1,8,6,2,5,4,8,25,7};
//        [1,3,2,5,25,24,5]
        int[] height = new int[]{1,3,2,5,25,24,5};
        System.out.println(solution11.maxArea(height));
    }

}
