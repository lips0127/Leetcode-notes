package TestDemo;

import RunDemo.TopK;
import org.junit.Test;

import java.util.ArrayList;

public class TestTopK {
    TopK topK1 = new TopK();
    @Test
    public void testFullSort(){
        int[] testArrays = new int[]{4,6,2,1,8,7,9,5,3};
        int k = 5;
        System.out.println(topK1.bubblePartSort(testArrays, k));
    }

    @Test
    public void testBubblePartSort(){
        int[] testArrays = new int[]{4,6,2,1,8,7,9,5,3};
        int k = 5;
        System.out.println(topK1.fullSortTopK(testArrays, k));
    }

    @Test
    public void testHeapSort(){
        int[] testArrays = new int[]{4,6,2,1,8,7,9,5,3};
        int k = 5;
        System.out.println(topK1.heapSort(testArrays, k));
    }

    @Test
    public void testRs(){
        int[] testArrays = new int[]{4,36,2,31,82,7,9,5,13};
        int k = 5;
        int topKPlace = topK1.randomSelect(testArrays,k,0,testArrays.length-1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = topKPlace; i < testArrays.length; i++) {
            list.add(testArrays[i]);
        }
        System.out.println(list);

    }


}
