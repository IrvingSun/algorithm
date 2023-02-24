package cn.sunway.algorithm.medium;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *  TODO
 * @author sunw
 * @date 2023/2/22
 */
public class IntegerBreak {

    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                int curMax = 0;
                for (int j = 1; j < i; j++) {
                    curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
                }
                dp[i] = curMax;
            }
            return dp[n];
        }
    }
}
