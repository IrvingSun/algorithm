package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 删除链表中的元素
 *
 * @author sunw
 * @date 2023/1/13
 */
public class RemoveElement {
    static ListNode removeElement(ListNode head, int val) {
        ListNode pre = new ListNode();
        pre.next = head; //使用虚拟节点，将链表的第一个元素也考虑进去
        ListNode cur = pre;//指针

        while (cur.next != null) {
            if (cur.next.data == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.addTail(node2);
        node1.addTail(node3);
        node1.addTail(node4);
        node1.addTail(node5);
        node1.addTail(node6);

        System.out.println(removeElement(node1, 2));
    }
}
