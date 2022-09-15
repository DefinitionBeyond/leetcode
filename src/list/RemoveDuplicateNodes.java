package list;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 移除重复节点
 * @create: 2022-07-28 19:32
 **/
public class RemoveDuplicateNodes {

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

    private Set<Integer> nums = new HashSet();
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode cur = head;
        nums.add(head.val);
        while(cur != null){
            if(null != cur.next && nums.contains(cur.next.val)){
                ListNode next = cur.next;
                if(next == null){
                    cur.next = null;
                    return head;
                }
                cur.next = null;
                cur.next = next.next;
            }else {
                cur = cur.next;
            }

            if(cur!=null)
            nums.add(cur.val);
        }
        return head;
    }

    private void removeNext(ListNode head){
        ListNode next = head.next;
        if(next == null){
            head.next = null;
        }
        head.next = null;
        head.next = next.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        ListNode listNode = new RemoveDuplicateNodes().removeDuplicateNodes(head);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
