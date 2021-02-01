package 二叉树;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {

    /**
     * 非递归
     */
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode peek = queue.remove();
            if (peek.left != null) {
                queue.add(peek.left);
            }
            if (peek.right != null) {
                queue.add(peek.right);
            }

            // 交换左右节点
            TreeNode temp = peek.left;
            peek.left = peek.right;
            peek.right = temp;
        }
        return root;
    }

    /**
     * 递归
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

}
