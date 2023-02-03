package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 旋转链表(向右)
 *
 * 1-2-3-4-5
 * 旋转1次：5-1-2-3-4
 *
 * @author sunw
 * @date 2023/1/9
 */
public class RotateRightList {

    private static ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null || k == 0){
            return head;
        }

        int count  = 1;
        ListNode tail = head;
        while(tail.next != null){
            count ++;
            tail = tail.next;
        }

        int mod = k % count;
        int index = count - mod; //计算出新的头结点位置

        if(index == 0){
            return head;
        }

        /**
         * 将尾部指向原来的头结点  5 -> 1 2 3 4 5
         *                      |
         *                      tail
         *
         *  此时 链表已经在5的位置形成了环
         */
        tail.next = head;

        while(index-- > 0){
            tail = tail.next;
        }
        /**
         * 5  1  2  3  4  5
         *             |
         *            tail
         */

        /**
         * 找到新的头结点
         *
         * 5  1  2  3  4  5
         *
         *            result
         */
        ListNode result = tail.next;//找到新的头结点

        //修剪
        /**
         * 4  5  1  2  3 -> NULL
         * |
         * result
         */
        tail.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.addTail(node2);
        node1.addTail(node3);
        node1.addTail(node4);
        node1.addTail(node5);
        System.out.println(rotateRight(node1, 2));
    }

}
