package list;

/**
 * @description: 找两条链表的交点
 *
 * 思路：
 *  相交元素为 c个
 *  A 不相交元素a个
 *  B 不相交元素b个
 *
 *  A 路径 a + c + b
 *  B 路径 b + c + a
 *  这样，A，B 会同时到达交点
 *  A，B不相交，两遍之后，同时到达链表尾Null
 *
 *
 * @create: 2022-06-13 11:08
 **/
public class GetIntersectionNode {

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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
