package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LargestValues {

//    public void BinaryTreeLevelOrder(TreeNode<Integer> rootNode) {
//        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
//        queue.add(rootNode);
//        while (!queue.isEmpty()) {
//            TreeNode<Integer> parentNode = queue.poll();
//            System.out.print(parentNode.val + " ");
//            if (parentNode.left != null) {
//                queue.add(parentNode.left);
//            }
//            if (parentNode.right != null) {
//                queue.add(parentNode.right);
//            }
//        }
//    }



      
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> answer = new ArrayList<>();
        if (root == null )return answer;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curLevelMax = Integer.MIN_VALUE;
            int levelNodeNum = queue.size();
            for(int i = 0; i < levelNodeNum; i++) {
                TreeNode parentNode = queue.poll();
                if(parentNode != null) {
                    curLevelMax = Math.max(parentNode.val, curLevelMax);
                }
                if (parentNode.left != null) {
                    queue.add(parentNode.left);
                }
                if (parentNode.right != null) {
                    queue.add(parentNode.right);
                }
            }
            answer.add(curLevelMax);
        }
        return answer;
    }
//
//    class TreeNode<E> {
//        E val;
//        TreeNode left;
//        TreeNode right;
//
//        public TreeNode(E val) {
//            this.val = val;
//            this.left = null;
//            this.right = null;
//        }
//    }

}
