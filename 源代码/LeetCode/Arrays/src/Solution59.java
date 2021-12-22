import java.util.Arrays;

public class Solution59 {
    int[][] used;
    int[][] ans;
    public int[][] generateMatrix(int n) {
        int squareOfInput = (int) Math.pow(n,2);
        used = new int[n][n];
        ans = new int[n][n];
        //使用数组,0表示未使用过，1表示使用
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        //定义一个方向数组标志变量
        int directionIndex = 0;
        int x = 0,y = 0,index = 1;
        //以n等于3为例子，最多记录到9
        while(index <= squareOfInput){
            //记录当前位置为已经更新.
            used[x][y] = 1;
            ans[x][y] = index;
            if(isValid(x+direction[directionIndex][0],y+direction[directionIndex][1])){
                //如果以当前方向状态前进到下一个位置合法，就不需要修改方向状态.
                x += direction[directionIndex][0];
                y += direction[directionIndex][1];
            }else{
                //如果按照当前方向前进到下一个位置不合法，就需要修改方向状态.
                directionIndex = (directionIndex + 1) % 4;
                x += direction[directionIndex][0];
                y += direction[directionIndex][1];
            }
            index++;
        }
        return ans;
    }
    public boolean isValid(int x,int y){
        //对于传递进来的参数，首先判断是否越界，其次判断是否已经被使用过了.
        int xLen = used.length;
        int yLen = used[0].length;
        if((x >= 0 && x< xLen) && (y >= 0 && y < yLen) && used[x][y] == 0)
            return true;//可以使用
        return false;
    }

    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        for (int[] ints : solution59.generateMatrix(5)) {
            System.out.println(Arrays.toString(ints));
        }

    }

}
