package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 寻找链表的中间节点，如果有2个中间节点，则返回第二个中间节点
 *
 * @author sunw
 * @date 2023/1/11
 */
public class MiddleNode {

    /**
     * 快慢指针 快指针往后移动2，慢指针往后移动1
     * 当快指针=null的时候，慢指针刚好来到链表中间部分
     *
     * @param head
     * @return
     */
    static ListNode middle(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
            if(fast == null){
                return slow;
            }
        }
        return slow.next;
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

        System.out.println(middle(node1).data);
    }
}
