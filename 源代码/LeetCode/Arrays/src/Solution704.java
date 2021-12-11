import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;

public class Solution704 {
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

    public static void main(String[] args) {
        Solution704 solution704 = new Solution704();
        //nums = [-1,0,3,5,9,12], target = 9
        int[] nums = new int[]{1,3,5,7,9};
        int target = 10;
        System.out.println(solution704.search(nums, target));
    }
}
