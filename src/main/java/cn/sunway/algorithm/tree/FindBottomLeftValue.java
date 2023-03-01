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
}
