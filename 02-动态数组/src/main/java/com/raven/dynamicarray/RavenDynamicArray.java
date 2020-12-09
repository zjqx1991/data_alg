package com.raven.dynamicarray;


import java.util.ArrayList;

/**
 * 自定义数组
 */
public class RavenDynamicArray {
    private final Integer DEFAULT_CAPACITY = 10;
    private Integer size = 0;
    private int[] elements;

    public RavenDynamicArray(Integer capacity) {
        capacity = capacity > DEFAULT_CAPACITY ? capacity : DEFAULT_CAPACITY;
        elements = new int[capacity];
    }
    public RavenDynamicArray() {
        this(10);
    }

    /**
     * @return 元素个数
     */
    public int size() {
        return 0;
    }

    /**
     * @return 数组是否为空
     */
    public Boolean isEmpty() {
        return false;
    }

    /**
     * 是否包含某个元素
     */
    public Boolean contains(int element) {
        return false;
    }

    /**
     * 添加元素到最后面
     */
    public void add(int element) {

    }

    /**
     * 返回 index 位置对应的元素
     */
    public int get(int index) {
        return 0;
    }

    /**
     * 设置index位置的元素
     */
    public int set(int index, int element) {
        return 0;
    }

    /**
     * 往 index 位置添加元素
     */
    public void add(int index, int element) {

    }

    /**
     * 删除index位置的元素
     */
    public int remove(int index) {
        return 0;
    }

    /**
     * 查看元素的位置
     */
    public int indexOf(int element) {
        return 0;
    }

    /**
     * 清空所有元素
     */
    public void clear() {

    }
}
