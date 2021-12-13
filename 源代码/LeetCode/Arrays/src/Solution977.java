import java.util.Arrays;

public class Solution977 {
    int[] ans;
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        ans = new int[n];
        //用ans来接受
        int low = 0,high = n-1,i = n-1;
        while(i >= 0){
            if(square(nums[low]) > square(nums[high])){
                ans[i] = square(nums[low]);
                low++;
            }
            else if(square(nums[low]) <= square(nums[high])){
                ans[i] = square(nums[high]);
                high--;
            }
            i--;
        }
        return ans;
    }
    public int square(int num){
        return (int) Math.pow(num,2);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{4,-1,0,3,10};
        int[] nums = new int[]{-7,-3,2,3,11};
        Solution977 solution977 = new Solution977();
        System.out.println(Arrays.toString(solution977.sortedSquares(nums)));
    }
}
