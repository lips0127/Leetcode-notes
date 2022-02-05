import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12)
            return ans;
        dfs(s,0,0);
        return ans;
    }
    public void dfs(String s,int start,int pointNum){
        //出口
        if(isValid(s,start,s.length()-1) && pointNum == 3){
            ans.add(s);
            return;
        }
        //剪枝
        for(int i=start;i<s.length();i++){
            if(isValid(s,start,i)){
//                s = s.substring(0,i+1) + '.' + s.substring(i+1);
                dfs(s.substring(0,i+1) + '.' + s.substring(i+1),i+2,pointNum+1);// 插⼊逗点之后下⼀个⼦串的起始位置为i+2

//                s = s.substring(0,i+1) + s.substring(i+2);
            }
            else
                break;
        }
    }
    public boolean isValid(String s,int start,int end){
        if((start < end && s.charAt(start) == '0') || start > end)
            return false;
        int sum = 0;
        for(int i=start;i<=end;i++){
            sum = sum*10 + (s.charAt(i) - '0');
            if(sum > 255)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "1018261119";
        Solution93 solution93 = new Solution93();
        System.out.println(solution93.restoreIpAddresses(s));
    }
}
