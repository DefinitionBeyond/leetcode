package list;

/**
 * @description:
 * @create: 2022-06-13 10:47
 **/
public class DeleteNode {

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

    public ListNode deleteNode(ListNode head, int val) {
        if(head == null ) return null;
        ListNode cur = head;
        ListNode prev = head;
        //头节点
        if(head.val == val){
            head = head.next;
        }
        while (cur != null){
            if(cur.val == val) {
                if(cur.next != null) {
                    ListNode temp = cur.next;
                    cur.next = null;
                    prev.next = null;
                    prev.next = temp;
                }else {
                    prev.next = null;
                }
            }
            prev = cur;
            if(null != cur) {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new DeleteNode().deleteNode(head, 5);
        System.out.println("OK");
    }
}
