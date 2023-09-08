package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个满二叉树，将同一层的左右节点给链接起来
 *
 * @author sunw
 * @date 2023/9/8
 */
public class ConnectTree {

    /**
     * 按层遍历树，每层每个节点指向下一个节点，最后一个节点指向NULL
      */
    public void connect(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> list = new LinkedList<>();
        list.offer(root);

        while (!list.isEmpty()) {
            List<TreeNode> currentLevel = new ArrayList<>();
            int levelSize = list.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = list.poll();
                currentLevel.add(temp);

                if (temp.left != null) {
                    list.offer(temp.left);
                }
                if (temp.right != null) {
                    list.offer(temp.right);
                }
            }

            for (int i = 0; i < currentLevel.size() - 1; i++) {
                currentLevel.get(i).next = currentLevel.get(i + 1);
            }
        }

    }


    /**
     * 一个节点node的子节点中：左节点的next指向右节点，
     * 右节点的next指向node的next的左节点
     * @param treeNode
     */
    public TreeNode connect2(TreeNode treeNode){
        dsf(treeNode, null);
        return treeNode;
    }

    public void dsf(TreeNode node, TreeNode next){
        if(node != null){
            node.next = next;
            dsf(node.left, node.right);
            dsf(node.right, node.next != null ? node.next.left : null);
        }
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


        root.left = left1;
        root.right = right1;

        new ConnectTree().connect(root);
        System.out.println(root);

        new ConnectTree().connect2(root);
        System.out.println(root);
    }

}
