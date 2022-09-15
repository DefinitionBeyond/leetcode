package list;

import java.util.Stack;

/**
 * @description: 逆序打印链表
 * 思路： 栈的先进后出特性
 *
 * @create: 2022-06-02 23:47
*/
public class ReversePrint {
    private Stack<Integer> stack = new Stack<>();
    public int[] reversePrint(ListNode head) {
        if (null == head){
            return null;
        }
        int size = 0;
        while ( head != null){
            stack.push(head.val);
            head = head.next;
            size++;
        }
        int[] res = new int[size];
        int index = 0;
        while (!stack.isEmpty()){
            res[index++] = stack.pop();
        }
        return res;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        int[] ints = new ReversePrint().reversePrint(head);
        System.out.println(ints[0]);

    }
    static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
}
