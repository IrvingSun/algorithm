package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

/**
 * @author sunw
 * @date 2023/1/14
 */
public class InvertTree {

    private static TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
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

        System.out.println(root);

        TreeNode result = invertTree(root);

        System.out.println(result);
    }
}
