package cn.sunway.algorithm.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s
 * @author sunw
 * @date 2023/9/19
 */
public class WordBreak {

    /**
     * 遍历 快慢指针
     * 这个解法比较直观，但是不能处理数组中元素相互包含的情况，故不能正确AC
     * @param s
     * @param wordDict
     * @return
     */
    @Deprecated
    public boolean wordBreak(String s, List<String> wordDict) {
        int slow = 0, fast = 0;
        int length = 0;
        while(fast < s.length()){
            String x = s.substring(slow,fast + 1);
            if(!wordDict.contains(x)){
               fast ++;
            }else{
                slow = ++fast;
                length += x.length();
            }
        }
        return length == s.length();
    }


    /**
     * 如果从另外一个角度思考,这是一个背包问题，字典是硬币，字符串是背包。
     * 由于字典中的元素可以重复使用，则这是个完全背包问题
     * 那么就转化为：使用字典中的元素，要凑齐字符串s，需要最少多少个字典元素
     * dp[j] = wordDict.contains(s[i,j)) && dp[i]   (i < j)
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakDP(String s , List<String> wordDict){
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){ //遍历背包
            for(int j = 0; j < i && !dp[i] ; j++){ // 从0-i进行遍历，如果dp[i]已经匹配过了，则跳过
                //如果dp[i]没有匹配过，
                // 则需要计算List中是否存在该字符串，并且可以和dp中上一个dp节点无缝衔接(j并没有包含在上一个substring中)
                if(wordDict.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }



    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));

        System.out.println("---------");

        System.out.println(new WordBreak().wordBreakDP("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new WordBreak().wordBreakDP("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new WordBreak().wordBreakDP("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(new WordBreak().wordBreakDP("aaaaaaa", Arrays.asList("aaaa", "aaa")));
    }

}
