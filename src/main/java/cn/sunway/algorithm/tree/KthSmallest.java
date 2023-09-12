package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;
import cn.sunway.structure.TreeToMarkdown;

/**
 * 获取搜索树中的第K小的数
 *
 * @author sunw
 * @date 2023/9/12
 */
public class KthSmallest {

    int res = Integer.MIN_VALUE;
    int rank = 0;

    /**
     * 由于搜索二叉树的中序遍历 = 数组的升序排序
     * 所以可以增加一个变量来记录结果
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        travel(root, k);
        return res;
    }

    public void travel(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        travel(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        travel(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode left1 = new TreeNode(1);
        TreeNode left12 = new TreeNode(2);
        left1.right = left12;

        TreeNode right1 = new TreeNode(4);


        root.left = left1;
        root.right = right1;

        TreeToMarkdown.treePrint(root);
        System.out.println(new KthSmallest().kthSmallest(root, 1));

    }

}
