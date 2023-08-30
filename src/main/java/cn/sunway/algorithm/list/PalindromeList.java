package cn.sunway.algorithm.list;

import cn.sunway.structure.ListNode;

/**
 * 判断单链表是不是回文链表
 *
 * @author sunw
 * @date 2023/8/30
 */
public class PalindromeList {
    private ListNode left;

    public boolean palindrome(ListNode head) {
        left = head;
        return isPalindrome(head);
    }

    public boolean isPalindrome(ListNode right) {
        if (right == null) {
            return true; //为result赋值初始值为true
        }

        boolean res = isPalindrome(right.next);//压栈倒序。从尾到头遍历
        res = res & (right.data == left.data);  //比对
        left = left.next; //正序遍历  从头到尾遍历
        return res;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(1);
        node1.addTail(node2);
        node1.addTail(node3);
        node1.addTail(node4);
        node1.addTail(node5);
        node1.addTail(node6);
        node1.addTail(node7);
        node1.addTail(node8);
        System.out.println(node1);
        System.out.println(new PalindromeList().palindrome(node1));
    }
}
