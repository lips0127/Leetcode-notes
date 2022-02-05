import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution496 {
    /*
    nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。

    给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。

    对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。

    返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。

     

    示例 1：

    输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
    输出：[-1,3,-1]
    解释：nums1 中每个值的下一个更大元素如下所述：
    - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
    - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
    - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
    示例 2：

    输入：nums1 = [2,4], nums2 = [1,2,3,4].
    输出：[3,-1]
    解释：nums1 中每个值的下一个更大元素如下所述：
    - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
    - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
     

    提示：

    1 <= nums1.length <= nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 104
    nums1和nums2中所有整数 互不相同
    nums1 中的所有整数同样出现在 nums2 中
    * */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> mapper = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums1.length];

        Arrays.fill(ans, -1);
        for (int i = 0; i < nums1.length; i++) {
            mapper.put(nums1[i],i);// key为元素，value为下标
        }

        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                int index = stack.pop();
                //index实际上存放
                if(mapper.containsKey(nums2[index]))
                    //存储的元素，而非下标
//errors:                    ans[mapper.get(nums2[index])] = i - index;
                    ans[mapper.get(nums2[index])] = nums2[i];
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(ans));

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        Solution496 solution496 = new Solution496();
        solution496.nextGreaterElement(nums1,nums2);
    }
}
