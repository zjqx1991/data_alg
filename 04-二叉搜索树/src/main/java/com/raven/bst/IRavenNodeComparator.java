package com.raven.bst;

/**
 * 自定义二叉树元素大小比较
 */
public interface IRavenNodeComparator<E> {
    int comparaTo(E e1, E e2);
}
