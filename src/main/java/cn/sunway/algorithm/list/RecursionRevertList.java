package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 用递归的方式反转链表
 * @author sunw
 * @date 2023/2/9
 */
public class RecursionRevertList {

    /**
     * 假定head.next部分都已经反转，只需要重新整理首尾节点
     * 当递归到最后一个节点的时候，返回
     *
     * @param head
     * @return
     */
    private static ListNode reverseAll(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode last  = reverseAll(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 找到最后一个节点的next。作为反转区间部分的next
     */
    static ListNode next = null;
    private static ListNode reverseFromHead(ListNode head, int end){
        if(end == 1){
            next = head.next;
            return head;
        }
        ListNode last = reverseFromHead(head.next, end -1);
        System.out.println("@ "+last);
        head.next.next = head;
        head.next = next;
        return last;
    }

    /**
     * 将head往第m个位置上靠拢，使用reverseFromHead反转
     * @param head
     * @param start
     * @param end
     * @return
     */
    private static ListNode reverseBetween(ListNode head, int start, int end){
        if(start == 1){
            return reverseFromHead(head, end);
        }
        head.next = reverseBetween(head.next, start-1, end -1);
        System.out.println("$ "+head);
        return head;
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
//        System.out.println(reverseAll(node1));
//        System.out.println(reverseFromHead(node1, 3));
        System.out.println(reverseBetween(node1, 3,5));
    }

}
