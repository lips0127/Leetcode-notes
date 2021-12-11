import java.util.ArrayList;
import java.util.List;

public class Solution376 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,7,4,9,2,5};
        Solution376 solution376 = new Solution376();
//        System.out.println(solution376.wiggleMaxLength(nums));
        System.out.println(solution376.dpWiggleMaxLength(nums));
    }
    public int wiggleMaxLength(int[] nums) {
         if(nums.length == 0 || nums.length == 1)
             return nums.length;
         if(nums.length == 2){
             if(nums[0] == nums[1] )
                 return 1;
             return 2;
         }
         int curDiff = 0,preDiff=0;
         int count=1;
         for(int i=1;i<nums.length;i++){
            curDiff = nums[i]-nums[i-1];
            if((curDiff > 0 && preDiff <= 0)||(curDiff < 0 && preDiff >= 0)){
                count++;
                preDiff = curDiff;
            }
         }
         return count;
    }
    public int dpWiggleMaxLength(int[] nums) {
        int dp[][] = new int[nums.length][2];
        //dp[i][0]:第i个位置作为波峰的最大长度
        //dp[i][1]:第i个位置作为波谷的最大长度
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i=1;i<nums.length;i++){
            dp[i][0] = dp[i][1]=1;
            for(int j=0;j<i;j++){
                dp[i][1]=Math.max(dp[i][1],dp[j][0]+1);
            }
            for(int j=0;j<i;j++){
                dp[i][0]=Math.max(dp[i][0],dp[j][1]+1);
            }
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
