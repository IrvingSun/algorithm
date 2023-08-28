package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

import java.util.PriorityQueue;

/**
 * 合并多个有序链表
 * eg:
 * [[1,3,5,7]  [2,4,6,7] ] => [1,2,3,4,5,6,7,7]
 *
 * @author sunw
 * @date 2023/1/5
 */
public class MergeKList {

    /**
     * 构造小顶堆，不断从中找到最小的值
     *
     * @param nodes
     * @return
     */
    static ListNode mergeK(ListNode[] nodes) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        if (nodes == null || nodes.length == 0) {
            return dummy.next;
        }

        /**
         * 小顶堆
         */
        PriorityQueue<ListNode> queue = new PriorityQueue<>(nodes.length, (a, b) -> (a.data - b.data));

        for (ListNode node : nodes) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            p.next = minNode;
            if (minNode.next != null) {
                queue.add(minNode.next);
            }
            p = p.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        node1.addTail(node2);
        node1.addTail(node4);
        node1.addTail(node5);

        node3.addTail(node6);

        System.out.println(mergeK(new ListNode[]{node1, node3}));
    }
}
