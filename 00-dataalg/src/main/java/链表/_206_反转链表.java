package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class _206_反转链表 {

    /**
     * 通过递归的方式把链表翻转
     * 思路：
     *      首先要明确reverseList方法的作用及返回的节点是什么
     *      reverseList : 把传入的链表翻转
     *      返回ListNode : 翻转后的列表首节点
     *      a、5->NULL : 无需翻转
     *      b、4->5->NULL : 5->4—>NULL
     *          当前 head = 4
     *          那么 head.next = 5
     *          newHead = head.next
     *          head.next.next = head
     *          head.next = NULL
     *          return newHead (5->4->NULL)
     *      c、3->4->5->NULL : 5->4->3->NULL
     *          想想实现翻转，需要先把3之后的链表翻转过来，其实就是b的结果
     *          newHead = 5->4->NULL
     *          head = 3
     *          head.next = 4
     *          head.next.next = 3 (4->3)(5->4->3)
     *          head.next = NULL (5->4->3->NULL)
     *          return newHead
     *
     *      d、2->3->4->5->NULL : 5->4->3->2->NULL
     *          先要翻转head（2）之后的链表，也就是c的结果
     *          newHead = 5->4->3->NULL
     *          此时
     *          head = 2
     *          head.next = 3
     *          只要把2挂到3后，newHead列表就实现了5->4->3->2
     *          head.next.next = 2
     *          head.next = NULL (5->4->3->2->NULL)
     *          return newHead
     *
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 通过迭代来把链表翻转
     * 思路：
     *
     *      1、先定义一个新的链表 new
     *      2、开始迭代链表，先保存当前节点下一个节点 （next）
     *      3、设置当前节点的next指向 新链表 （node.next->new）
     *      4、重新把新链表执行 当前节点：（new = node）
     *      5、这样完成了当前节点插入到新链表
     *
     *      总结：迭代翻转链表的思路就是，通过迭代依次把节点插入到新的链变的0号位置
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while (null != head) {
            // 1、当前节点next指向的节点
            ListNode nextNode = head.next;
            // 2、当前节点的next指向新链表，到这里已经完成了节点前插
            head.next = newHead;
            // 3、把倒序完成后的链表的第一个节点，重新赋值给新节点
            newHead = head;
            // 4、当前节点的next节点赋值给head节点，用于前插
            head = nextNode;
        }
        return newHead;
    }

}
