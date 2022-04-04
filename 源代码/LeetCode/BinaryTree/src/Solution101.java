import java.util.ArrayList;
import java.util.List;

public class Solution101 {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     *  
     *
     * 提示：
     *
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    List<TreeNode> list = new ArrayList<>();
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return cmp(root.left,root.right);
    }
    public boolean cmp(TreeNode left,TreeNode right) {
        if(left == null && right == null)
            return true;
        if(left == null || right == null || left.val != right.val)
            return false;
        // 为什么明明没有写对比left和right的val值，也能够遍历呢?
        // 答：因为此种情况会被递归到最深处，也就是说即便左右都相等了，也应该一直往下，到null == null!
        // 以上是该题的灵魂
        return cmp(left.left,right.right) && cmp(left.right,right.left);
    }
    // 迭代法
    public boolean isSymmetric1(TreeNode root){
        return false;
    }
}
