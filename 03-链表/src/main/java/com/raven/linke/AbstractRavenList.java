package com.raven.linke;

/**
 * 抽象类
 */
public abstract class AbstractRavenList<E> implements RavenList<E> {
    /**
     * 元素数量
     */
    protected int size = 0;

    /**
     * 越界抛出异常
     */
    protected void indexOutOfBoundsException(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 使用插入方式添加元素时越界抛出异常
     */
    protected void indexOutOfBoundsExceptionOfAdd(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

}
