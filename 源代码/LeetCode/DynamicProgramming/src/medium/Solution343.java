package medium;

public class Solution343 {
    /**
     */
    public int integerBreak(int n) {
        /**
         * 数字n可以最多拆分为n个数字（全为1），但无意义；故这里最多拆分到n-1个（一个2，其余为1）。
         * MaxProduct[i]表示数字i的拆分后最大乘积
         *
         */
        int[] maxProduct = new int[n+1];//我想让i代表了输入的数字本身，所以必须留一个空位
        maxProduct[1] = 0;
        maxProduct[2] = 1;
        //如果输入是5,那么需要获取3到5的所有maxProduct[i]值
        if(n <= 2)
            return maxProduct[2];
        for (int i = 3; i < maxProduct.length; i++) {
            for (int j = 1; j < i; j++) {
                int thisMax = Math.max(j * maxProduct[i-j],j * (i-j));
                if(thisMax > maxProduct[i])
                    maxProduct[i] = thisMax;
            }
        }
        return maxProduct[n];
    }

    public static void main(String[] args) {
        Solution343 solution343 = new Solution343();
        System.out.println(solution343.integerBreak(10));
    }
}
