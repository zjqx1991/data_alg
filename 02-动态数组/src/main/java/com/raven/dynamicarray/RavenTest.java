package com.raven.dynamicarray;


import java.util.Arrays;

/**
 * 测试数组
 */
public class RavenTest {

    public static void main(String[] args) {
        RavenDynamicArray list = new RavenDynamicArray();

        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

//        System.out.println("args = " + list.set(-1, -1));
//        System.out.println("args = " + list.set(0, 0));
//        System.out.println("args = " + list.set(4, 100));

//        System.out.println("args = " + list);
//        System.out.println("删除数据 = " + list.remove(list.size()-1));
//        System.out.println("args = " + list.indexOf(3));
//        list.clear();
        System.out.println("args = " + list);
        list.add(list.size(), 222);
        System.out.println("args = " + list);
//        System.out.println("args = " + list.contains(11));
//        System.out.println("args = " + list.get(-1));
//        System.out.println("args = " + list.get(1));
//        System.out.println("args = " + list.get(list.size()));
    }

}
