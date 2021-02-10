package com.raven.test;


import com.raven.IRavenBinaryDataSource;
import com.raven.IRavenNodeComparator;
import com.raven.RavenBinarySearchTree;
import com.raven.print.BinaryTrees;

public class BSTTest {

//    static int[] elements = new int[]{7};
//    static int[] elements = new int[]{9, 11, 10, 12};
//    static int[] elements = new int[]{4, 2, 1, 3};
    static int[] elements = new int[]{7, 4, 9, 2, 11, 1, 3, 10, 12};
    static int[] elements11 = new int[]{7, 4, 9, 2, 5, 8, 11, 3, 10};
    static int[] elements3 = new int[]{7, 4, 9, 2, 5};
    static int[] elements4 = new int[]{7, 4, 9, 2, 5, 8};
    static int[] elements5 = new int[]{7, 4, 9, 2, 5, 8, 1};
    static int[] elements6 = new int[]{7, 4, 9, 8, 1};
    static int[] elements7 = new int[]{7, 9, 8, 1};
    static int[] elements8 = new int[]{7, 4, 9, 2, 5, 8, 11, 1, 3, 10, 12};
    static int[] elements9 = new int[]{8, 4, 13, 2, 6, 10, 1, 3, 5, 7, 9, 12, 11};
    static int[] elements10 = new int[]{4, 1, 8, 2, 7, 10, 3, 5, 9, 11, 6};

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

        // 打印二叉树
        BinaryTrees.print(tree);
        tree.remove(11);
//        tree.remove(9);
//        tree.remove(8);
//        tree.remove(10);
        System.out.println();
        System.out.println();
        System.out.println();
        BinaryTrees.print(tree);
//        tree.predecessorTest(tree.root());
//        tree.successorTest(tree.root());
//        int height = tree.treeHeight();
//        System.out.println("真二叉树===" + tree.isTree());

        // 层序遍历
//        tree.levelOrderDataSource(tree.root(), new IRavenBinaryDataSource() {
//            @Override
//            public void binaryDataSource(Object data) {
//                System.out.println("data = " + data);
//            }
//        });
        // 层序遍历
//        tree.levelOrderTraversal();
        // 后序遍历
//        tree.postOrderTraversal();
        // 中序遍历
//        tree.inorderTraversal();
        // 前序遍历
//        tree.preorderTraversal();
//        System.out.println(tree);
    }
}
