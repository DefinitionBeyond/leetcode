package list;

import java.util.List;

/**
 * @description:
 * @create: 2022-07-04 10:51
 **/
public class RotateRight {

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


    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k < 1)return head;

        int index = 0;

        ListNode fast = head;

        while (fast.next != null){
            ++index;
            fast = fast.next;
        }

        int add = index - k%index;

        if(add == index){
            return head;
        }

        fast.next = head;
        while (add-- > 0){
            fast = fast.next;
        }
        ListNode ans = fast.next;
        fast.next = null;
        return ans;

    }
}
