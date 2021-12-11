import java.util.Arrays;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        /*
        * 输入：nums = [5,7,7,8,8,10], target = 8
            输出：[3,4]
        * */
        int left = leftBorder(nums, target);
        int right = rightBorder(nums,target) - 1;
        System.out.println(left);
        System.out.println(right);
        if((0 <= left && left <= nums.length-1)&&(right >=0 && right<= nums.length-1) && left<=right)
            return new int[]{left,right};
        else
            return new int[]{-1,-1};
    }

    public int leftBorder(int[] nums,int target){
        //寻找左边界
        int low = 0,high = nums.length-1,middle;
        while(low <= high){
            middle = (low + high)/2;
            if(nums[middle] > target)
                high = middle-1;
            else if(nums[middle] < target)
                low = middle+1;
            else
                high = middle-1;
        }
        return low;
    }

    public int rightBorder(int[] nums,int target){
        //寻找右边界
        int low = 0,high = nums.length-1,middle;
        while(low <= high){
            middle = (low + high)/2;
            if(nums[middle] > target)
                high = middle-1;
            else if(nums[middle] < target)
                low = middle+1;
            else
                low = middle+1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,8,10};
        int target = 8;
        Solution34 solution34 = new Solution34();
        System.out.println(Arrays.toString(solution34.searchRange(nums, target)));
//        int left = solution34.leftBorder(nums, 7);
//        int right = solution34.rightBorder(nums,7);
//        System.out.println(left);
//        System.out.println(right);
    }
}
