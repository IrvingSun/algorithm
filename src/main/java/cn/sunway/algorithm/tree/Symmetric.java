package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

/**
 * 判断一棵树是否为对称二叉树
 * @author sunw
 * @date 2023/1/11
 */
public class Symmetric {

    /**
     * 左子树和右子树进行节点对比
     *
     * @param root
     * @return
     */
    static boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left.val != right.val){
            return false;
        }

       return dsf(left, right);
    }

    /**
     * 使用递归的方式，分别对比左子树和右子树的对应镜像节点，如果不相等，则返回false
     * @param left
     * @param right
     * @return
     */
    private static boolean dsf(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }
        return dsf(left.right, right.left) && dsf(left.left, right.right);
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

        System.out.println(isSymmetric(root));

    }
}
