package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * @author sunw
 * @date 2023/2/9
 */
public class PartitionList {

    /**
     * 使用两个链表，一个存储小于X，一个存储大于等于X，而后合并
     * @param head
     * @return
     */
    private static ListNode partition(ListNode head, int x){
        ListNode min = new ListNode();
        ListNode minHead = min;
        ListNode max = new ListNode();
        ListNode maxHead = max;

        while (head != null){
            if(head.data < x){
                min.next = head;
                min = min.next;
            }else{
                max.next = head;
                max = max.next;
            }
            head = head.next;
        }
        max.next = null;
        min.next = maxHead.next;
        return minHead.next;
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

        System.out.println(partition(node1, 3));
    }
}
