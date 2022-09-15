package tree;

/**
 * @description: 判断是否是对称二叉树
 * @create: 2022-06-10 03:13
 **/
public class IsSymmetric {


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

    //自己和自己比较，看结构
    public boolean isSymmetric(TreeNode root) {
        return judge(root, root);
    }

    private boolean judge(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        //左子树和右子树，结构是否相反
        return a.val == b.val && judge(a.left, b.right) && judge(a.right, b.left);
    }

}
