package cn.sunway.algorithm;

import java.util.Arrays;

/**
 * 最长递增子序列（非子串）
 *
 * @author sunw
 * @date 2023/9/18
 * <p>
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class LengthOfLIS {

    /**
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        // DP：长度为i的数组，最长的递增子序列长度为dp[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;

        //第N位的 最长递增子序列 = 从0至第N-1位的数组中挑选出比nums[N]小的数字，然后进行+1计算
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
