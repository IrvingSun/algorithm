package cn.sunway.algorithm.window;

import java.util.HashMap;

/**
 * 给定一个字符串t，从目标字符串s中查找到包含t的最小子串
 * s = "ADOBECODEBANC", t = "ABC"
 * 返回  BANC
 *
 * @author sunw
 * @date 2023/9/4
 */
public class MinWindow2 {

    /**
     * 使用滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap();
        HashMap<Character, Integer> window = new HashMap();

        for(Character c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0 ) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;//窗口中满足需要的字符串个数  这个数字，需要和need中字符种类数量一致

        int start = 0, len = Integer.MAX_VALUE;

        while(right < s.length()) {
            // 窗口往右扩大
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                //计算并修改当前窗口中的字符数量
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 如果滑动到了一个可以满足所需要求的区间
            while (valid == need.size()) {
                //先临时记录下当前的长度和起始位置
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // 将窗口左界 往右移动
                char d = s.charAt(left);
                left++;
                //如果移出的字符，是目标字符串所需的
                if (need.containsKey(d)) {
                    //已经不满足要求了
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start + len);
    }


    public static void main(String[] args) {
        MinWindow2 minWindow = new MinWindow2();
        System.out.println(minWindow.minWindow("acbbaca", "aba"));
    }

}
