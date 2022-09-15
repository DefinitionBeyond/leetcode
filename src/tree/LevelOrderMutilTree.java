package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description:
 * @create: 2022-06-21 17:11
 **/
public class LevelOrderMutilTree {

    static class TreeNode {

        int val;
        List<TreeNode> child = new ArrayList<>();

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, List<TreeNode> child) {
            this.val = val;
            this.child = child;
        }
    }

    static class Row {
        int val;
        int parent;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }
    }

    public TreeNode buildTree(List<Row> list){
        if(list == null || list.size() == 0)return null;
        Map<Integer, List<Row>> collect = list.stream().collect(
            Collectors.groupingBy(Row::getParent));
        
        TreeNode root = new TreeNode(list.get(0).val);
        for (Row row : list) {
            TreeNode parent = findParent(row.val, root);
            List<TreeNode> childs = collect.get(row.val).stream().map(it -> {
                return new TreeNode(it.getVal());
            }).collect(
                Collectors.toList());
            if(parent == null) {
                root.child.add(new TreeNode(row.val));
            }else {
                parent.child.add(new TreeNode(row.val));
            }
        }
        return root;
    }

    private TreeNode findParent(int val, TreeNode root){
        if (root == null )return null;
        Map<Integer, List<TreeNode>> answer = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode parentNode = queue.poll();
            if(parentNode.val == val) return parentNode;
            if(parentNode.child.size() > 0){
                for (TreeNode treeNode : parentNode.child) {
                    queue.add(treeNode);
                }
            }
        }
        return null;
    }



    public Map<Integer, List<TreeNode>> levelOrder(TreeNode root){
        if (root == null )return new HashMap<>();
        Map<Integer, List<TreeNode>> answer = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int levelDeep = 1;
        while (!queue.isEmpty()) {
            int levelNodeNum = queue.size();
            List<TreeNode> level = new LinkedList<>();
            for(int i = 0; i < levelNodeNum; i++) {
                TreeNode parentNode = queue.poll();
                if(parentNode != null) {
                    level.add(parentNode);
                }
                if(parentNode.child.size() > 0){
                    for (TreeNode treeNode : parentNode.child) {
                        queue.add(treeNode);
                    }
                }

            }
            answer.put(levelDeep, level);
            levelDeep++;

        }
        return answer;
    }

}
