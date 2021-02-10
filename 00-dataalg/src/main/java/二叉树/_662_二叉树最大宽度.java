package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class _662_二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        List<List<TreeNode>> lists = new LinkedList<List<TreeNode>>();
        if (root == null) return 0;
        List<TreeNode> innerList = new LinkedList<TreeNode>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        Integer count = queue.size();

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            innerList.add(node);
            count--;

            if (node != null) {
                queue.add(node.left);
            }

            if (node != null) {
                queue.add(node.right);
            }


            if (count == 0) {
                count = queue.size();
                lists.add(innerList);
                innerList = new LinkedList<TreeNode>();
            }

        }

        int size = 0;
        for (List<TreeNode> list : lists) {
            int size1 = list.size();
            if (size1 > size) {
                size = size1;
            }
        }

        return size;
    }
}
