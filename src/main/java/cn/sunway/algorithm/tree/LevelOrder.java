package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，按层级输出每层的值列表
 *
 * @author sunw
 * @date 2023/2/13
 */
public class LevelOrder {


    /**
     * 使用队列，
     * 父节点先入队
     * 父节点出队
     * 子节点入队
     * 直至队列为空
     *
     * @param root
     * @return
     */
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> list = new LinkedList<>();

        list.offer(root);

        while (!list.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            // 每层只取每层所有的节点，不会取到下层的数据
            int levelSize = list.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = list.poll();
                currentLevel.add(temp.val);

                if (temp.left != null) {
                    list.offer(temp.left);
                }
                if (temp.right != null) {
                    list.offer(temp.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
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
        System.out.println(levelOrder(root));

    }
}
