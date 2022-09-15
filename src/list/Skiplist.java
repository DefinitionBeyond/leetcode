//package list;
//
//import java.util.Random;
//
///**
// * @description:
// * @create: 2022-07-26 20:53
// **/
//public class Skiplist {
//
//    static class ListNode {
//
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
//
//    private ListNode[] level = new ListNode[5];
//
//    public Skiplist() {
//
//    }
//
//    public boolean search(int target) {
//
//    }
//
//    public void add(int num) {
//        int curLevel = getLevel();
//
//        for(int i = 0; i < level.length ; i++){
//            ListNode head = level[i];
//            if(head == null && i == 0){
//                level[i] = new ListNode(num);
//            }
//            if(curLevel > i){
//                break;
//            }
//
//        }
//    }
//
//    public boolean erase(int num) {
//
//    }
//
//    private int getLevel(){
//        Random random = new Random();
//        return random.nextInt(4);
//    }
//}
