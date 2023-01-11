package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

/**
 * 计算树的最大深度
 * @author sunw
 * @date 2023/1/11
 */
public class MaxTreeDepth {

    /**
     * 使用递归的方式
     * @param root
     * @return
     */

    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left != null || root.right != null){
            return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
        }
        return 1;
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
//        right12.right = new TreeNode(1);

        root.left = left1;
        root.right = right1;

        System.out.println(maxDepth(root));
    }

}
