package Hot100;

import java.util.Arrays;

public class Solution4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int[] fusionStage = new int[nums1.length + nums2.length];
         int index1 = 0,index2 = 0,fusionIndex = 0;
         while(true){
             if(index1 == nums1.length && index2 == nums2.length){
                 break;
             }
             if(index1 == nums1.length){
                 while(index2 < nums2.length){
                     fusionStage[fusionIndex] = nums2[index2];
                     index2++;
                     fusionIndex++;
                 }
                 continue;
             }
             if(index2 == nums2.length){
                 while(index1 < nums1.length){
                     fusionStage[fusionIndex] = nums1[index1];
                     index1++;
                     fusionIndex++;
                 }
                 continue;
             }
             if(nums1[index1] <= nums2[index2]){
                 fusionStage[fusionIndex] = nums1[index1];
                 index1++;
                 fusionIndex++;
                 continue;
             }
             if (nums1[index1] > nums2[index2]) {
                 fusionStage[fusionIndex] = nums2[index2];
                 index2++;
                 fusionIndex++;
                 continue;
             }
         }
        String s = Arrays.toString(fusionStage);
        System.out.println(s);
        if(fusionStage.length % 2 == 0){
            double ans = (double)((fusionStage[fusionStage.length/2] + fusionStage[fusionStage.length/2-1]));
            return ans/2;
        }else{
            return fusionStage[fusionStage.length/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,5,6,7,8};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
