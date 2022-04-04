/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution5 {
    /**
     * 最长回文子串.
     * dp[i][j]:下标i到j之间的字符串是否为回文类型
     * 状态方程:
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        // dp[0][0] = true;
        int left = 0,right = 0,maxlength = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(i) != s.charAt(j))
                    continue;
                if(j - i <= 1){
                    dp[i][j] = 1;
                }else if(dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                }
                else
                    dp[i][j] = 0;
                //
                if(dp[i][j] == 1 && j - i + 1 > maxlength){//更新当前最大回文子串.
                    maxlength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left,right + 1);
    }

    public static void main(String[] args) {
        String s = "absbaaaaa";
        System.out.println(longestPalindrome(s));
    }
}
