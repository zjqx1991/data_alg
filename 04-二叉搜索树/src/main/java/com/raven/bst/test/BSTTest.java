package com.raven.bst.test;

import com.raven.bst.RavenBinarySearchTree;
import com.raven.bst.print.BinaryTrees;

import java.util.Arrays;

public class BSTTest {

    static int[] elements = new int[]{7, 4, 9, 2, 5, 8, 11, 3};

    public static void main(String[] args) {
        test2();
    }

    private static void test2() {

        RavenBinarySearchTree<Person> tree = new RavenBinarySearchTree<>(new RavenTestComparator());

        for (int element : elements) {
            tree.add(new Person(element));
        }

        BinaryTrees.print(tree);

        System.out.println("args = " + tree.size());
    }

    private static void test() {
        RavenBinarySearchTree<Integer> tree = new RavenBinarySearchTree<Integer>();

        for (int element : elements) {
            tree.add(element);
        }

        BinaryTrees.print(tree);
    }
}
