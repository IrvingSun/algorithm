package cn.sunway.algorithm.stack;

import java.util.Stack;

/**
 * 不使用两个栈，使用一个栈实现最小栈
 * 栈中存储数组，数组长度为2，[当前节点值，当前栈中最小的值]
 *
 * @author sunw
 * @date 2023/2/25
 */
public class MinStackV2 {
    private Stack<int[]> data;

    public MinStackV2() {
        this.data = new Stack<>();
    }

    public void push(int val) {
        if (data.isEmpty()) {
            data.push(new int[]{val, val});
        } else {
            data.push(new int[]{val, Math.min(val, data.peek()[1])});
        }
    }

    public void pop() {
        data.pop();
    }

    public int top() {
        return data.peek()[0];
    }

    public int getMin() {
        return data.peek()[1];
    }

    public static void main(String[] args) {
        MinStackV2 minStack = new MinStackV2();
        minStack.push(2);
        minStack.push(3);
        minStack.push(5);
        minStack.push(6);
        minStack.push(4);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }
}
