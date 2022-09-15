package tree;

/**
 * @description: 合并四叉数
 * @create: 2022-07-15 23:20
 **/
public class Intersect {

    class Node {

        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft,
            Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }


    public Node intersect(Node quadTree1, Node quadTree2) {
        //其中一个是叶子节点，做个合并
        if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                return new Node(true, true, null, null, null, null);
            }
            return new Node(quadTree2.val, quadTree2.isLeaf, quadTree2.topLeft,
                quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
        }
        if (quadTree2.isLeaf) {
            return intersect(quadTree2, quadTree1);
        }

        Node t1 = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node t3 = intersect(quadTree1.topRight, quadTree2.topRight);
        Node t2 = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        Node t4 = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        //都是叶子节点
        if (t1.isLeaf && t2.isLeaf && t3.isLeaf && t4.isLeaf &&
            t1.val == t2.val && t1.val == t3.val && t1.val == t4.val
        ) {
            return new Node(t1.val, true, null, null, null, null);
        }
        return new Node(false, false, t1, t2, t4, t3);

    }


}
