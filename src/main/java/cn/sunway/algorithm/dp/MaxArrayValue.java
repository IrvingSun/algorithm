package cn.sunway.algorithm.dp;

/**
 * @author sunw
 * @date 2023/1/10
 */
public class MaxArrayValue {

    /**
     * 动态规划  看之前的结果对本次相加是否有增益效果
     * 如果前面的结果之和大于0，则本次的计算 = 当前值 + 前面的值
     * 如果前面的结果之和小于0，则本次的计算 = 当前值
     * 每次计算完毕，重新选出最大值
     *
     * @param nums
     * @return
     */
    static int maxValue(int[] nums) {
        int result = nums[0];
        int preSum = 0;
        for (int num : nums) {
            if (preSum > 0) {
                preSum += num;
            } else {
                preSum = num;
            }
            result = Math.max(result, preSum);
        }
        return result;
    }


    /**
     * f(x) = x
     * f(x) = max(f(x-1) , 0 ) + x
     *
     * @param nums
     * @return
     */
    static  int dp(int nums[]){
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] , 0 ) + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxValue(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(dp(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println(maxValue(new int[]{5, 4, -1, 7, 8}));
        System.out.println(dp(new int[]{5, 4, -1, 7, 8}));

        System.out.println(maxValue(new int[]{-5, -4, 1, -7, -8}));
        System.out.println(dp(new int[]{-5, -4, 1, -7, -8}));
    }
}

