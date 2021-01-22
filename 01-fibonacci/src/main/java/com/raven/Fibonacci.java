package com.raven;

/**
 * 斐波那契数列
 * 下标：0、1、2、3、4、5、6、7、  8、 9、...、40、... n
 * 数值：0、1、1、2、3、5、8、13、21、34     、102334155
 */
public class Fibonacci {
    public static void main(String[] args) {
        Integer n = 50;
        long startTime = System.currentTimeMillis();
//        Integer integer = fibonacci1(n);
        Integer integer = fibonacci3(n);
        long endTime = System.currentTimeMillis();
        long tiem = endTime - startTime;
        System.out.println("下标为 " + n + "的数据为：" + integer + " 用时：" + tiem);
    }

    /**
     * 斐波那契数列（算法一）
     * @param index 下标位置
     * @return index 位置的数值
     * 下标：0、1、2、3、4、5、6、7、  8、 9、.... n
     * 数值：0、1、1、2、3、5、8、13、21、34
     */
    private static Integer fibonacci1(Integer index) {
        if (index < 2) {
            return index;
        }
        // 使用递归求和
        return fibonacci1(index - 1) + fibonacci1(index - 2);
    }

    /**
     * 斐波那契数列（算法二）
     * @param index 下标位置
     * @return index 位置的数值
     * 下标：0、1、2、3、4、5、6、7、  8、 9、.... n
     * 数值：0、1、1、2、3、5、8、13、21、34
     */
    private static Integer fibonacci2(Integer index) {
        Integer first = 0;
        Integer second = 1;
        if (index < 2) {
            return index;
        }
        /**
         * 求index位置上的数值，其实就是求 index-1 和 index-2 位置上的数值之和
         *
         * 所以可以通过遍历来实现
         */
        Integer sum = 0;
        for (int i = 1; i < index; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    /**
     * 斐波那契数列（算法二）
     * @param index 下标位置
     * @return index 位置的数值
     * 下标：0、1、2、3、4、5、6、7、  8、 9、.... n
     * 数值：0、1、1、2、3、5、8、13、21、34
     */
    private static Integer fibonacci3(Integer index) {
        Integer first = 0;
        Integer second = 1;
        if (index < 2) {
            return index;
        }
        /**
         * 求index位置上的数值，其实就是求 index-1 和 index-2 位置上的数值之和
         *
         * 所以可以通过遍历来实现
         */
        for (int i = 1; i < index; i++) {
            second += first;
            first = second - first;
        }
        return second;
    }
}
