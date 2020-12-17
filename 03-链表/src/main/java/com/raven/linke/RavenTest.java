package com.raven.linke;


import javax.swing.*;

public class RavenTest {

    public static void main(String[] args) {
        RavenLinkedList<Integer> list = new RavenLinkedList<Integer>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(null);
//        list.set(0, 0);
//        list.add(0, 0);
//        list.clear();
//        System.out.println("args = " + list.isEmpty());
        System.out.println("args = " + list);
        System.out.println("args = " + list);
//        System.out.println("args = " + list.remove(1));

    }

}
