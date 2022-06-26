import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {

    List<List<Integer>> ans = new ArrayList<>();

    LinkedList<Integer> t = new LinkedList<>();

    int[] used;

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        used = new int[n];
        dfs(nums,used,0,0);
        return ans;
    }
    public void dfs(int[] nums,int[] used,int depth,int start){
        /*
        输入：nums = [1,2,3]
        输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
         */
        ans.add(new ArrayList<>(t));
        if(depth >= nums.length){
            return;
        }

        for(int i=start;i<nums.length;i++){
            if(used[i] == 0){
                t.add(nums[i]);
                used[i] = 1;
                dfs(nums,used,depth+1,i+1);
                used[i] = 0;
                t.removeLast();
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        System.out.println(new Solution78().subsets(nums));
    }
}
