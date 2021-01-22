package com.raven.linke;

public interface RavenList<E> {

    final static int DEFAULT_CAPACITY = 10;
    final static int DEFAULT_NOT_INDEX = -1;

    /**
     * @return 元素个数
     */
    int size();

    /**
     * @return 数组是否为空
     */
    Boolean isEmpty();

    /**
     * 是否包含某个元素
     */
    Boolean contains(E element);

    /**
     * 添加元素到最后面
     */
    void add(E element);

    /**
     * 返回 index 位置对应的元素
     */
    E get(int index);

    /**
     * 只能修改值，而不能添加
     * 设置index位置的元素
     */
    E set(int index, E element);

    /**
     * 往 index 位置添加元素
     */
    void add(int index, E element);

    /**
     * 删除index位置的元素
     */
    E remove(int index);

    /**
     * 查看元素的位置
     */
    int indexOf(E element);

    /**
     * 清空所有元素
     */
    void clear();
}
