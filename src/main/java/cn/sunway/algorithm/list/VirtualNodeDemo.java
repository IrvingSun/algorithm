package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * @author sunw
 * @date 2023/1/6
 */
public class VirtualNodeDemo {

    /**
     * System.out.println(ans.next); 输出：[1] --> [2] --> [3] --> [4] --> [5] -->NULL
     *
     * 需要理解「链表的指针」和「基本指针」的区别
     *
     * ans.next = head;
     * 指的是ans的next属性 指针 指向head指向的ListNode对象
     * 解释为：ans.next = ListNode(1);
     *
     * 同理 head属性的指针指向，其实已经和ans没有关系了
     * 只要不改动ListNode(1)的结构，就不会影响ans
     *
     * 如果此时 执行 head.next = null；
     * 则ans的next也将受到影响
     *
     *
     *
     */
    static void q1(){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.addTail(node2);
        head.addTail(node3);
        head.addTail(node4);
        head.addTail(node5);

        ListNode ans = new ListNode(100);
        ans.next = head;
        head = head.next;
        head = head.next;

        System.out.println(ans.next);
        System.out.println(head);

        head.next = null;
        System.out.println(ans.next);
    }

    public static void main(String[] args) {
        q1();
    }


}
