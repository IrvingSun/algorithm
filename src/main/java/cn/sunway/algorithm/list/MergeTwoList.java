package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 合并两个有序链表
 * eg:
 * [1,3,5,7]  [2,4,6,7]  => [1,2,3,4,5,6,7,7]
 *
 * @author sunw
 * @date 2023/1/5
 */
public class MergeTwoList {

    /**
     * 使用遍历的方式 构造虚拟节点，
     * 然后 不断推动虚拟节点的next节点设置
     * @param list1
     * @param list2
     * @return
     */
    static ListNode merge(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode();//虚拟节点
        ListNode current = temp;//将指针指向结果虚拟节点

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                current.next = list1;//指针 指向较小的节点
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next; //移动指针
        }
        current.next = list1 == null ? list2 : list1;
        return temp.next;
    }

    /**
     * 使用递归的方式
     *
     * 将两个链表头部较小的一个与剩下的元素合并，
     * 并返回排好序的链表头，当两条链表中的一条为空时终止递归
     *
     * @param list1
     * @param list2
     * @return
     */
    static ListNode merge2(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if(list1.data < list2.data){
            list1.next = merge2(list1.next, list2);
            return list1;
        }else{
            list2.next = merge2(list1, list2.next);
            return list2;
        }
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

//        System.out.println(merge(node1, node3));
        System.out.println(merge2(node1, node3));
    }
}
