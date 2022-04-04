import java.util.ArrayList;
import java.util.List;

public class Solution8 {
    /**
     * 最大难点是如何过滤 -2^31到2^31-1 之间.
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        // 消除前缀空格.
        long num = 0;
        if(s.length() == 0)
            return 0;
        if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+')
            return 0;
        int prefix = 0,isNegative;
        s = s.trim();
        // 检查正负符号
        if(s.charAt(prefix) == '-') {
            isNegative = -1;
            prefix++;
        }
        else if(s.charAt(prefix) == '+') {
            isNegative = 1;
            prefix++;
        }
        else
            isNegative = 1;
        // 假定从prefix下标所指位置起，往右开始找数字
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<Character>();
        Character[] chars = new Character[]{'0','1','2','3','4','5','6','7','8','9'};
        for(Character ch:chars){
            list.add(ch);
        }
        for (;prefix < s.length(); prefix++) {
            if(list.contains(s.charAt(prefix))){
                sb.append(s.charAt(prefix));
                continue;
            }
            break;
        }
        // 字符串转成数字
        for (int i = 0; i < sb.length(); i++) {
            num = num * 10 + ((int)sb.charAt(i) - 48);
            if(isNegative == 1 && num > Integer.MAX_VALUE)
            {
                num = Integer.MAX_VALUE;
                break;
            }
            if(isNegative == -1 && num > 1L + Integer.MAX_VALUE){
                num = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return isNegative * (int)num;
    }

    public static void main(String[] args) {
        String s = "22";
        System.out.println(myAtoi(s));
//        Character ch0 = '0';
//        Character ch1 = '1';
//        Character ch2 = '2';
//        int in0 = ch0;
//        int in1 = ch1;
//        int in2 = ch2;
//        System.out.println(in0);
//        System.out.println(in1);
//        System.out.println(in2);


    }



}