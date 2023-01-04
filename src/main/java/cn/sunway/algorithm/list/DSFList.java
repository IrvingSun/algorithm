package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * @author sunw
 * @date 2023/1/4
 */
public class DSFList {

    /**
     * 递归反转链表
     * @param head
     * @param pre
     */
    public static void dfs(ListNode head, ListNode pre){
        if(head == null){//如果最后一个节点遍历完成，则表示已经全部变成pre节点，此时链表也已经反转完成
            System.out.println(pre);
        }else{
            ListNode next = head.next; //1、获取当前节点的next节点
            head.next = pre;//2、将当前节点的next反转到pre节点
            dfs(next, head);//3、此时，当前节点往后移动到next节点，前置节点已经变成当前节点 继续递归
        }
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
        dfs(node1, null);
    }
}
