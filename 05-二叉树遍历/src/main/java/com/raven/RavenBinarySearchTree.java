package com.raven;


import com.raven.print.BinaryTreeInfo;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import com.sun.xml.internal.messaging.saaj.soap.FastInfosetDataContentHandler;
import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉搜索树
 */
public class RavenBinarySearchTree<E> implements BinaryTreeInfo {
    private int size = 0;
    private RavenNode rootNode = null;
    private IRavenNodeComparator<E> comparator;
    private IRavenBinaryDataSource<E> dataSource;


    /**
     * 无参构造
     */
    public RavenBinarySearchTree() {
        this(null);
    }

    /**
     * 传入比较器构成
     *
     * @param comparator 自定义比较器
     */
    public RavenBinarySearchTree(IRavenNodeComparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * 添加元素
     */
    public void add(E element) {
        // 1、元素为 空 时
        if (0 == this.size) {
            RavenNode<E> node = new RavenNode<E>(element, null);
            this.rootNode = node;
            this.size++;
            return;
        }

        // 2、元素非空 时
        RavenNode<E> node = this.rootNode;
        // 保存父节点
        RavenNode<E> parentNode = this.rootNode;
        // 保存元素比较大小
        int compare = 0;
        //通过比较元素的大小来找到还元素的父节点
        while (null != node) {
            // 判断当前元素与父节点元素大小
            compare = this.compare(node.getElement(), element);
            // 记录父节点
            parentNode = node;
            if (compare > 0) {
                node = node.leftNode;
            } else if (compare < 0) {
                node = node.rightNode;
            } else {

            }
        }

        // 3、把新节点挂载到父节点
        RavenNode<E> newNode = new RavenNode<E>(element, parentNode);
        if (compare > 0) {
            parentNode.leftNode = newNode;
        } else if (compare < 0) {
            parentNode.rightNode = newNode;
        } else {

        }
        this.size++;
    }

    /**
     * 删除元素
     */
    public void remove(E element) {

    }

    /**
     * 是否包含某个元素
     */
    public boolean contains(E element) {
        return true;
    }


    /**
     * 元素的数量
     */
    public int size() {
        return this.size;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return this.size == 0;
    }


    /**
     * 清空所有元素
     */
    public void clear() {

    }

    public Boolean isTree() {

        return isTree(this.rootNode);
    }

    private Boolean isTree(RavenNode rootNode) {
        if (rootNode == null) return false;
        // 记录右子树为 null
        boolean rightNull = false;
        Queue<RavenNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            RavenNode peek = queue.remove();

            // 左子树为null，右子树不为null
            if (peek.leftNode == null && peek.rightNode != null) {
                return false;
            }
            // 右子树为null，接下来的元素只能是 叶子节点
            if (rightNull) {
                if (peek.leftNode != null || peek.rightNode != null) {
                    return false;
                }
            }
            // 标记右子树为 null
            if (peek.rightNode == null) {
                rightNull = true;
            }

            // 左子树入队
            if (peek.leftNode != null) {
                queue.add(peek.leftNode);
            }
            // 右子树入队
            if (peek.rightNode != null) {
                queue.add(peek.rightNode);
            }

        }
        return true;
    }


    /**
     * 二叉树高度
     */
    public int treeHeight() {
//        return treeHeightWithRecursion(this.rootNode);
        return treeHeightWithNonRecursion(this.rootNode);
    }

    /**
     * 递归求 二叉树 高度
     * 树的高度，取决于树的左子树和右子树的高度
     *
     * @param node 节点
     */
    private int treeHeightWithRecursion(RavenNode node) {
        if (node == null) return 0;
        return 1 + Math.max(treeHeightWithRecursion(node.leftNode), treeHeightWithRecursion(node.rightNode));
    }

