package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 删除有序链表中的重复元素
 * [-100, 100]
 *
 * @author sunw
 * @date 2023/1/5
 */
public class DeleteDuplicatedItem {

    static ListNode deleteDuplicated(ListNode head) {
        ListNode temp = new ListNode(); //虚拟节点
        ListNode cur = temp;//游标指针
        int val = -101; //对比数值
        while (head != null) { //遍历链表
            if (val != head.data) { //如果当前节点的值，不等于对比值
                val = head.data; //记录最新的对比数值
                cur.next = head; // 设置游标的下一个节点

                head = head.next;//将遍历的节点往后移动
                cur = cur.next;//将游标的节点往后移动
            } else { //如果对当前节点的值等于对比数值
                cur.next = head.next; //将游标和遍历的节点都往后移动
                head = head.next;
            }
        }
        return temp.next;
    }

    /**
     * 去掉val赋值
     *
     * @param head
     * @return
     */
    static ListNode deleteDuplicated2(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode temp = new ListNode();
        ListNode cur = temp;
        int val = head.data;
        cur.next = head;
        head = head.next;
        cur = cur.next;

        while (head != null) {
            if (val != head.data) {
                val = head.data;
                cur.next = head;
                head = head.next;

                cur = cur.next;
            } else {
                cur.next = head.next;
                head = head.next;
            }
        }
        return temp.next;
    }

    static ListNode unique(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast= head;

        while(fast != null){
            if(slow.data != fast.data){
                slow = slow.next;
                slow.data = fast.data;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(3);
        node1.addTail(node2);
        node1.addTail(node3);
        node1.addTail(node6);
        node1.addTail(node8);
        node1.addTail(node4);
        node1.addTail(node5);
        node1.addTail(node7);
        System.out.println(node1);
        System.out.println(deleteDuplicated2(node1));
        System.out.println(unique(node1));
    }
}
