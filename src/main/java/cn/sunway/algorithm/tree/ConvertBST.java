package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

/**
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 * 将搜索二叉树转化为累加树
 * @author sunw
 * @date 2023/9/13
 */
public class ConvertBST {

    /**
     * 通过搜索二叉树的特性：
     * 中序遍历(LIR方式)能等到一个升序数组
     * 中序遍历(RIL方式)能等到一个降序数组
     *
     * 从大到小排序之后，每遍历一个节点即累加一次
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        doConvert(root);
        return root;
    }

    public int sum = 0;
    public void doConvert(TreeNode root){
        if(root == null){
            return ;
        }
        doConvert(root.right);
        sum += root.val;

        root.val = sum;
        doConvert(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode left1 = new TreeNode(1);
        TreeNode left12 = new TreeNode(2);
        left1.right = left12;

        TreeNode right1 = new TreeNode(4);


        root.left = left1;
        root.right = right1;


        System.out.println(new ConvertBST().convertBST(root));
    }
}
