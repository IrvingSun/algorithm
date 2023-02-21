package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 将链表中下标为奇数的节点和偶数的节点分开
 *
 * 1->2->3->4->5
 *
 * 1->3->5->2->4
 *
 *
 * @author sunw
 * @date 2023/2/22
 */
public class OddEvenList {

    private static ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode evenHead = head.next;
        ListNode oddList = head;
        ListNode evenList = evenHead;

        while(evenList != null && evenList.next != null){
            oddList.next = evenList.next;
            oddList = oddList.next;
            evenList.next = oddList.next;
            evenList = evenList.next;
        }
        oddList.next = evenHead;
        return  head;
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

        System.out.println(node1);
        System.out.println(oddEvenList(node1));
    }
}
