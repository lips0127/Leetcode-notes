import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution226 {
    /**
     * 代码随想录:https://leetcode-cn.com/problems/invert-binary-tree/
     * 反转二叉树
     * 本质就是交换左右节点.
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        // 递归
        if(root == null)
            return null;
        invertTree(root.left);
        invertTree(root.right);
        //
        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    /**
     * 迭代法-使用BFS层序遍历
     * 每次在树上获取一个结点，就交换其左右结点，并且分别加入队列。
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root){
        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 层次遍历
        TreeNode index;
        queue.add(root);
        while(!queue.isEmpty()){
             index = queue.poll();
             TreeNode temp = new TreeNode();
             if(index.left != null && index.right != null){
                 temp = index.left;
                 index.left = index.right;
                 index.right = temp;
                 queue.add(index.left);
                 queue.add(index.right);
                 continue;
             }
             if(index.left != null && index.right == null) {
                 index.right = index.left;
                 index.left = null;
                 // 左为空.
                 queue.add(index.right);
                 continue;
             }
             if(index.left == null && index.right != null){
                 index.left = index.right;
                 index.right = null;
                 queue.add(index.left);
                 // 右为空
                 continue;
             }
        }
        return root;
    }


}
