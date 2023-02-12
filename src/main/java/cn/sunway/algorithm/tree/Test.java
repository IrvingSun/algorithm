package cn.sunway.algorithm.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunw
 * @date 2023/2/10
 */
public class Test {

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
