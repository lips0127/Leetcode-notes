
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution93 {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s.length() >12 )
            return ans;
        dfs(s,0,0);
        return ans;
    }
    public void dfs(String s,int start,int pointNum){
        if(pointNum == 3){
            if(isvaild(s,start,s.length()-1))
                ans.add(s);
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isvaild(s,start,i)){
                s = s.substring(0,i+1)+"."+s.substring(i+1);
                pointNum++;
                dfs(s,i+2,pointNum);//// 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pointNum--;
                s = s.substring(0,i+1)+s.substring(i+2);
            }else{
                break;
            }
        }
    }
    public boolean isvaild(String s,int start,int end){
        if(start > end || end-start>2)
            return false;
        if(start != end && s.charAt(start) == '0'){//如果判断的字符串长度不为1，但是第一个位置是0，说明有问题
            return false;
        }
        int nums = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            nums = nums * 10 + (s.charAt(i) - '0');
            if (nums > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }

    public boolean isvaild1(String s,int start,int end){
        if(start > end || end-start > 2)
            return false;
        if(start != end && s.charAt(start) == '0'){//如果判断的字符串长度不为1，但是第一个位置是0，说明有问题
            return false;
        }
        int nums = 0;
        for(int i=end;i>=start;i--) {

            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
            nums += (s.charAt(i) - '0') * Math.pow(10,(end-start-i));//bug就是end-start这里
            if (nums > 255){
                System.out.println("false_nums:" + nums);
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        solution93.isvaild1("511",7,9);
    }

}
