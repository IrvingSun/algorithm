package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

/**
 * @author sunw
 * @date 2023/9/6
 */
public class Traverse {

    /**
     * 打印树节点每个元素所在的层数
     * @param root
     * @param level
     */
    public void printLevel(TreeNode root, int level){
        if(root == null){
            return;
        }

        System.out.println(root.val + " 在第 " + level + "层");

        printLevel(root.left, level + 1);
        printLevel(root.right, level + 1);
    }

    /**
     * 打印左右子树分别有多个节点
     * @param root
     */
    public int printCount(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = printCount(root.left);
        int right = printCount(root.right);

        System.out.println(String.format("节点 %s 左子树有%d个节点，右子树有%d个节点", root.val, left, right));

        return left + right + 1;
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

        new Traverse().printLevel(root, 1);
        System.out.println(" =======");
        new Traverse().printCount(root);

    }
}
