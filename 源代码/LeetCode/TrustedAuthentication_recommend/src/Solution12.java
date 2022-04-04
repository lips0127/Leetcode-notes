import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 给你一个整数，将其转为罗马数字。

  

 示例 1:

 输入: num = 3
 输出: "III"
 示例 2:

 输入: num = 4
 输出: "IV"
 示例 3:

 输入: num = 9
 输出: "IX"
 示例 4:

 输入: num = 58
 输出: "LVIII"
 解释: L = 50, V = 5, III = 3.
 示例 5:

 输入: num = 1994
 输出: "MCMXCIV"
 解释: M = 1000, CM = 900, XC = 90, IV = 4.
  

 提示：

 1 <= num <= 3999

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/integer-to-roman
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution12 {
    /***
     * 解析整型数字统计各数字级别都有多少个..
     * 1000,500,100,50,10,5,1
     * 组合型：900,400,90,40,9,4.
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        int[] levelCount = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        Map<Integer,Integer> map = new HashMap<>();
        // 初始化
        for (int i = 0; i < levelCount.length; i++) {
            int thisLevelCount = 0,rest = 0;
            if(num >= levelCount[i]){
                thisLevelCount = num / levelCount[i];
                rest = num % levelCount[i];
                map.put(levelCount[i],thisLevelCount);
                num =  rest;
            }
        }
        // 整型与字符映射.
        Map<Integer,String> charMap = new HashMap<>();
        charMap.put(1000,"M");
        charMap.put(900,"CM");
        charMap.put(500,"D");
        charMap.put(400,"CD");
        charMap.put(100,"C");
        charMap.put(90,"XC");
        charMap.put(50,"L");
        charMap.put(40,"XL");
        charMap.put(10,"X");
        charMap.put(9,"IX");
        charMap.put(5,"V");
        charMap.put(4,"IV");
        charMap.put(1,"I");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < levelCount.length; i++) {
            if(!map.containsKey(levelCount[i]))
                continue;
            int j = map.get(levelCount[i]);
            while(j > 0) {
                sb.append(charMap.get(levelCount[i]));
                j--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        intToRoman(num);
    }
}
