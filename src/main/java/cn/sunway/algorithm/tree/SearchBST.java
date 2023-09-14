package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

/**
 * 二叉搜索树 查找
 * @author sunw
 * @date 2023/9/14
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode left1 = new TreeNode(1);
        TreeNode left12 = new TreeNode(2);
        left1.right = left12;

        TreeNode right1 = new TreeNode(4);


        root.left = left1;
        root.right = right1;

        System.out.println(new SearchBST().searchBST(root, 4));
    }
}
