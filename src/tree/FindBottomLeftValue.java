package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树最左叶子节点
 * @create: 2022-06-03 00:51
 **/
public class FindBottomLeftValue {

    static class TreeNode {
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

    public int findBottomLeftValue(TreeNode root) {

        if (root == null )return -1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int leftChlidVal = -1;
        while (!queue.isEmpty()) {
            int levelNodeNum = queue.size();
            boolean flag = true;
            for(int i = 0; i < levelNodeNum; i++) {
                TreeNode parentNode = queue.poll();
                if(flag) {
                    leftChlidVal = parentNode.val;
                }
                flag = false;

                if (parentNode.left != null) {
                    queue.add(parentNode.left);
                }
                if (parentNode.right != null) {
                    queue.add(parentNode.right);
                }
            }
        }
        return leftChlidVal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        new FindBottomLeftValue().findBottomLeftValue(root);
    }
}
