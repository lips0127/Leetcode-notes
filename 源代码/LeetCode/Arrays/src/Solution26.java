import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        /*
          输入：nums = [0,0,1,1,1,2,2,3,3,4]
          输出：5, nums = [0,1,2,3,4]
        * */
        //维护前半段有效（去重的），再从后面挑选与有效部分最后一个位置不同的，加入有效部分
        //low始终指向去重部分的最后一个下标，high指向未去重部分
        if(nums.length == 0||nums.length==1)
            return nums.length;
        int low = 0,high = low;
        while(high < nums.length){
            if(high == nums.length-1 ){
                if(nums[low] != nums[high]){}
                {
                    nums[low] = nums[high];
                }
                low++;
                break;
            }
            //判断high左边是否与他一致:1.不一致，说明high已经可能重复部分的最右侧了，可以直接添加到去重部分
            //2.如果一致，说明未到最右，high右侧有与其一致的元素，high++
            if(nums[high] == nums[high+1]){
                high++;
            }
            else if(nums[high] != nums[high+1]){
                nums[low] = nums[high];
                high++;
                low++;
            }
        }
        return low;
    }
    public void printArrays(int[] nums,int length){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<length;i++){
            list.add(nums[i]);
        }
        System.out.println(list);
    }
    public static void main(String[] args) {
//        int nums[] = new int[]{0,0,1,1,1,2,2,3,3,4};
        int nums[] = new int[]{0,1,1};
        Solution26 solution26 = new Solution26();
        int i = solution26.removeDuplicates(nums);
        solution26.printArrays(nums,i);
    }
}
