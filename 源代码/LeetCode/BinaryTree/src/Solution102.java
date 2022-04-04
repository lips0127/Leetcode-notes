import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    /**
     * 层序遍历
     * 引入一个队列来支撑层序遍历：
     * 如果根节点为空，无可遍历
     * 如果根节点不为空
     *  先将根节点入队
     *  只要队列不空
     *      出队首结点，并遍历
     *      如果队首结点有左孩子，左孩子入队
     *      如果队首结点有右孩子，右孩子入队
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return null;
        // 用于存放树上结点的链表队列(先进先出)
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        // 存放某一层的所有遍历结果.
        List<Integer> levelValueList = new ArrayList<>();
        // 存放各层遍历结果
        List<List<Integer>> ansTreeNodeList = new ArrayList<>();
        // 第一层只有一个结点
        treeNodeQueue.add(root);
        // 准备一个列表存放某层的所有结点
        Queue<TreeNode> levelNode = new LinkedList<>();
        while(!treeNodeQueue.isEmpty()){
            TreeNode poll = treeNodeQueue.poll();
            levelNode.add(poll);
            levelValueList.add(root.val);
            // 满足立马队列就空
            if(treeNodeQueue.isEmpty()){
                while(!levelNode.isEmpty()){
                    TreeNode poll1 = levelNode.poll();
                    if(poll1.left != null)
                        treeNodeQueue.add(poll1.left);
                    if(poll1.right != null)
                        treeNodeQueue.add(poll1.right);
                }
                ansTreeNodeList.add(new ArrayList<>(levelValueList));
                levelValueList.clear();
                continue;
            }
            else{// 不立马就空，说明该层还有结点
                levelNode.add(poll);
            }
        }
        return ansTreeNodeList;
    }
}
