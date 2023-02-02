package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 两两交换链表中相邻的节点
 * 输入：[1,2,3,4]
 * 输出：[2,1,4,3]
 * @author sunw
 * @date 2023/2/2
 */
public class SwapPairs {

    /**
     * 注意边界
     * @param head
     * @return
     */
    private static ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null){
            int tmp = fast.data;
            fast.data = slow.data;
            slow.data = tmp;

            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
            slow = slow.next.next;
        }
        return dummy.next;
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
        System.out.println(swapPairs(node1));
    }
}
