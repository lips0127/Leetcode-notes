import java.util.ArrayList;
import java.util.List;
/*
* 相似题目：
* 844.比较含退格的字符串
977.有序数组的平方
#其他语言版本
* */
public class Solution283 {
    /*
    *
    * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        示例:
        输入: [0,1,0,3,12]
        输出: [1,3,12,0,0]
        说明:
        必须在原数组上操作，不能拷贝额外的数组。
        尽量减少操作次数。
    * */
    public void moveZeroes(int[] nums) {
        int low = 0, high = low, lastZero = nums.length - 1;
        while (high < nums.length) {
            //可能要处理high == nums.length-1的问题
            if (nums[high] != 0) {
                nums[low] = nums[high];
                low++;
            }
            // while(high == nums.length-1 && low < nums.length)
            // {
            //     nums[low] = 0;
            //     low++;

            // }
            high++;
        }
        // O(N)处理从low开始后面全部置为0
        for (int i = low; i < nums.length; i++) {
            nums[i] = 0;

        }
    }


    public void moveZeroes1(int[] nums) {
        int low=0,high = nums.length-1;
        while(low <= high){
            //使用temp维护当前位置的0
            if(nums[low] == 0){
                int temp=nums[low];
                for(int i=low;i<=high-1;i++){
                    nums[i] = nums[i+1];
                }
                nums[high] = temp;
                high--;
            }
            else{
                low++;
            }
        }
    }
    public void printArrays(int[] nums,int length){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<length;i++){
            list.add(nums[i]);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,0,0,0,0,0,2,3,12};
        Solution283 solution283 = new Solution283();
        solution283.moveZeroes(nums);
        solution283.printArrays(nums,nums.length);
    }

}
