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
        ListNode tail = this;
        //找到最后一个节点
        while (this.next != null){
            tail = this.next;
        }
        tail.next = item;
    }

    @Override
    public String toString() {
        String str = "["+this.data+"]";
        ListNode current = this;
        while(current.next!=null){
            str += " --> [" + this.next.data +"]";
            current = this.next;
        }
        str += " -->NULL";
        return str;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.addTail(node2);
        System.out.println(node1);
    }
}
