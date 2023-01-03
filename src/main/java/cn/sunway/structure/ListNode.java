package cn.sunway.structure;

/**
 * 单链表
 *
 * @author sunw
 * @date 2022/12/30
 */
public class ListNode {
    private int data;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(int t) {
        this();
        data = t;
    }

    public void addTail(ListNode item){
        ListNode tail = null;
        //找到最后一个节点
        while (this.next != null){
            tail = this.next;
        }
    }
}
