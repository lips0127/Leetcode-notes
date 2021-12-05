import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

 

示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：

输入：nums = [0]
输出：[[],[0]]

提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */
public class Solution90 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        used = new int[n];
        Arrays.sort(nums);
        //dfs
        dfs(nums,used,0,0);
        return ans;
    }
    public void dfs(int[] nums,int[] used,int depth,int start){
        ans.add(new ArrayList<>(path));
        if(depth >= nums.length)
            return;
        for(int i=start;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1] && used[i-1] == 0)
                continue;
            if(used[i] == 0){
                path.add(nums[i]);
                used[i] = 1;
                dfs(nums,used,depth+1,i+1);
                used[i] = 0;
                path.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,2,2,2,2};
        Solution90 solution90 = new Solution90();
        System.out.println(solution90.subsetsWithDup(nums));
    }
}
