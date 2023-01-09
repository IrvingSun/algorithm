package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 *
 * 「走到路的尽头发现没有你，于是走你来时的路，相遇时才发现你也在走我来时的路」
 *
 *  ac + bc = bc + ac
 *  (a+b)+2c
 *
 * @author sunw
 * @date 2023/1/9
 */
public class ListIntersection {

    public static int intersection(ListNode headA, ListNode headB){

        ListNode l1 = headA;
        ListNode l2 = headB;

        /**
         * 相交：ac + bc = bc + ac
         * 不相交：ab + cd = cd + ab
         */
        while(l1 != l2){
            l1 = l1 != null ? l1.next : headB;
            l2 = l2 != null ? l2.next : headA;
        }
        return l1 == null ? 0 : l1.data;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode node6 = new ListNode(11);
        ListNode node7 = new ListNode(22);

        node1.addTail(node2);
        node1.addTail(node3);
        node1.addTail(node4);
        node1.addTail(node5);

        node6.addTail(node7);
        node7.next = node3;

        System.out.println(intersection(node1, node6));
    }
}
