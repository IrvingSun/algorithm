package cn.sunway.algorithm.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 符号是否有效
 * https://leetcode-cn.com/problems/valid-parentheses/description
 *
 * @author sunw
 * @date 2023/1/7
 */
public class ValidParentheses {

    public static boolean valid(String[] source){
        Set<String> leftPart = new HashSet<>();
        leftPart.add("(");
        leftPart.add("{");
        leftPart.add("[");

        Stack<String> stack = new Stack<>();

        for(String item : source){
            if(leftPart.contains(item)){
                stack.push(item);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(item.equals(")") && stack.peek().equals("(")){
                    stack.pop();
                    continue;
                }else if(item.equals("}") && stack.peek().equals("{")){
                    stack.pop();
                    continue;
                }else if(item.equals("]") && stack.peek().equals("[")){
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(valid(new String[]{"(",")"}));
        System.out.println(valid("(,),[,],{,}".split(",")));
        System.out.println(valid("(,),[,],{,},}".split(",")));
        System.out.println(valid("(,),[,],{,},{,]".split(",")));
    }
}
