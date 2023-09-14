package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

/**
 * 校验二叉树是否为搜索二叉树
 * @author sunw
 * @date 2023/9/14
 */
public class ValidBST {

    /**
     * 搜索二叉树：左子树比根节点小，右子树比根节点大
     * 但是这种方法的缺点在于，它只关注了根节点和它的左右节点，并不能确定他的子节点和根节点的关系
     * 例如：
     *      10 <---
     *    /   \
     *   5     15
     *        /  \
     *  ---> 6    20
     *
     * 它并不是二叉搜索树，但是它能通过代码检查
     *
     * @param root
     * @return
     */
    @Deprecated
    public boolean isValidBST_(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left != null && root.left.val >= root.val){
            return false;
        }
        if(root.right != null && root.right.val <= root.val){
            return false;
        }
        return isValidBST_(root.left) && isValidBST_(root.right);
    }

    public boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }

    /**
     * 将root节点传递进入子树的遍历逻辑
     * @param min
     * @param max
     * @return
     */
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;

        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        TreeNode left1 = new TreeNode(1);
        TreeNode left12 = new TreeNode(2);
        left1.right = left12;

        TreeNode right1 = new TreeNode(4);


        root.left = left1;
        root.right = right1;

        System.out.println(new ValidBST().isValidBST(root));
    }
}
