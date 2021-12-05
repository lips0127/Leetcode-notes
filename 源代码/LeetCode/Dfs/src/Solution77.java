import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static sun.misc.Version.print;

/*
示例 1：

输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
示例 2：

输入：n = 1, k = 1
输出：[[1]]

提示：
1 <= n <= 20
1 <= k <= n

 */
public class Solution77 {
    List<List<Integer>> ans = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        //假设输入4,2，数组生成为[1,2,3,4]，要求返回长度为2的所有组合
        //也就是说数组里面所有数字并不重复
        int[] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = i+1;
        }
        System.out.println(Arrays.toString(nums));
        //dfs
        dfs(nums,0,0,k);
        return ans;
    }

    public void dfs(int[] nums,int depth,int start,int k){

        if(path.size() == k && depth == k){
            System.out.println("depth:"+depth);
            System.out.println("path:"+path);
            ans.add(new ArrayList<>(path));
            System.out.println("ans:"+ans);
            return;
        }
        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            dfs(nums,depth+1,i+1,k);
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        System.out.println("result:"+solution77.combine(4, 2));

    }

}
