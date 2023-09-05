package cn.sunway.algorithm.window;

import java.util.HashMap;

/**
 * 给定两个字符串s1, s2
 * 判断s1是否包含s2的全排列
 * 即是否存在一个子序列，包含s2中所有的字符，并且数量一致
 *
 * @author sunw
 * @date 2023/9/4
 */
public class CheckInclusion {

    /**
     * 使用滑动窗口 判断是否包含所有的字符，并且不包含其他的字符
     *
     * @param s
     * @param t
     * @return
     */
    public boolean checkInclusion(String s, String t) {
        HashMap<Character, Integer> need = new HashMap();
        HashMap<Character, Integer> window = new HashMap();

        for(Character c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0 ) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;//窗口中满足需要的字符串个数  这个数字，需要和need中字符种类数量一致

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
            while (right - left >= t.length()) {
                // 如果长度就等于需要匹配的字符串的长度  表示没有其他的字符
                if(valid == need.size()){
                    return true;
                }
                char d = s.charAt(left);
                left ++;  //移动窗口左边
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid --;
                    }
                    window.put(d, window.getOrDefault(d, 0) -1);
                }

            }
        }
        return false;
    }


    public static void main(String[] args) {
        CheckInclusion minWindow = new CheckInclusion();
        System.out.println(minWindow.checkInclusion("acbbaca", "aba"));
    }

}
