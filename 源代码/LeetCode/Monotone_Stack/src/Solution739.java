import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;

import java.util.Arrays;
import java.util.Stack;
/*
请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。

示例 1:

输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
示例 2:

输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
示例 3:

输入: temperatures = [30,60,90]
输出: [1,1,0]
 

提示：

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100

* */
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        // 单调栈
        int i = 0;
        while(i < temperatures.length || !stack.isEmpty()){
            if(stack.isEmpty() ||  temperatures[stack.peek()] >= temperatures[i]){
                stack.push(i);
                if(i == temperatures.length-1)
                    break;
                i++;
            }
            else if(temperatures[stack.peek()] < temperatures[i]){
                int index = stack.pop();//实际上弹出的是下标
                ans[index] = i - index;
            }
            //处理i已经结束，但stack仍然有的情况.(修改：实际上，stack本身维护是一个数组中所有单调递减的元素的下标)
            // 此时刻，事实上stack中的每个位置的下标都表示了该位置无法找到一个比该位置大的元素)
        }
//        while(!stack.isEmpty()){
//            int index = stack.pop();//实际上弹出的是下标
//            ans[index] = i - index;
//        }
//        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static void main(String[] args) {
//        int[] temperatures = new int[]{34,30,29,33};
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
//        int[] temperatures = new int[]{30,40,50,60};
        Solution739 solution739 = new Solution739();
        solution739.dailyTemperatures(temperatures);
    }
}
