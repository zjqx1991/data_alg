package 二叉树;

import apple.laf.JRSUIUtils;

import javax.swing.plaf.nimbus.State;
import javax.xml.ws.soap.Addressing;
import java.text.ParsePosition;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class _145_二叉树的后序遍历 {


    LinkedList<Integer> list = new LinkedList<Integer>();


    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) return list;
        // 创建栈空间
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 出栈记录
        TreeNode popNode = null;

        while (root != null) {
            // 自己入栈
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.right == null) {
                popNode = stack.pop();
                list.add(popNode.val);
            } else {
                TreeNode node = peek.right;
                if (node == popNode) {
                    popNode = stack.pop();
                    list.add(popNode.val);
                } else {
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                }

            }
        }
        return list;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}
