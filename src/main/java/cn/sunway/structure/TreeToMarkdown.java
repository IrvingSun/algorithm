package cn.sunway.structure;

/**
 * 打印二叉树
 */
public class TreeToMarkdown {

    public static void treePrint(TreeNode root) {
        System.out.println(treeToMarkdown(root));
    }

    public static String treeToMarkdown(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        String left = treeToMarkdown(root.left);
        String right = treeToMarkdown(root.right);

        if (!left.equals("null") || !right.equals("null")) {
            sb.append("\n");
            sb.append("├─ " + left.replace("\n", "\n|  "));
            sb.append("\n");
            sb.append("└─ " + right.replace("\n", "\n   "));
        }

        return sb.toString();
    }
}