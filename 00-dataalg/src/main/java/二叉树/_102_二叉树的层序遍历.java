package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class _102_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (root == null) return lists;
        List<Integer> innerList = new LinkedList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        Integer count = queue.size();

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            innerList.add(node.val);
            count--;

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

            if (count == 0) {
                count = queue.size();
                lists.add(innerList);
                innerList = new LinkedList<Integer>();
            }

        }

        return lists;
    }
}
