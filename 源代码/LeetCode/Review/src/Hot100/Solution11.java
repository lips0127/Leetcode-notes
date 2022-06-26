package Hot100;

public class Solution11 {
    /**
     * "谁最短板，优先改变谁."
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if(height.length <= 1)
            return -1;
        int left,right;
        left = 0;right=height.length-1;
        int tempMaxArea = 0;
        while(left < right){
            int h = Math.min(height[left],height[right]);
            tempMaxArea = Math.max(tempMaxArea,h * (right - left));
            // "谁最短板，优先改变谁."
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return tempMaxArea;
    }

    public static void main(String[] args) {
        // [1,8,6,2,5,4,8,25,7]
        int[] height = new int[]{1,8,6,2,5,4,8,25,7};
        int i = maxArea(height);
        System.out.println("蓄水面积：" + i);
    }
}
