/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = head,now = head;
        while(now != null){
            if(head.val == val){
                head = head.next;
                pre = head;
                now = head;
                continue;
            }
            if(head == now && head == pre && head.val != val){
                 now = now.next;
                 continue;
            }
            if(now.val == val){
                now = now.next;
                pre.next = now;
                continue;
            }
            pre = pre.next;
            now = now.next;
        }

        return head;
    }
    public ListNode removeElements1(ListNode head, int val) {
        ListNode realHead = new ListNode(-1,null);
        ListNode realTail = realHead;
        ListNode now = head;
        while(now != null){
            if(now.val == val)
            {
                now = now.next;
            }else if(now.val != val){
                ListNode realNow = new ListNode(now.val,null);
                realTail.next = realNow;
                realTail = realTail.next;
                now = now.next;
            }
        }
        return realHead.next;
    }

    public static void main(String[] args) {

    }
}
