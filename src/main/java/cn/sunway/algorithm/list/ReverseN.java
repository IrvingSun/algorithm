package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 *
 * 反转链表前N个节点，并返回新的头节点
 *
 */
public class ReverseN {


    static ListNode breakPointNext = null;
    /**
     * 反转链表的前N个节点
     * @param head
     * @param n
     * @return
     */
    private static ListNode reverseN(ListNode head, int n){
        // 最后一个节点
        if(n == 1){
            breakPointNext = head.next; //找到截断点
            return head;
        }

        ListNode breakPointHead = reverseN(head.next, n - 1); //递归方法

        head.next.next = head;
        head.next = breakPointNext;

        return breakPointHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.addTail(node2);
        node1.addTail(node3);
        node1.addTail(node4);
        node1.addTail(node5);
        node1.addTail(node6);

        System.out.println(reverseN(node1, 3));

    }
}
