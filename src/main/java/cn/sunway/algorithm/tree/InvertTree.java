package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

/**
 * 翻转二叉树
 * @author sunw
 * @date 2023/1/14
 */
public class InvertTree {

    /**
     * 使用递归的方式修改二叉树
     * @param root
     * @return
     */
    private static TreeNode invertTree(TreeNode root){
        //如果到了尾结点，则
        if(root == null){
            return null;
        }
        //交换root的左右两个节点
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        //递归交换
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
