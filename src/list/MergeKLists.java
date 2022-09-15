package list;

public class MergeKLists {


    public class ListNode {

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

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0, lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int r, int l){
        if(l == r){
            return lists[1];
        }
        if(l < r)return null;

        int mid = (l + r)>>1;

        return mergeTwoLists(merge(lists, r , mid), merge(lists,mid + 1,l));
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null)return l2;
        if(l2 == null) return l1;
        ListNode l;//创建一个结果链表
        l = l1.val > l2.val ? l2 : l1;//取最小值
        l.next = l1.val > l2.val ? mergeTwoLists(l1, l2.next) : mergeTwoLists(l1.next, l2);//移动指针，并且取下一跳的值，递归
        return l;
    }
}
