package tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @create: 2022-06-06 16:43
 **/
public class LevelOrder {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Queue<TreeNode> queue = new LinkedList<>();

//    public int[] levelOrder(TreeNode root) {
//        if (null == root) {
//            return new LinkedList();
//        }
//        queue.add(root);
//        List<List<Integer>> res = new LinkedList<>();
//        int level = 1;
//        while (!queue.isEmpty()) {
//            int levelChildNum = queue.size();
//            Deque<Integer> levelChild = new LinkedList<>();
//            for (int i = 0; i < levelChildNum; i++) {
//                TreeNode curTree = queue.poll();
//                if (level % 2 == 0) {
//                    levelChild.addFirst(curTree.val);
//                } else {
//                    levelChild.offerLast(curTree.val);
//                }
//                if (curTree.left != null) {
//                    queue.add(curTree.left);
//                }
//                if (curTree.right != null) {
//                    queue.add(curTree.right);
//                }
//            }
//            res.add(levelChild);
//            level++;
//        }
//        return res;
//        int[] resA = new int[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            resA[i] = res.get(i);
//        }
//        return resA;
//    }

}
