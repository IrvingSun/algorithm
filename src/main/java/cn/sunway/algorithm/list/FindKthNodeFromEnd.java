package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 寻找链表的倒数第K个节点
 */
public class FindKthNodeFromEnd {

    /**
     * 快慢指针 快指针往后移动K
     * 慢指针接着和快指针一同移动到末尾，此时慢指针指向的就是倒数第K个节点
     *
     * @param head
     * @return
     */
    static ListNode kth(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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

        System.out.println(kth(node1, 3).data);
    }
}
