public class Solution52 {
    int count = 0;
    public int totalNQueens(int n) {
        int[][] chessboard = new int[n][n];
        dfs(n,chessboard,0);
        return count;
    }
    public void dfs(int n,int[][] chessboard,int row){
        if(row == n){
            count++;
            return;
        }
        for(int i=0;i<chessboard[row].length;i++){
            if(isValid(chessboard,row,i)){
                chessboard[row][i] = 1;
                dfs(n,chessboard,row+1);
                chessboard[row][i] = 0;
            }
        }
    }
    public boolean isValid(int[][] chessboard,int row,int col){
        //row:行,col:列.
        //检查列
        for(int i=0;i<=row;i++){
            if(chessboard[i][col] == 1){
                return false;
            }
        }
        //检查45度
        for(int i=row-1,j=col+1;i>=0&&j<chessboard[i].length;i--,j++){
            if(chessboard[i][j] == 1)
                return false;
        }
        //检查135度
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(chessboard[i][j] == 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution52 solution52 = new Solution52();
        System.out.println(solution52.totalNQueens(4));
    }

}
