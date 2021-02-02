package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历 {


    LinkedList<Integer> list = new LinkedList<Integer>();

    /**
     * 非递归
     *
     * @param root 节点
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) return list;
        // 创建队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode peek = queue.poll();
            list.add(peek.val);

            if (peek.left != null) {
                queue.offer(peek.left);
            }

            if (peek.right != null) {
                queue.offer(peek.right);
            }
        }

        return list;
    }

    /**
     * 递归
     *
     * @param root 节点
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return list;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

}
