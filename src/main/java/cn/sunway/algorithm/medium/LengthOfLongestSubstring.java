package cn.sunway.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长非重复子串
 * @author sunw
 * @date 2023/2/1
 */
public class LengthOfLongestSubstring {

    /**
     * 使用hash表记录字符的最后一次出现的位置
     * 使用滑动窗口动态计算最长子串的长度
     * 滑动窗口: [curr的位置,i的位置]
     * 用max来记录最大的滑动窗口的最大宽度
     * @param str
     * @return
     */
    private static int lengthOfLongestSubstring(String str){
        int max = 0;  //最大长度初始为0
        int leftSide = 0; //窗口左边的位置初始为0
        Map<Character, Integer> record = new HashMap<>();

        for(int i = 0; i < str.length(); i++){
            Character currentChar = str.charAt(i);
            //【滑动窗口左边位置变动的触发条件】如果已经包含了当前的字符
            if(record.containsKey(currentChar)){
                //重新计算窗口左边的位置
                leftSide = Math.max(leftSide, record.get(currentChar) + 1);
            }
            //记录当前字符最新的位置
            record.put(currentChar, i);
            //计算窗口当前最大的宽度
            max =  Math.max(max, i - leftSide + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
