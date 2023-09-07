package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

/**
 * 将二叉树 转变为单向树
 * @author sunw
 * @date 2023/9/7
 */
public class FlattenTree {

    static TreeNode dummy = new TreeNode();
    TreeNode pointer = dummy;

    void flat(TreeNode root){
        if(root == null) return;
        pointer.right = new TreeNode(root.val);
        pointer = pointer.right;

        flat(root.left);
        flat(root.right);
    }

    /**
     * 使用后序遍历的方式，将树原地转换成只有右节点的树
     * @param root
     */
    void flatten(TreeNode root){
        if(root == null) return;

        //左子树，右子树都拉平了
        flatten(root.left);
        flatten(root.right);

        // 暂存拉平的左子树和右子树
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 将左子树衔接到父节点的右边
        root.left = null;
        root.right = left;

        //找到右子树拼接点，拼接到原左子树的结尾
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
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

        new FlattenTree().flat(root);
        System.out.println(dummy.right);

        new FlattenTree().flatten(root);
        System.out.println(root);
    }

}
