package cn.sunway.algorithm.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * @author sunw
 * @date 2023/1/12
 */
public class Rob {

    /**
     * 1 <= nums.length <= 100
     * @param nums
     * @return
     */
    static int rob(int[] nums) {
        int a = 0;
        int b = 0;

        for(int i = 0; i < nums.length; i++){
            int temp = b;
            b = Math.max(a + nums[i], b);
            a = temp;
        }
        return b;
    }

    static int rob2(int[] nums){
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int k = 2; k <= nums.length; k ++){

            /**
             * 直到第K个 偷到的最多金额
             * 当前房子偷或者不偷
             * 偷：那么他的钱 = 前K-2个节点偷到的钱 + 当前节点的钱    因为第k-1个节点不能偷
             *                dp[k-2]  nums[k-1]
             *
             * 不偷，则dp[k-1]
             */

            dp[k] = Math.max(dp[k-1], nums[k - 1] + dp[k -2]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob2(nums));
        System.out.println(rob2(new int[]{2,7,9,3,1}));
    }
}
