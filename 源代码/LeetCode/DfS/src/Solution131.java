/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。

 

示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]
 

提示：

1 <= s.length <= 16
s 仅由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */


import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    List<List<String>> ans = new ArrayList<>();
    List<String> t = new ArrayList<>();
    public List<List<String>> partition(String s) {
        /*
        输入：s = "aab"
        输出：[["a","a","b"],["aa","b"]]
         */
        dfs(s,0);
        return ans;
    }
    public void dfs(String s,int start){
        //出口
        if(start >= s.length()){
            ans.add(new ArrayList<>(t));
            return;
        }
        //剪枝
        for(int i=start;i<s.length();i++){
            if(isvalid(s,start,i)){
                t.add(s.substring(start,i+1));
                dfs(s,i+1);
                t.remove(t.size()-1);
            }
        }
    }
    public boolean isvalid(String s,int start,int end){
        for(int i=start,j=end;i<j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        System.out.println(solution131.partition("aab"));
    }
}
