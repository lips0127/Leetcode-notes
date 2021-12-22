import java.util.*;

public class Solution76 {
    /*
        给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

     

    注意：

    对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    如果 s 中存在这样的子串，我们保证它是唯一的答案。
     

    示例 1：

    输入：s = "ADOBECODEBANC", t = "ABC"
    输出："BANC"
    示例 2：

    输入：s = "a", t = "a"
    输出："a"
    示例 3:

    输入: s = "a", t = "aa"
    输出: ""
    解释: t 中两个字符 'a' 均应包含在 s 的子串中，
    因此没有符合条件的子字符串，返回空字符串。
     

    提示：

    1 <= s.length, t.length <= 105
    s 和 t 由英文字母组成
     

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/minimum-window-substring
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    Map<Character, Integer> nums = new HashMap<>();
    int subCount = 0;
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int low = 0, high = low, len = 0, tempMin = 0;

        String tempMinStr = "";
        nums = new HashMap<>();
        valueDictionaryAssignment(nums, t);
        Map<Character, Integer> tempNums = new HashMap<>(nums);
        System.out.println(nums);
        subCount = t.length();
        int firstHitLast = 0;
        //
        while (high < s.length()){
            /*
            * 维护滑动窗口
            * */
            //第一次high到最后，做减法，其他次数来，就不再做减法了
//            if(high < s.length()-1)
//                minusMap(tempNums,s.charAt(high));
            if(high <= s.length()-1 && firstHitLast == 0){
                minusMap(tempNums,s.charAt(high));
                firstHitLast = 1;
            }
            if(judge(tempNums) == 1){
                len = high-low+1;
                if(len < tempMin || tempMin == 0){
                    tempMin = len;
                    tempMinStr = s.substring(low,high+1);
                }
                //如何调整low的位置.
                //特殊情况
                if(low == high){
                    low++;
                    high = low;
                    firstHitLast = 0;
                    break;
                }
                //其他情况
                for(int i=low;i<=high;i++){
                    if(tempNums.containsKey(s.charAt(i))){
                        //遇到了子串中的任何一个,i停止移动
                        tempNums.replace(s.charAt(i),tempNums.get(s.charAt(i)) + 1);
                        if(tempNums.get(s.charAt(i)) >= 1 && tempNums.get(s.charAt(i)) <= nums.get(s.charAt(i))){
                            subCount++;
                        }

                        low = i+1;
                        if(high < s.length()-1)
                            high++;
                        break;
                    }
                }
            }else
                high++;

        }
        return tempMinStr;
    }
    public int judge(Map<Character,Integer> map){
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue() > 0)
                return -1;
        }
        return 1;
    }
    public void minusMap(Map<Character,Integer> map,char key) {
        if(map.containsKey(key)){
            int count = map.get(key);
            if(count-1 >= 0){
                subCount--;
            }
            map.put(key,count-1);

        }

    }

    public void valueDictionaryAssignment(Map<Character,Integer> map,String s){
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }
            else{
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i),count+1);
            }

        }
    }

    public static void main(String[] args){
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        s = "ADOBECODEBANC";
        t = "ABC";
//        s = "aaa";
//        t = "aa";
        Solution76 solution76 = new Solution76();
        System.out.println(solution76.minWindow(s, t));

    }
}
