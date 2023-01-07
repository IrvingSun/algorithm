package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 删除倒数第N个节点
 * @author sunw
 * @date 2023/1/7
 *
 *
 */
public class DeleteNthFromEnd {

    /**
     * 双指针方式处理
     * @param head
     * @param n
     *
     * [1, 2, 3, 4, 5, 6]
     *  |     |
     *  S     F
     *  将两个指针拉开N个距离，然后同时往后遍历，如果F=null
     *  则当时S指向的节点，就是需要删除的节点
     *
     * [1, 2, 3, 4, 5, 6] null
     *              |      |
     *              S      F
     *
     * 但由于无法获取S的上一个节点，可以增加一个虚拟节点
     * 并且将S-F之间的距离变成N+1
     * 此时需要删除的节点就是S的下一个节点
     *
     * [V， 1, 2, 3, 4, 5, 6]
     *  |        |
     *  S        F
     *
     * [V，1, 2, 3, 4, 5, 6] null
     *              |        |
     *              S        F
     */
    public static void deleteNthFromEnd(ListNode head, int n){
        if(n < 1){
            return ;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        //先拉开距离
        for(int i = 0; i < n+1; i++){
            fast = fast.next;
        }

        //往后移动
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        System.out.println(dummy.next);

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(node1);
        deleteNthFromEnd(node1,1);
    }


}
