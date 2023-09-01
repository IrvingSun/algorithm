package cn.sunway.algorithm.string;

/**
 * 获取最长回文
 *
 * @author sunw
 * @date 2023/9/1
 */
public class LongestPalindrome {

    /**
     * 返回字符串中的最长回文
     * <p>
     * 回文：正反数据一致
     * 如果字符串长度为奇数，则以中心点为中点
     * 如果字符串长度为偶数，则以中心点、中心点+1为出发点
     * <p>
     * 所以，针对某个字符串，每个节点都有可能是中心点和中心点+1，
     * 遍历完所有的节点，使用palindrome计算最长的回文
     * 得到最长的回文
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String res1 = palindrome(s, i, i);
            String res2 = palindrome(s, i, i + 1);

            result = res1.length() > result.length() ? res1 : result;
            result = res2.length() > result.length() ? res2 : result;
        }

        return result;
    }


    /**
     * 在字符串s中，从指定中心点出发的 最长回文
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    public String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babbad"));
    }
}
