package RunDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {
    /**
     * RunDemo.TopK，不难；其思路优化过程，不简单：
     *
     * 全局排序，O(n*lg(n))
     *
     * 局部排序，只排序TopK个数，O(n*k)
     *
     * 堆，TopK个数也不排序了，O(n*lg(k))
     *
     * 分治法，每个分支“都要”递归，例如：快速排序，O(n*lg(n))
     *
     * 减治法，“只要”递归一个分支，例如：二分查找O(lg(n))，随机选择O(n)
     *
     * TopK的另一个解法：随机选择+partition
     *
     * 知其然，知其所以然。
     *
     * 思路比结论重要。
     *
     * 希望大家对TopK有新的认识。
     * 这里直接要求返回一个收集完topk的list，从左到右递增吧
     */

    // 1.全局排序
    public List<Integer> fullSortTopK(int[] nums, int k){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        while(k > 0){
            list.add(nums[nums.length - k]);
            k--;
        }
        return list;
    }

    // 2.局部排序-冒泡排序，每次冒泡最大的数字到前面
    public List<Integer> bubblePartSort(int[] nums, int k){
        List<Integer> list = new ArrayList<>();
        // 循环k轮次，每次将最大的数字放到数组头部
        for (int i = 0; i < k; i++) {
            for (int j = i; j < nums.length; j++) {
                if(nums[j] > nums[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        int count = 0;
        for(Integer i:nums){
            if(count == 5){
                break;
            }
            list.add(i);
            count++;
        }
        return list;
    }
    // 3.堆排序（小顶堆每次将最小的数字移动到堆顶，如果超过了k个元素，就去替换堆顶元素）
    public List<Integer> heapSort(int[] nums, int k){
        PriorityQueue<Integer> prQueue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if(prQueue.size() < k){
                prQueue.add(nums[i]);
                continue;
            }
            if(nums[i] > prQueue.peek()){
                prQueue.poll();
                prQueue.add(nums[i]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!prQueue.isEmpty()){
            ans.add(prQueue.poll());
        }
        return ans;
    }

    // 4.随机选择+partition（预热环节手写快排和二分查找.....）
    // 具体原理：快排一轮会将所有大于基准元素的元素放到基准元素右侧，小于基准元素的放到基准元素左侧。
    // 但是我们并不知道第k大的基准元素在哪里，所以需要在一开始先去寻找到第k大元素
    public int partition(int[] arr, int low, int high){
        int benchmark = arr[low];
        while(low < high){
            while(low < high && arr[high] >= benchmark){
                high--;
            }
            arr[low] = arr[high];
            while(low < high && arr[low] <= benchmark){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = benchmark;
         return low;
    }


    public int randomSelect(int[] testArrays,int k,int low,int high){
        if(high == low)
            return 0;
        int i = partition(testArrays,low,testArrays.length-1);
        // 计算右侧的个数
        int rightLength = high - i;
        if(rightLength == k){
            return i+1;
        }
        if(rightLength > k){
            return randomSelect(testArrays,k,i+1,high);
        }
        else
            return randomSelect(testArrays,k-rightLength,0,i-1);
    }

}

