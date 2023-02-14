package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 使用插入法对链表进行排序
 * @author sunw
 * @date 2023/2/14
 */
public class SortList {

    private static ListNode sortList(ListNode head){
        ListNode dummy = new ListNode();
        while(head != null){//从头至尾遍历链表head
            ListNode next = head.next;//记录下一个遍历的头结点
            ListNode cur = dummy;//重置对比的位置

            //找到需要插入数据head的位置
            while(cur.next != null && cur.next.data < head.data){
                cur = cur.next;
            }
            //将当前的head节点插入dummy链表中
            head.next = cur.next;
            cur.next = head;
            head = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node1.addTail(node2);
        node1.addTail(node3);
        node1.addTail(node4);
        node1.addTail(node5);
        node1.addTail(node6);
        System.out.println(node1);
        System.out.println(sortList(node1));
    }
}
