package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 查找树的最左下角的值
 *
 * @author sunw
 * @date 2023/3/2
 */
public class FindBottomLeftValue {

    /**
     * 使用层序遍历，每次取出第一个值当做ans，最后返回ans
     *
     * @param root
     * @return
     */
    private static int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            int levelSize = list.size();
            ans = list.peek().val;
            while (levelSize-- > 0) {
                TreeNode poll = list.pollFirst();
                if (poll.left != null) {
                    list.addLast(poll.left);
                }
                if (poll.right != null) {
                    list.addLast(poll.right);
                }
            }
        }
        return ans;
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

        System.out.println(findBottomLeftValue(root));
    }
}
