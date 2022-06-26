import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution51 {
    List<List<String>> ans = new ArrayList<>();
    List<String> t = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] chessboard = new int[n][n];
        dfs(n,chessboard,0,0);
        return ans;
    }
    //形参：皇后数量，开始点位的(x,y)坐标
    public void dfs(int n,int[][] chessboard, int queenNums,int x){//x为直观上的第几层.
        //出口
        if(x == n)
        {
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int j = 0;j<chessboard[x].length;j++){
            //[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
            //上来生成一个String s = "....";
            //哪个成了，就修改那个位置
            String s = generate(n);
            if(isValid(chessboard,x,j)){
                s = s.substring(0,j) + 'Q' + s.substring(j+1,s.length());
                t.add(s);
                chessboard[x][j] = 1;
                dfs(n,chessboard,queenNums+1,x+1);
                chessboard[x][j] = 0;
                t.remove(t.size()-1);
                s = generate(n);
            }
        }
    }
    public boolean isValid(int[][] chessboard,int x,int y){
        //要求，同一行，同一列以及同一个斜线中都不能用皇后存在
        //检查列
        for(int i=0;i<=x;i++){
            if(chessboard[i][y] == 1)
                return false;
        }
        //检查45度
        for(int i=x-1,j=y-1;i>=0 && j>=0;i--,j--){
            if(chessboard[i][j] == 1)
                return false;
        }
        //检查135度
        for(int i=x-1,j=y+1;i>=0&&j<chessboard[i].length;i--,j++){
            if(chessboard[i][j] == 1)
                return false;
        }

        return true;
    }

    public String generate(int n){
        //n只一行生成几个'.'
        String s = new String();
        for(int i=0;i<n;i++){
            s += '.';
        }
        return s;
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        int n = 4;
        List<List<String>> lists = solution51.solveNQueens(n);
        System.out.println(lists);
//        String s = solution51.generate(4);
//        s = s.substring(0,1) + 'Q' + s.substring(1+1,s.length());
//        s = s.substring(0,1) + '.' + s.substring(1+1,s.length());
//        System.out.println(s);
    }

}
