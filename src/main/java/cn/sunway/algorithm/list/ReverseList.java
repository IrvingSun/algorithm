package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * @author sunw
 * @date 2023/1/4
 */
public class ReverseList {

    public static ListNode reverse(ListNode head, ListNode tail){
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;

        while (cur != tail){
            next = cur.next; //留存当前节点的 下个节点的记录
            cur.next = pre;//将当前节点的next指向上个节点

            pre = cur; //将pre节点往前挪
            cur = next;//将当前节点往前挪
        }
        //当前节点和尾部节点重合
        //将尾部节点的next指向新的pre节点
        tail.next = pre;
        return tail;
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

        System.out.println(node1);
        System.out.println(reverse(node1, node5));
    }

}
