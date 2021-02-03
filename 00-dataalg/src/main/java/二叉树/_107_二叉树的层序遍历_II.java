package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class _107_二叉树的层序遍历_II {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

            if (node.right != null) {
                queue.add(node.right);
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (count == 0) {
                count = queue.size();
                lists.add(0, innerList);
                innerList = new LinkedList<Integer>();
            }

        }

        return lists;
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {

        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (root == null) return lists;

        List<Integer> innerList = new LinkedList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        queue.add(root);
        Integer count = queue.size();

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            stack.push(node);
            count--;

            if (node.right != null) {
                queue.add(node.right);
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (count == 0) {
                count = queue.size();
                stack.push(new TreeNode(-101010));
            }

        }


        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.val == -101010) {
                innerList = new LinkedList<Integer>();
                lists.add(innerList);
            }
            else {
                innerList.add(pop.val);
            }
        }

        return lists;
    }

}
