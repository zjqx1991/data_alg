package com.raven.test;


import com.raven.IRavenBinaryDataSource;
import com.raven.IRavenNodeComparator;
import com.raven.RavenBinarySearchTree;
import com.raven.print.BinaryTrees;
import sun.security.util.AuthResources_pt_BR;

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

        // 层序遍历
        tree.levelOrderDataSource(tree.root(), new IRavenBinaryDataSource() {
            @Override
            public void binaryDataSource(Object data) {
                System.out.println("data = " + data);
            }
        });
        // 层序遍历
//        tree.levelOrderTraversal();
        // 后序遍历
//        tree.postOrderTraversal();
        // 中序遍历
//        tree.inorderTraversal();
        // 前序遍历
//        tree.preorderTraversal();
    }
}
