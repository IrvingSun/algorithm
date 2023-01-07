package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 判断是否有环
 * @author sunw
 * @date 2023/1/6
 */
public class ListCycle {

    /**
     * 判断是否有环
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null){
            // 快指针
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                fast = null;
            }
            // 慢指针
            slow = slow.next;

            if(fast == slow){ //单个节点的时候不能判定为有环
                return slow != null;
            }
        }
        return false;
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
//        node5.next = node3;
        System.out.println(hasCycle(node5));

    }

}
