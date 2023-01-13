package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * @author sunw
 * @date 2023/1/4
 */
public class ReverseList {

    /**
     * 提供首尾节点  将链表首尾节点之间的节点反转
     * @param head
     * @param tail
     * @return
     */
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

    /**
     * 提供首尾节点，以及结尾节点 反转链表
     *
     * @param head
     * @param tail
     * @param terminal
     * @return
     */
    public static ListNode reverse2(ListNode head, ListNode tail, ListNode terminal){
        ListNode cur = head;
        ListNode pre = null;

        while (cur != terminal){
            ListNode next = cur.next; //留存当前节点的 下个节点的记录
            cur.next = pre;//将当前节点的next指向上个节点

            pre = cur; //将pre节点往前挪
            cur = next;//将当前节点往前挪
        }

        return tail;
    }

    /**
     * 提供首节点，反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverse3(ListNode head){
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            //保存现场
            ListNode next = cur.next;

            //设置当前节点的指针
            cur.next = pre;

            //挪动遍历节点
            pre = cur;
            cur = next;
        }
        return pre;//遍历的最后一个非null节点
    }


    /**
     * 递归方式
     * @param head
     * @return
     */
    public static ListNode loopReverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = loopReverse(head.next); //假设下个节点已经反转完
        /**
         * head
         * |
         * 1 -> 2 -> 3 -> 4 -> 5
         *
         * 1 -> 2 <- 3 <- 4 <- 5 <- temp
         *
         * 此时只需要设置节点2的指针
         * null <- 1 <- 2 <- 3 <- 4 <- 5 <- temp
         * 
         */
        ListNode t1 = head.next;
        t1.next = head;
        head.next = null;
        return temp;
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
//        System.out.println(reverse(node1, node5));
//        System.out.println(reverse2(node1, node5, null));
//        System.out.println(reverse3(node1));
        System.out.println(loopReverse(node1));
    }

}
