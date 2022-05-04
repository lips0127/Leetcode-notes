package Hot100;

import model.ListNode;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode();
        ListNode FirstNode = preNode;
        int carrys = 0;
        while(true){
            if(l1 == null && l2 == null && carrys == 0){
                break;
            }
            int l1Val = 0,l2Val = 0;
            if(l1 != null){
                l1Val = l1.val;
            }
            if(l2 != null){
                l2Val = l2.val;
            }
            ListNode thisNode = new ListNode();
            thisNode.val = (l1Val + l2Val + carrys) % 10;
            System.out.println("thisNode.val:" + thisNode.val);
            if(l1Val + l2Val + carrys >= 10){
                carrys = (l1Val + l2Val + carrys) / 10;
            }else{
                carrys = 0;
            }
            preNode.next = thisNode;
            preNode = thisNode;
            if(l1 != null && l1.next != null){
                l1 = l1.next;
            }else{
                l1 = null;
            }
            if(l2 != null && l2.next != null){
                l2 = l2.next;
            }else{
                l2 = null;
            }
        }
        return FirstNode.next;
    }

    public static void main(String[] args) {
        ListNode list1Node3 = new ListNode(3,null);
        ListNode list1Node2 = new ListNode(4,list1Node3);
        ListNode list1Node1 = new ListNode(2,list1Node2);

        ListNode l2Node5 = new ListNode(6,null);
        ListNode l2Node4 = new ListNode(9,l2Node5);
        ListNode l2Node3 = new ListNode(4,l2Node4);
        ListNode l2Node2 = new ListNode(6,l2Node3);
        ListNode l2Node1 = new ListNode(5,l2Node2);


        Solution2 solution2 = new Solution2();
        ListNode listNode = solution2.addTwoNumbers(list1Node1, l2Node1);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
}
