import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    /*
    * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

         

        示例 1:

        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
        示例 4:

        输入: s = ""
        输出: 0
         

        提示：

        0 <= s.length <= 5 * 104
        s 由英文字母、数字、符号和空格组成

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

    * */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s.length();
        int low=0,high=low;
        int tempMax = 0;
        Map<Character,Integer> db = new HashMap<>();
        while(high <= s.length()-1){
            if(!db.containsKey(s.charAt(high))){
                db.put(s.charAt(high),high);
                high++;
            }
            else{//db中有了这个元素了
                low = db.get(s.charAt(high)) + 1;
                db.clear();
                high = low;
//                db.put(s.charAt(high),high);
            }
            int len = db.size();
            if(len > tempMax){
                tempMax = len;
            }
        }
        return tempMax;
    }
//    public boolean exist(String s,int start,int end,char ch){
//
//    }
public static void main(String[] args) {
    Solution3 solution3 = new Solution3();
    System.out.println(solution3.lengthOfLongestSubstring("aa"));

}
}
