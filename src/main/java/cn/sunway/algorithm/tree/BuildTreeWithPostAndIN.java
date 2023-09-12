package cn.sunway.algorithm.tree;

import cn.sunway.structure.TreeNode;
import cn.sunway.structure.TreeToMarkdown;

import java.util.HashMap;
import java.util.Map;

/**
 * 从后序和中序遍历  构造二叉树
 * @author sunw
 * @date 2023/9/12
 *
 * 例如：postorder = [9,15,7,20,3], inorder = [9,3,15,20,7]
 * 输出：[3,9,20,null,null,15,7]
 *      3
 *    /   \
 *   9     20
 *        /  \
 *       15   7
 * 和之前ConstructMaximumBinaryTree类似，
 * ☆如果能找到根节点，然后从左子树、右子树上分别找到根节点，就能构造出这棵树
 * 从树和遍历结果可以发现，由于遍历方式不一样，导致根节点所在的位置不一样
 *
 *                      根节点
 *                        |
 * postorder = [9,15,7,20,3]
 *              = -------
 *             左   右子树
 *------------------------------|
 *
 *            左  右子树
 *            -   =======
 * inorder = [9,3,15,20,7]
 *              |
 *              根节点
 *-----------------------------|
 *
 * 从上面的分析可以看出：
 * 后序遍历，很容易确定根节点(子树区间的最后一个位置)，但是无法确定左右子树的边界
 * 中序遍历，很容易确定左右子树的边界，但是无法确定根节点位置
 * <p>
 * 所以这两个条件，就可以提供构造树的所有条件，需要计算左右子树和根节点的位置，即可
 */
public class BuildTreeWithPostAndIN {

    /**
     * 由于假设树的节点上的值是唯一的，所以可以用map进行记录位置
     *
     * @param inorder
     * @return
     */
    Map<Integer, Integer> inorderMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }

    Map<Integer, Integer> inorderLocation = null;
    /**
     * 通过前序和中序遍历结果 反向构造出对应的二叉树
     *
     * @param postorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderLocation = inorderMap(inorder);
        return build(postorder, 0 , postorder.length - 1,
                inorder, 0,inorder.length - 1);
    }


    /**
     * 构造左子树、右子树
     * @param postorder
     * @param postFrom
     * @param postEnd
     * @param inorder
     * @param inFrom
     * @param inEnd
     * @return
     */
    public TreeNode build(int[] postorder, int postFrom, int postEnd,
                          int[] inorder, int inFrom, int inEnd) {

        if(postFrom > postEnd){
            return null;
        }
        // root节点就是后序遍历的最后一个节点
        int rootVal = postorder[postEnd];

        // root节点在中序遍历中的位置，根据这个位置，可以计算出左子树和右子树分别的边界
        int rootIndex = inorderLocation.get(rootVal);

        int leftSize = rootIndex - inFrom;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(postorder, postFrom, postFrom + leftSize - 1,
                inorder, inFrom, rootIndex - 1);
        root.right = build(postorder, postFrom + leftSize , postEnd - 1,
                inorder, rootIndex + 1, inEnd);

        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new BuildTreeWithPostAndIN().buildTree(new int[]{9,15,7,20,3}, new int[]{9,3,15,20,7});
        TreeToMarkdown.treePrint(root);
    }
}
