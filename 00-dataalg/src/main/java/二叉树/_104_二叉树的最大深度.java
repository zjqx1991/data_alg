package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class _104_二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) return  0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int height = 0;
        int size = queue.size();

        while (!queue.isEmpty()) {
            root = queue.remove();
            size--;
            if (root.left != null) {
                queue.add(root.left);
            }

            if (root.right != null) {
                queue.add(root.right);
            }

            if (size == 0) {
                size = queue.size();
                height++;
            }

        }

        return height;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return  0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
