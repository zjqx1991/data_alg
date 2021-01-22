package com.raven.bst;

/**
 * 二叉搜索树
 */
public class RavenBinarySearchTree<E> {
    private int size = 0;
    private RavenNode rootNode = null;


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
            switch (compare) {
                case 1:{
                    node = node.leftNode;
                }
                case -1: {
                    node = node.rightNode;
                }
                default:
            }
        }

        // 3、把新节点挂载到父节点
        RavenNode<E> newNode = new RavenNode<E>(element, parentNode);
        switch (compare) {
            case 1:
                parentNode.rightNode = newNode;
            case -1:
                parentNode.leftNode = newNode;
            default:
        }

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
     * 比较元素值的大小
     */
    private int compare(E parent, E element) {
//        parentNode
        return 0;
    }

    /**
     * 传入的数据不能是 null
     */
    private void elementNotNullCheck(E element) {
        if (null == element) {
            throw new IllegalArgumentException();
        }
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
