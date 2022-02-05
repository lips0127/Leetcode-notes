public class Solution35 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        int low = 0,high = nums.length-1;
        int middle;
        while(low <= high){
            middle = (low+high)/2;
            if(nums[middle] == target)
                return middle;
            if(nums[middle] > target){
                high = middle - 1;
            }
            else if(nums[middle] < target){
                low = middle + 1;
            }
        }
        return low;
    }
}
