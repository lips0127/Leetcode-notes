public class Solution1518 {
    /*
    * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。

    如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。

    请你计算 最多 能喝到多少瓶酒。
    输入：numBottles = 9, numExchange = 3
    输出：13
    解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
    所以最多能喝到 9 + 3 + 1 = 13 瓶酒。

    输入：numBottles = 15, numExchange = 4
    输出：19
    解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
    所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
    示例 3：

    输入：numBottles = 5, numExchange = 5
    输出：6
    示例 4：

    输入：numBottles = 2, numExchange = 3
    输出：2

    */
    public int numWaterBottles(int numBottles, int numExchange) {
        /*numBottles:初始酒瓶数量
         * numExchange:换购原则
         * 还需要考虑上一轮剩下的空瓶数量.
         * */
        int drinkSum = 0,num = numBottles,emptyBottle = 0;
        while(num >= 1){
            drinkSum += num;
            //本轮饮用完空瓶 + 已有未兑换空瓶
            num += emptyBottle;
            emptyBottle = 0;
            if(num < numExchange){
                //小于最小兑换数量.
                break;
            }
            emptyBottle += num % numExchange;
            num = num / numExchange;
        }
        return drinkSum;
    }

    public static void main(String[] args) {
        Solution1518 solution1518 = new Solution1518();
        int bottle = 15,exchangeNum = 4;
        System.out.println(solution1518.numWaterBottles(15, 4));
    }
}
