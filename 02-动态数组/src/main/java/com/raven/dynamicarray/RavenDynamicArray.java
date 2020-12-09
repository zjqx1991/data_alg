package com.raven.dynamicarray;


/**
 * 自定义数组
 */
public class RavenDynamicArray<E> {
    private final static int DEFAULT_CAPACITY = 10;
    private final static int DEFAULT_NOT_INDEX = -1;
    private int size = 0;
    private E[] elements;

    public RavenDynamicArray(int capacity) {
        capacity = capacity > DEFAULT_CAPACITY ? capacity : DEFAULT_CAPACITY;
        elements = (E[]) new Object[capacity];
    }

    public RavenDynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * @return 元素个数
     */
    public int size() {
        return this.size;
    }

    /**
     * @return 数组是否为空
     */
    public Boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 是否包含某个元素
     */
    public Boolean contains(E element) {
        for (E item : this.elements) {
            // 单独处理 null
            if (null == element) {
                if (element == item) {
                    return true;
                }
            }

            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 添加元素到最后面
     */
    public void add(E element) {
//        this.elements[size] = element;
//        size++;
        this.add(this.size, element);
    }

    /**
     * 返回 index 位置对应的元素
     */
    public E get(int index) {
        this.indexOutOfBoundsException(index);
        return this.elements[index];
    }

    /**
     * 只能修改值，而不能添加
     * 设置index位置的元素
     */
    public E set(int index, E element) {

        this.indexOutOfBoundsException(index);

        E oldElement = this.elements[index];
        this.elements[index] = element;
        return oldElement;
    }

    /**
     * 往 index 位置添加元素
     */
    public void add(int index, E element) {
        this.indexOutOfBoundsExceptionOfAdd(index);

        // 移动数组
        for (int i = this.size; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        // 给 index 位置设值
        this.elements[index] = element;
        // 个数+1
        this.size++;
    }

    /**
     * 删除index位置的元素
     */
    public E remove(int index) {
        this.indexOutOfBoundsException(index);
        E oldElement = this.elements[index];
        // 移动数据
        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;
        return oldElement;
    }

    /**
     * 查看元素的位置
     */
    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            // 单独处理 null 情况
            if (null == element) {
                if (element == this.elements[i]) {
                    return i;
                }
            }
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return DEFAULT_NOT_INDEX;
    }

    /**
     * 清空所有元素
     */
    public void clear() {
        this.size = 0;
    }

    /**
     * 越界抛出异常
     */
    private void indexOutOfBoundsException(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 使用插入方式添加元素时越界抛出异常
     */
    private void indexOutOfBoundsExceptionOfAdd(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("数组个数size = ").append(this.size);
        stringBuilder.append(" ,数组元素 [ ");
        for (int i = 0; i < size; i++) {
            if (0 != i) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append(" ] ");

        return stringBuilder.toString();
    }
}
