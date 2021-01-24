package com.raven.test;


import com.raven.IRavenNodeComparator;
import com.raven.RavenBinarySearchTree;
import com.raven.print.BinaryTrees;

public class BSTTest {

    static int[] elements = new int[]{7, 4, 9, 2, 5, 8, 11, 1, 3, 10, 12};

    public static void main(String[] args) {
        test();
    }

    private static void test2() {

        RavenBinarySearchTree<Person> tree = new RavenBinarySearchTree<>((IRavenNodeComparator<Person>) new RavenTestComparator());

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

        tree.preorderTraversal();
    }
}