    /**
     * 非递归方式求二叉树高度
     *
     * @param node
     * @return
     */
    private int treeHeightWithNonRecursion(RavenNode node) {
        if (rootNode == null) return 0;
        int height = 0;
        int rowNum = 1;
        Queue<RavenNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            RavenNode peek = queue.remove();
            if (peek.leftNode != null) {
                queue.add(peek.leftNode);
            }
            if (peek.rightNode != null) {
                queue.add(peek.rightNode);
            }
            rowNum--;
            if (rowNum == 0) {
                // 层数+1
                height++;
                // 重新记录层的元素
                rowNum = queue.size();
            }
        }
        return height;
    }

    /**
     * 层序遍历
     *
     * @param rootNode   根节点
     * @param dataSource 遍历器
     */
    public void levelOrderDataSource(RavenNode rootNode, IRavenBinaryDataSource dataSource) {
        if (rootNode == null) return;
        Queue<RavenNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            RavenNode peek = queue.remove();
            if (peek.leftNode != null) {
                queue.add(peek.leftNode);
            }
            if (peek.rightNode != null) {
                queue.add(peek.rightNode);
            }
            dataSource.binaryDataSource(peek.element);
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrderTraversal() {
        levelOrderTraversal(this.rootNode);
    }


    /**
     * 层序遍历
     */
    private void levelOrderTraversal(RavenNode node) {
        if (node == null) return;
        Queue<RavenNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            RavenNode peek = queue.remove();
            if (peek.leftNode != null) {
                queue.add(peek.leftNode);
            }
            if (peek.rightNode != null) {
                queue.add(peek.rightNode);
            }
            System.out.println(peek.element);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderDataSource(RavenNode node, IRavenBinaryDataSource dataSource) {
        if (node == null) return;
        Stack<RavenNode> stack = new Stack<>();
        RavenNode topNode = null;
        while (null != node) {
            //入栈
            if (topNode == null) {
                stack.push(node);
            } else if (node.element != topNode.element) {
                stack.push(node);
            }
            //左子树
            node = node.leftNode;

            if (node == null && !stack.isEmpty()) {
                RavenNode pop = stack.pop();
                if (pop.rightNode == null) {
                    //自己先显示
                    System.out.println(pop.element);
                    // 下一个出栈
                    pop = stack.pop();
                    if (topNode != null && topNode.element == pop.element) {
                        System.out.println(pop.element);
                        pop = stack.pop();
                    } else {

                    }

                    // 在从新进栈
                    stack.push(pop);
                    topNode = pop;
                    node = pop.rightNode;
                } else {
                    System.out.println(node.element);
                    node = node.rightNode;
                }
            }
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal() {
//        postOrderTraversalWithRecursion(this.rootNode);
        postOrderTraversalWithNonRecursion(this.rootNode);
    }

    /**
     * 后序遍历——递归
     */
    private void postOrderTraversalWithRecursion(RavenNode node) {
        if (node == null) return;
        postOrderTraversalWithRecursion(node.leftNode);
        postOrderTraversalWithRecursion(node.rightNode);
        System.out.println(node.element);
    }

    /**
     * 后序遍历——非递归
     */
    private void postOrderTraversalWithNonRecursion(RavenNode root) {
        if (root == null) return;
        // 创建栈空间
        Stack<RavenNode> stack = new Stack<RavenNode>();
        // 出栈记录
        RavenNode popNode = null;

        while (root != null) {
            // 自己入栈
            stack.push(root);
            root = root.leftNode;
        }

        while (!stack.isEmpty()) {
            RavenNode peek = stack.peek();
            if (peek.rightNode == null) {
                RavenNode pop = stack.pop();
                popNode = pop;
                System.out.println(pop.element);
            } else {
                RavenNode node = peek.rightNode;
                if (node == popNode) {
                    RavenNode pop = stack.pop();
                    popNode = pop;
                    System.out.println(pop.element);
                } else {
                    while (node != null) {
                        stack.push(node);
                        node = node.leftNode;
                    }
                }

            }
        }

    }

    /**
     * 中序遍历
     */
    public void inorderTraversal() {
//        inorderTraversalWithRecursion(this.rootNode);
        inorderTraversalWithNonRecursion(this.rootNode);
    }

    /**
     * 中序遍历-递归
     */
    private void inorderTraversalWithRecursion(RavenNode<E> node) {
        if (node == null) return;
        inorderTraversalWithRecursion(node.leftNode);
        System.out.println(node.element);
        inorderTraversalWithRecursion(node.rightNode);
    }

    /**
     * 中序遍历-非递归
     */
    private void inorderTraversalWithNonRecursion(RavenNode<E> node) {
        if (node == null) return;
        Stack<RavenNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.leftNode;
            if (node == null && !stack.isEmpty()) {
                RavenNode pop = stack.pop();
                System.out.println(pop.element);

                if (pop.rightNode == null && !stack.isEmpty()) {
                    pop = stack.pop();
                    System.out.println(pop.element);
                }
                node = pop.rightNode;
            }
        }
    }

    /**
     * 前序遍历-递归
     */
    public void preorderTraversal() {
        preorderTraversalWithRecursion(this.rootNode);
//        preorderTraversalWithNonRecursion(this.rootNode);
    }

    /**
     * 递归
     */
    private void preorderTraversalWithRecursion(RavenNode<E> node) {
        if (null == node) return;
        System.out.println(node.element);
        // 遍历左子树
        preorderTraversalWithRecursion(node.leftNode);
        // 遍历右子树
        preorderTraversalWithRecursion(node.rightNode);
    }

    /**
     * 非递归
     */
    private void preorderTraversalWithNonRecursion(RavenNode<E> node) {
        if (null == node) return;
        // 创建一个 栈空间
        Stack<RavenNode> stack = new Stack<>();

        while (null != node) {
            System.out.println(node.element);
            // 右子树入栈
            if (null != node.rightNode) {
                stack.push(node.rightNode);
            }
            // 重复遍历左子树
            node = node.leftNode;

            if (node == null && !stack.isEmpty()) {
                node = stack.pop();
            }
        }
    }

    /**
     * 比较元素值的大小
     */
    private int compare(E parent, E element) {
        // 自己实现二叉树元素大小比较
        if (this.comparator != null) {
            return this.comparator.comparaTo(parent, element);
        }
        // 自己没有实现二叉树元素大小比较，强制元素是
        return ((Comparable) parent).compareTo(element);
    }

    /**
     * 传入的数据不能是 null
     */
    private void elementNotNullCheck(E element) {
        if (null == element) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public RavenNode root() {
        return this.rootNode;
    }

    @Override
    public RavenNode left(Object node) {
        return ((RavenNode) node).leftNode;
    }

    @Override
    public RavenNode right(Object node) {
        return ((RavenNode) node).rightNode;
    }

    @Override
    public Object string(Object node) {
        return ((RavenNode) node).element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        tostring(sb, this.rootNode, "");
        return sb.toString();
    }

    /**
     * 拼接输出
     */
    private void tostring(StringBuilder sb, RavenNode node, String prefix) {
        if (node == null) return;
        //拼接根
        sb.append(prefix);
        sb.append("{ ");
        sb.append(node.element);
        sb.append(" }");
        sb.append("\n");
        // 左子树
        tostring(sb, node.leftNode, prefix + " -L- ");
        // 右子树
        tostring(sb, node.rightNode, prefix + " -R- ");
    }

    /**
     * 内部类
     */
    class RavenNode<E> {
        E element;
        RavenNode parentNode;
        RavenNode leftNode;
        RavenNode rightNode;

        public RavenNode(E element, RavenNode parentNode) {
            this.element = element;
            this.parentNode = parentNode;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }

}
