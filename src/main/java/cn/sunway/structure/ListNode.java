package cn.sunway.structure;

/**
 * 单链表
 *
 * @author sunw
 * @date 2022/12/30
 */
public class ListNode {
    public int data;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int t) {
        this();
        data = t;
    }

    public ListNode getNext() {
        return next;
    }

    public void addTail(ListNode item){
        ListNode tail = this;
        //找到最后一个节点
        while (tail.next != null){
            tail = tail.next;
        }
        tail.next = item;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[" + this.data + "]");
        ListNode current = this.next;
        while(current !=null){
            str.append(" --> [").append(current.data).append("]");
            current = current.next;
        }
        str.append(" -->NULL");
        return str.toString();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.addTail(node2);
        System.out.println(node1);
    }
}
