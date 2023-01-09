package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 虚拟节点和指针
 * @author sunw
 * @date 2023/1/9
 */
public class ListNodeCur {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode dummy = new ListNode();
        dummy.next = node1;
        System.out.println(dummy);//[0] --> [1] -->NULL
        dummy = dummy.next;
        System.out.println(dummy);//[1] -->NULL

        dummy = new ListNode();
        /**
         * cur和dummy  同时指向一个空node
         */
        ListNode cur = dummy;
        cur.next = node1;//将空node的next节点设置为node1
        System.out.println(dummy);//[0] --> [1] -->NULL
        cur = cur.next; //将cur指向空node的下一个节点

        cur.next = node2; //设置node1的next节点为node2，此时dummy节点并未改变
        cur = cur.next;
        System.out.println(dummy);//[0] --> [1] --> [2] -->NULL
    }
}
