package cn.sunway.structure;

/**
 * 树节点
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;//指向下一个节点

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        if (left == null && right == null) {
            return String.format("[ %d ]", val);
        }
        return String.format("[ %d : %s, %s]", val, left, right);
    }
}