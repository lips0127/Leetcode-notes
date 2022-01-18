import java.util.Stack;

public class Solution206 {
    /*
    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     

    示例 1：


    输入：head = [1,2,3,4,5]
    输出：[5,4,3,2,1]
    示例 2：


    输入：head = [1,2]
    输出：[2,1]
    示例 3：

    输入：head = []
    输出：[]
     

    提示：

    链表中节点的数目范围是 [0, 5000]
    -5000 <= Node.val <= 5000
    进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
    * */
    ListNode realHead = new ListNode(-9999,null);
    ListNode returnHead = new ListNode();
    public ListNode reverseList1(ListNode head) {
        //递归
        if(head == null)
            return null;
        dfs(head);
        return returnHead;
    }
    public void dfs(ListNode now){
        if(now.next == null){
            returnHead = realHead;
            realHead.next = new ListNode(now.val,null);
            realHead = realHead.next;
            return;
        }
        dfs(now.next);
        realHead.next = new ListNode(now.val,null);
        realHead = realHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,null);
        ListNode node2 = new ListNode(2,null);
        ListNode node3 = new ListNode(3,null);
        ListNode node4 = new ListNode(4,null);
        ListNode node5 = new ListNode(5,null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution206 solution206 = new Solution206();
//        ListNode listNode = solution206.reverseList1(node1);
        ListNode listNode = solution206.reverseList2(node1);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    //手动实现一个栈.
    public ListNode reverseList2(ListNode head) {
        //迭代方式
        Stack<ListNode> stack = new Stack<>();
        ListNode returnNode = new ListNode();
        ListNode now = new ListNode();
        returnNode = now;
        while(head != null){
            stack.add(new ListNode(head.val,null));
            head = head.next;
        }
        while(!stack.isEmpty()){
            now.next = stack.pop();
            now = now.next;
        }
        return returnNode.next;
    }
}
