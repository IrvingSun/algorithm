package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

import java.util.LinkedList;

/**
 * 计算树的最大深度
 * @author sunw
 * @date 2023/1/11
 */
public class MaxTreeDepth {

    /**
     * 使用递归的方式
     * 深度优先 DFS
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


    /**
     * 广度优先方式遍历，一层一层遍历，直至遍历到最后一层
     * @param root
     * @return
     */
    public static int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);

        while (!list.isEmpty()) {
            int size = list.size(); // 记录当前列表大小
            //当size被耗尽，则进入下一轮(其实当前列表中的数据可能大于0)
            while (size > 0) {
                TreeNode treeNode = list.pop();
                size--;
                if (treeNode != null) {
                    if (treeNode.left != null) {
                        list.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        list.offer(treeNode.right);
                    }
                }
            }
            level++;
        }
        return level;
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
        System.out.println(bfs(root));
    }

}
