package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 前序遍历树
 *
 * @author sunw
 * @date 2023/2/14
 */
public class PreOrderTraversal {

    /**
     * 使用递归的方式
     *
     * @param root
     * @return
     */
    private List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        } else {
            ret.add(root.val);
        }
        ret.addAll(preOrderTraversal(root.left));
        ret.addAll(preOrderTraversal(root.right));

        return ret;
    }

    /**
     * 使用遍历的方式
     * 栈
     *
     * @param root
     * @return
     */
    private List<Integer> loopPreOrderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            ret.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return ret;
    }
}
