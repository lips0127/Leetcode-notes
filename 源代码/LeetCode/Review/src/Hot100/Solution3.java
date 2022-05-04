package Hot100;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    /**
     *
     * @param
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0,right = 0,tempMax = 0;
        while(right < s.length()){
            if (charSet.contains(s.charAt(right))){
                // 标记出现重复时的左右位置
                System.out.println("left:"+left+",right:"+right);
                while(s.charAt(left) != s.charAt(right)){
                    charSet.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            if(right - left + 1 > tempMax){
                tempMax = right - left + 1;
            }

            charSet.add(s.charAt(right));
            right++;
        }
        return tempMax;
    }

    public static void main(String[] args) {
        String s = "aaaaaaabcdef";
        int i = lengthOfLongestSubstring(s);
        System.out.println("i:"+i);
    }
}
