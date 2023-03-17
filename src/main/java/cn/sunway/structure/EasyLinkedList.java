package cn.sunway.structure;

/**
 * @author sunw
 * @date 2023/3/16
 */
public class EasyLinkedList {

    private Node first;

    private Node last;

    private int size = 0;

    /**
     * 往队列头部添加
     * @param item
     */
    public void addFirst(int item) {
        Node node = new Node();
        node.item = item;

        if (first == null) {
            first = node;
            node.pre = null;
            last = node;
        } else {
            Node temp = first;
            first = node;
            node.next = temp;
            temp.pre = node;
        }

        size++;
    }

    /**
     * 往队列尾部添加
     * @param item
     */
    public void addLast(int item){
        Node node = new Node();
        node.item = item;

        //空列表
        if(last == null){
            first = node;
            node.pre = null;
            last = node;
        }else{
            Node temp = last;
            last = node;
            temp.next = node;
            node.pre = temp;
        }
        size++;
    }

    @Override
    public String toString() {
        System.out.println(first + "===" + last);
        if (first == null) {
            return "[]";
        }
        StringBuffer sb = new StringBuffer("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.item);
            if (temp.next != null) {
                sb.append(",");
            }
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
