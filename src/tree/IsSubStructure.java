package tree;

/**
 * @description:
 * @create: 2022-06-08 17:17
 **/
public class IsSubStructure {


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


    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }
        if (b == null) {
            return false;
        }


        //左子树，或者右子树
        return judge(a, b)|| isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }

    private boolean judge(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        //看左右孩子是否相同
        return judge(a.left, b.left) && judge(a.right, b.right);
    }
}
