package com.raven;


import com.raven.print.BinaryTreeInfo;
import sun.security.util.AuthResources_pt_BR;

import javax.xml.soap.Node;

/**
 * 二叉搜索树
 */
public class RavenBinarySearchTree<E> implements BinaryTreeInfo {
    private int size = 0;
    private RavenNode rootNode = null;
    private IRavenNodeComparator<E> comparator;


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


    /**
     * 前序遍历
     */
    public void preorderTraversal() {
        preorderTraversal(this.rootNode);
    }

    private void preorderTraversal(RavenNode<E> node) {
        if (null == node) return;
        System.out.println(node.element);
        // 遍历左子树
        preorderTraversal(node.leftNode);
        // 遍历右子树
        preorderTraversal(node.rightNode);
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
    public Object root() {
        return this.rootNode;
    }

    @Override
    public Object left(Object node) {
        return ((RavenNode) node).leftNode;
    }

    @Override
    public Object right(Object node) {
        return ((RavenNode) node).rightNode;
    }

    @Override
    public Object string(Object node) {
        return ((RavenNode) node).element;
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
