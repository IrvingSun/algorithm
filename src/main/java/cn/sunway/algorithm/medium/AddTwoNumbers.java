package cn.sunway.algorithm.medium;

import cn.sunway.structure.ListNode;

/**
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 *
 * @author sunw
 * @date 2023/2/1
 */
public class AddTwoNumbers {

    /**
     * 新建一个新的链表，将两个链表的相加并且往后挪动指针，并且考虑进位
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode add(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode dummy = new ListNode();//虚拟节点
        ListNode current = dummy;//将指针指向结果虚拟节点
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.addTail(new ListNode(4));
        l1.addTail(new ListNode(3));

        System.out.println(l1);

        ListNode l2 = new ListNode(5);
        l2.addTail(new ListNode(6));
        l2.addTail(new ListNode(4));

        System.out.println(l2);

        System.out.println(add(l1, l2));
    }
}
