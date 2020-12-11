package 链表;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *
 */
public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        // 让下一个节点的值覆盖当前节点的值
        node.val = node.next.val;
        // 让当前节点的next 指向 下一个节点的next
        node.next = node.next.next;
    }

}
