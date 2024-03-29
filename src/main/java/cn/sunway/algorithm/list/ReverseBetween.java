package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 *给你单链表的头指针 head 和两个整数 left 和 right ，
 * 其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，
 * 返回 反转后的链表 。
 * @author sunw
 * @date 2023/2/9
 */
public class ReverseBetween {

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

    /**
     * 反转区间
     * @param head
     * @param left
     * @param right
     * @return
     */
    private static ListNode reverseBetween(ListNode head, int left, int right){
       if(left == 1){
           return reverseN(head, right);
       }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
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

        System.out.println(reverseBetween(node1, 2,5));

    }
}
