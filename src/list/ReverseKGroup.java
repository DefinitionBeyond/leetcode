package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @create: 2022-06-06 22:09
 **/
public class ReverseKGroup {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int k =2 ;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new ReverseKGroup().reverseKGroup(head, k);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prevHead = newHead;
        ListNode cur = head;

        while (cur != null){
            ListNode tail = prevHead;
            for(int i = 0 ; i < k ; i++){
                tail = tail.next;
                if(tail == null){
                    return newHead.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] listNodes = reverseList(cur, tail);
            cur = listNodes[0];
            tail = listNodes[1];
            prevHead.next = cur;
            tail.next = next;
            prevHead = tail;
            cur = tail.next;
        }
        return newHead.next;
    }

    private ListNode[] reverseList(ListNode head, ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    private boolean checkNeedReverse(ListNode node, int k) {
        int index = 0;
        while (node != null) {
            if (node.next != null) {
                index++;
                if (index == k) {
                    return true;
                }
                node = node.next;
            }
        }
        if (index == k) {
            return true;
        }
        return false;
    }

}
