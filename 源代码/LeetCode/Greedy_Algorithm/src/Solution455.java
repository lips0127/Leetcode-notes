import java.util.Arrays;

public class Solution455 {
    public static void main(String[] args) {
        Solution455 solution455 = new Solution455();
        int[] g = new int[]{1,2,7,10};
        int[] s = new int[]{1,3,5,9};
        solution455.findContentChildren(g,s);

    }
    public int findContentChildren(int[] g, int[] s) {
        //g是小孩子胃口情况，s是单个饼干大小情况
        int n = s.length;
        int[] used = new int[n];
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length-1;
        for(int i=g.length-1;i>-1;i--){
            if(index >= 0 && s[index] >= g[i]){
                count++;
                index--;
            }
        }
        return count;
    }
}
