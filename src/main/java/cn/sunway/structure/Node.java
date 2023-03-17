package cn.sunway.structure;

/**
 * 双向队列节点对象，默认值为int类型
 * 为了方便操作，直接将类型设置为public访问权限
 * @author sunw
 * @date 2023/3/16
 */
public class Node {

    public Node pre;

    public Node next;

    public int item;

    @Override
    public String toString() {
        return String.valueOf(item);
    }
}
