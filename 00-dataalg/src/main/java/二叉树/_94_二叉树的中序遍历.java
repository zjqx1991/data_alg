package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历 {

    LinkedList<Integer> list = new LinkedList<Integer>();

    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) return list;

        // 创建栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 节点入栈
        while (root != null) {
            stack.push(root);
            // 先遍历左子树
            root = root.left;

            if (root == null && !stack.isEmpty()) {
                // 获取栈顶
                root = stack.pop();
                list.add(root.val);
                // 如果没有右子树，继续获取栈顶
                if (root.right == null && !stack.isEmpty()) {
                    root = stack.pop();
                    list.add(root.val);
                }
                root = root.right;
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
