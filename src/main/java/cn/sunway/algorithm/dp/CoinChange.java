package cn.sunway.algorithm.dp;

/**
 * 完全背包问题
 *
 * dp含义：dp[j] 凑齐j 所需要的最少硬币数
 * dp[j] = min(dp[j], dp[j-coins[i]]+1)
 *
 * @author sunw
 * @date 2023/2/21
 */
public class CoinChange {
    private static int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            //正序遍历：完全背包每个硬币可以选择多次
            for (int j = coins[i]; j <= amount; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != max) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange(coins, 15));
    }
}
