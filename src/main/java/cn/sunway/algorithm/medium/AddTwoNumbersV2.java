package cn.sunway.algorithm.medium;

import cn.sunway.structure.ListNode;

import java.util.Stack;

/**
 * 数字最高位，位于链表头部
 *
 * 输入：l1 = [2,4,3], l2 = [1,5,6,4]
 * 输出：[1,8,0,7]
 * 解释：243 + 465 = 1807
 *
 * @author sunw
 * @date 2023/2/1
 */
public class AddTwoNumbersV2 {

    /**
     * 使用栈，考虑进位
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode add1(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        // 将两个队列的值 入栈，此时两个栈中存的数据将以倒序方式存在，高位在栈底，低位在栈顶
        while (l1 != null) {
            stack1.push(l1.data);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.data);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        // 遍历两个栈，构造当前节点的值 sum = data1 + data2 + carry ,计算出下一个位置的carry
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty()? 0: stack1.pop();
            sum += stack2.isEmpty()? 0: stack2.pop();

            //创建出当前节点
            ListNode node = new ListNode(sum % 10);
            /**
             * 由于拿到的结果，是从低位(个十百千万)开始的，
             * 所以需要将head不断指向新创建出来的node
             * 类似于链表的反转 {@code ReverseList.revert4}
             */
            node.next = head;
            head = node;
            //计算进位
            carry = sum / 10;
        }
        return head;
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

        System.out.println(add1(l1, l2));
    }
}
