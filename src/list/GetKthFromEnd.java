package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 获取倒数几个节点的链表
 * @create: 2022-06-13 11:01
 **/
public class GetKthFromEnd {

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        if(k < 0)return head;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        int size = 0;
        while(cur!= null){
            map.put(++size, cur);
            cur = cur.next;
        }

        if(k > size)return head;
        return map.get(size - k + 1);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode kthFromEnd = new GetKthFromEnd().getKthFromEnd(head, 1);
        System.out.println("OK");

    }

}
