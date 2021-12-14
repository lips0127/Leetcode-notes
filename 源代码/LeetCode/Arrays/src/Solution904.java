import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution904 {
    /*
        * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。

    你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：

    你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
    你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
    一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
    给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。

     

    示例 1：

    输入：fruits = [1,2,1]
    输出：3
    解释：可以采摘全部 3 棵树。
    示例 2：

    输入：fruits = [0,1,2,2]
    输出：3
    解释：可以采摘 [1,2,2] 这三棵树。
    如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
    示例 3：

    输入：fruits = [1,2,3,2,2]
    输出：4
    解释：可以采摘 [2,3,2,2] 这四棵树。
    如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
    示例 4：

    输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
    输出：5
    解释：可以采摘 [1,2,1,1,2] 这五棵树。
     

    提示：

    1 <= fruits.length <= 105
    0 <= fruits[i] < fruits.length

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/fruit-into-baskets
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */

    //未优化，性能较差。
    public int totalFruit0(int[] fruits) {
        //寻找只含两种元素的最长子数组
        //至于为什么元素值为0不行？题目要求，你必须选择确切的一个水果，不选就没得采了
        /*维护一个有效区间。
        * */
        int low = 0,high = low,len = 0,tempMax = 0;
        Set<Integer> basket = new HashSet<>();
        while(high < fruits.length){

            if(!basket.contains(fruits[high]) && basket.size()==2){
                //这个set中没有，并且set已经满了（种类满了）
                low += 1;
                high = low;
                basket.clear();
            }else{
                basket.add(fruits[high]);
                len = high - low + 1;
                if(len > tempMax)
                    tempMax = len;
                if(high == fruits.length-1)
                    break;
                    high++;
            }
        }
        return tempMax;
    }
    /*
    * 针对这题的优化，格式上类似于昨天12.13中题目09.长度最小的子数组滑动窗口的优化。
    * 但是具体的做法又有点类似lru
    * 例如：已有[1,2]，新来了一个1个3，3左侧一定是1或者2，所以找出最近最久没被使用的1
    * 该下标加1就是low应该更新的位置。
    * 这里需要注意，如果一直没找到，就应当i回到low，并且low = i+1
    * 这也就最坏情况
    * 同totalFruit0()里面的 low = low + 1一致
    * 最坏情况下，优化后的时间消耗和未优化一致

    * */
    public int totalFruit(int[] fruits){
        int low = 0,high = low,len = 0,tempMax = 0;
        Set<Integer> basket = new HashSet<>();
        int[] used = new int[2];
        while(high < fruits.length){
            if(!basket.contains(fruits[high]) && basket.size()==2){
                int lastValue = fruits[high-1];
                int i = high - 1;
                while(i >= low){
                    if(fruits[i] == lastValue){
                        i--;
                    }
                    else{
                        basket.remove(fruits[i]);
                        low = i + 1;
                        break;
                    }
                }

            }else{
                basket.add(fruits[high]);
                len = high - low + 1;
                if(len > tempMax)
                    tempMax = len;
                if(high == fruits.length-1)
                    return tempMax;
                high++;
            }
        }
        return tempMax;
    }

    public static void main(String[] args) {
        Solution904 solution904 = new Solution904();
        int[] fruits = new int[]{1,2,2,2,2,2,3,2,2};
        System.out.println(solution904.totalFruit(fruits));
    }
}
