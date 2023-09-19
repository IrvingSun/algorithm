package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

/**
 * 计算一棵二叉树中最大值
 * @author sunw
 * @date 2023/9/19
 */
public class MaxValue {

    public int maxValue(TreeNode root){
        if(root == null){
            return -1;
        }
        return Math.max(root.val, Math.max(maxValue(root.left), maxValue(root.right)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left1 = new TreeNode(2);
        TreeNode left11 = new TreeNode(4);
        TreeNode left12 = new TreeNode(3);
        left1.left = left11;
        left1.right = left12;

        TreeNode right1 = new TreeNode(2);
        TreeNode right11 = new TreeNode(3);
        TreeNode right12 = new TreeNode(4);
        right1.left = right11;
        right1.right = right12;
        right12.right = new TreeNode(1);

        root.left = left1;
        root.right = right1;

        System.out.println(new MaxValue().maxValue(root));
    }
}
