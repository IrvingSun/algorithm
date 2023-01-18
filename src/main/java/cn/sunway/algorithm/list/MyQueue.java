package cn.sunway.algorithm.list;

import java.util.Stack;

/**
 * 使用两个栈 实现队列
 * @author sunw
 * @date 2023/1/18
 */
public class MyQueue {
    private Stack<Integer> stack1 ;//用于存储数据
    private Stack<Integer> stack2 ;//用于倒腾数据

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * 将元素 x 推到队列的末尾
     * @param x
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * 从队列的开头移除并返回元素
     * @return
     */
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int result = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    /**
     * 返回队列开头的元素
     * @return
     */
    public int peek() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int result = stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    /**
     * 如果队列为空，返回 true ；否则，返回 false
     * @return
     */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
