import java.util.Arrays;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for(int i=0;i < len;++i){
            if(nums[i] == val){
                len += remove(nums,i,len);
                //如果解决该元素后面一个也是需要移除的
                i--;
            }
        }
        return len;
    }

    public int remove(int[] nums,int index,int len){
        //使用一次remove，长度要减一
//        if(index == len-1)
//            return -1 ;
        for(int i=index;i<len-1;++i){
            nums[i] = nums[i+1];

        }
        return -1;
    }
/*
* 双指针做法
* */
    public int doublePointer(int[] nums, int val) {
        int slow = 0,fast = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    public static void main(String[] args) {
        /*
        输入：nums = [0,1,2,2,3,0,4,2], val = 2
        输出：5, nums = [0,1,4,0,3]
        */
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        Solution27 solution27 = new Solution27();
        System.out.println(solution27.doublePointer(nums, val));
    }
}
