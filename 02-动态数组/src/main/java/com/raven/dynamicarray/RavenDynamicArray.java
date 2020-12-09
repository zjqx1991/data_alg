package com.raven.dynamicarray;


/**
 * 自定义数组
 */
public class RavenDynamicArray {
    private final Integer DEFAULT_CAPACITY = 10;
    private final Integer DEFAULT_NOT_INDEX = -1;
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
    public Boolean contains(int element) {
        for (int item : this.elements) {
            if (item == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * 添加元素到最后面
     */
    public void add(int element) {
//        this.elements[size] = element;
//        size++;
        this.add(this.size, element);
    }

    /**
     * 返回 index 位置对应的元素
     */
    public int get(int index) {
        this.indexOutOfBoundsException(index);
        return this.elements[index];
    }

    /**
     * 只能修改值，而不能添加
     * 设置index位置的元素
     */
    public int set(int index, int element) {

        this.indexOutOfBoundsException(index);

        int oldElement = this.elements[index];
        this.elements[index] = element;
        return oldElement;
    }

    /**
     * 往 index 位置添加元素
     */
    public void add(int index, int element) {
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
    public int remove(int index) {
        this.indexOutOfBoundsException(index);
        int oldElement = this.elements[index];
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
    public int indexOf(int element) {
        for (int i = 0; i < this.size; i++) {
            if (element == this.elements[i]) {
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
