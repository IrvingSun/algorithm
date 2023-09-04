package cn.sunway.algorithm.window;

/**
 * 给定一个字符串t，从目标字符串s中查找到包含t的最小子串
 * s = "ADOBECODEBANC", t = "ABC"
 * 返回  BANC
 *
 * @author sunw
 * @date 2023/9/4
 */
public class MinWindow {

    /**
     * 使用滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        String result = "";
        int left = 0;
        int right = 0;
        while (right < s.length() && left <= right) {
            String sub = s.substring(left, right + 1);
            if (sub.length() >= t.length() && contains(sub, t.toCharArray())) {
                if (result.equals("") || result.length() >= sub.length()) {
                    result = sub;
                }
                left++;
            } else {
                right++;
            }
        }
        return result;
    }

    /**
     * 判断子串是否满足包含所有的t字符
     *
     * @param sub
     * @param chars
     * @return
     */
    private boolean contains(String sub, char[] chars) {
        for (char c : chars) {
            if (!sub.contains(String.valueOf(c))) {
                return false;
            }else{
                sub = sub.replaceFirst(String.valueOf(c),"");
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("acbbaca", "aba"));
    }

}
