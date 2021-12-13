public class Solution209 {
    public int minSubArrayLen0(int target, int[] nums) {
        /*low，high，始终维护当前子数组，一旦子数组值大于或等于target，就不在维护该数组了
        low = high+1;high = low;
        维护sum记录当前的子数组和，tempmin维护当前最小，如果有更小，就更新。
        * */
        int low = 0,high = low,sum = 0,tempMin = 0;
        while(high <= nums.length-1){
            if(sum + nums[high] >= target){
                int len = high - low + 1;
                if(len < tempMin || tempMin == 0){
                    tempMin = len;
                }
                low = low+1;
                high = low;
                sum=0;
            }
            else{
                sum += nums[high];
                high++;
            }
        }
        return tempMin;
    }
    public int minSubArrayLen(int target, int[] nums){
        /*low，high，始终维护当前子数组，一旦子数组值大于或等于target，就不在维护该数组了
        最核心的思想：
        1.对于这种还有双指针的题目，始终只让一种情况做“加法”
        对于另一面的情况，只去维护区间（循环不变量）
        2.类似之前做过得最长回文子串，low的变化是有讲究的。
        （最长回文子串中，low = 重复字符在子串中位置 + 1）
        而本题中，low = low + 1；而且直观上的low = high + 1;(这个点挺易错的)
        维护sum记录当前的子数组和，tempmin维护当前最小，如果有更小，就更新。
        * */
        int low = 0,high = low,sum = 0,tempMin = 0;
        while(high <= nums.length-1){
            if(sum + nums[high] >= target){
                //如果加上了这一个就超了，应当不做添加.
                int len = high - low + 1;
                if(len < tempMin || tempMin == 0){
                    tempMin = len;
                }
                sum -= nums[low];
                low = low+1;
                //high不变动.
            }
            else{
                sum += nums[high];
                high++;
            }
        }
        return tempMin;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        Solution209 solution209 = new Solution209();
        System.out.println(solution209.minSubArrayLen0(11, nums));
    }
}
