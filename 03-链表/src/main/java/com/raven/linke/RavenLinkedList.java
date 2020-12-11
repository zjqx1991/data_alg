package com.raven.linke;

/**
 * 自定义链表
 */
public class RavenLinkedList<E> extends AbstractRavenList<E> {
    private Node<E> first;

    private class Node<E> {
        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return 0 == size;
    }

    public Boolean contains(E element) {
        Node<E> node = first;
        while (null != node) {
            if (null == element) {
                if (null == node.element) {
                    return true;
                }
            } else {
                if (node.element != null && node.element.equals(element)) {
                    return true;
                }
            }
            node = node.next;
        }
        return false;
    }

    public void add(E element) {
        add(size, element);
    }

    public E get(int index) {
        Node<E> node = getNode(index);
        return node.element;
    }

    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    public void add(int index, E element) {
        // 第一次添加
        if (0 == index) {
            // 创建新 Node
            first = new Node<E>(element, first);
        } else {
            // 获取 index 前面的节点
            Node<E> prev = getNode(index - 1);
            // 创建新 Node
            Node<E> newNode = new Node<E>(element, prev.next);
            prev.next = newNode;
        }
        size++;
    }

    public E remove(int index) {
        Node<E> deleteNode = first;
        if (0 == index) {
            first = deleteNode.next;
        }
        else {
            Node<E> prev = getNode(index - 1);
            deleteNode = prev.next;
            prev.next = deleteNode.next;
        }
        size--;
        return deleteNode.element;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            Node<E> currentNode = getNode(i);
            if (null == element) {
                if (null == currentNode.element) {
                    return i;
                }
            } else {
                if (currentNode.element.equals(element)) {
                    return i;
                }
            }
        }
        return DEFAULT_NOT_INDEX;
    }

    public void clear() {
        first.next = null;
        first = null;
        size = 0;
    }

    /**
     * 获取 index 位置的 Node
     *
     * @param index 下标位置
     * @return
     */
    private Node<E> getNode(int index) {
        if (0 == index) {
            return first;
        }
        indexOutOfBoundsException(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("链表元素个数size = ").append(size);
        stringBuilder.append(" ,链表元素 [ ");
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (0 != i) {
                stringBuilder.append(", ");
            }
            if (null != node) {
                stringBuilder.append(node.element);
                node = node.next;
            }
        }

        stringBuilder.append(" ] ");

        return stringBuilder.toString();
    }
}
