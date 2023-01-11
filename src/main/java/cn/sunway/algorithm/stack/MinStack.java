package cn.sunway.algorithm.stack;

import java.util.Stack;

/**
 * 构造最小栈，能获取到栈中最小的值
 *
 * @author sunw
 * @date 2023/1/11
 *
 *
 * 通过两个栈，
 * commonStack 存储所有节点
 * minStack 存放最小节点
 */
public class MinStack {

    private Stack<Integer> commonStack;
    private Stack<Integer> minStack;

    public MinStack() {
        commonStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        commonStack.push(val);
        if(!minStack.isEmpty() && minStack.peek() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = commonStack.pop();
        if(!minStack.isEmpty() && val == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return commonStack.peek();
    }
    
    public int getMin() {
        if(!minStack.isEmpty())
        return minStack.peek();
        return Integer.MIN_VALUE;
    }
}