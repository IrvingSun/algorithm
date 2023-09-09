package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;
import cn.sunway.structure.TreeToMarkdown;

/**
 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:

 创建一个根节点，其值为 nums 中的最大值。
 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 返回 nums 构建的 最大二叉树 。
 * @author sunw
 * @date 2023/9/9
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = constructSubTree(nums, 0, nums.length - 1);
        return root;
    }

    /**
     * 找到最大值，设置为节点值，然后遍历前后区间，直到遍历到边界
     * @param nums
     * @param from
     * @param end
     * @return
     */
    public TreeNode constructSubTree(int[] nums, int from, int end) {
        int rootIndex = maxIndex(nums, from , end);
        if(rootIndex == -1){
            return null;
        }
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = constructSubTree(nums, from, rootIndex - 1);
        root.right = constructSubTree(nums, rootIndex + 1, end);
        return root;
    }

    private int maxIndex(int[] nums, int from, int end){
        if(from < 0 || end > nums.length -1){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int targetIndex = -1;
        for(int i = from; i <= end; i++){
            if(nums[i] > max){
                max = nums[i];
                targetIndex = i;
            }
        }
        return targetIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        TreeNode root = new ConstructMaximumBinaryTree().constructMaximumBinaryTree(nums);
        System.out.println(root);
        System.out.println(TreeToMarkdown.treeToMarkdown(root));
    }
}
