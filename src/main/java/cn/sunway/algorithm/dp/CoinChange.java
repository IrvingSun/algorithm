package cn.sunway.algorithm.dp;

import java.util.Arrays;

/**
 * 完全背包问题
 *
 * dp含义：dp[j] 凑齐j 所需要的最少硬币数
 * dp[j] = min(dp[j], dp[j-coins[i]]+1)
 *
 * 基础：用金额为3、1 的硬币拼凑金额9，需要的数量为Y
 * 金额：0 1 2 3 4 5 6 7 8 9
 * 数量：
 遍历3   0 - - 1 - - 2 - - 3
 遍历1   0 1 2 1 2 3 2 3 4 3
 *              |
 *             1+1
 * @author sunw
 * @date 2023/2/21
 */
public class CoinChange {
    private static int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];//需要考虑金额为0的情况
        //初始化dp数组为最大值
        Arrays.fill(dp, max);
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;

        for (int coin : coins) {
            //正序遍历：完全背包每个硬币可以选择多次
            //从金额从硬币金额coin开始，因为至少需要一枚coin
            for (int j = coin; j <= amount; j++) {
                //如果之前的硬币 刚好可以凑够（j - coin）这么钱
                if (dp[j - coin] != max) {
                    //选择硬币数目最小的情况
                    // 即：要么就是之前凑够（j - coin）这么多钱用的硬币数 + 1 (+coin这枚) ，要么就是保持原有的那么多硬币数
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange(coins, 19));
    }
}
