package Hot100;
/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * 通过次数950,914提交次数2,689,958
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    /**
     * O(N^2)需要去重.
     * @param nums
     * @return
     */
    @Deprecated
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                int twoNumSum = nums[i]+nums[j];
                int thirdIndex = j + 1;
                while(thirdIndex < nums.length){
                    if(nums[thirdIndex] + twoNumSum == 0){
                        List<Integer> innerList = new ArrayList<>();
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[thirdIndex]);
                        ansList.add(innerList);
                    }
                    thirdIndex++;
                }
            }
        }
        return ansList;
    }

    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        // [-1,0,1,2,-1,-4]
        // -1 -1 0 1 2 -4
        List<List<Integer>> out_list = new ArrayList<>();
        if(len<3)
            return out_list;

        // int i=0,L=i+1,R=len-1;
        for(int i=0;i<len;i++){
            if(nums[i] > 0)
                return out_list;
            if(i>0 && nums[i] == nums[i-1])
            /*
            关于这里为什么写:
            if(nums[i] == nums[i+1])同正确的答案有出入：
            以输入nums = [-1,0,1,2,-1,-4]为例子
            排序之后为:-4 -1 -1 0 1 2
            nums[i] == nums[i+1]的逻辑是，在第一个-1时，发现右边还有和自己一样的-1，就不做自己的操作，转而去执行第二个-1（左边的-1），这样会遗漏[-1,-1,2]这个答案。
            */
                continue;
            int L = i+1,R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    List<Integer> in_list = new ArrayList<>();
                    in_list.add(nums[i]);
                    in_list.add(nums[L]);
                    in_list.add(nums[R]);
                    out_list.add(in_list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                    /*以上4行，是本题最大的收获;
                    这样i,L,R的分配相比我一开始设想的，左右先求一个two_sum，之后去找-two_sum的思路：
                    解决了形如-2 -1 0 1 2这类序列中，左右各位相反数，且有0的情况，左右下标移动情况不明的问题。可以说，这里的4行代码，是本题的核心所在。在while中使用while的操作，可以说是惊为天人！

                    */
                }
                else if(sum > 0){
                    //左侧向右移动
                    R--;
                }
                else{
                    L++;
                }
            }
        }
        return out_list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);

    }
}
