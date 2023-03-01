package cn.sunway.algorithm.dp;

/**
 * 查找两个数组的最长公共子数组 长度
 * [1,2,3,4,6,7,8]
 * [3,4,6,7,1,2]
 * 返回4
 * 3,4,6,7
 *
 * @author sunw
 * @date 2023/3/2
 */
public class FindLength {

    /**
     * 动态规划
     * 初始值：dp[0][0] = 0
     * 边界：数组最大长度
     * 如果有个数组为空，则返回0
     * 转移方程：
     * dp[i][j] = nums1[i-1] == nums2[j-1] ? dp[i-1][j-1] + 0 : 0
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,4,6,7,8};
        int[] nums2 = new int[] {3,4,6,7,1,2};
        System.out.println(findLength(nums1, nums2));
    }
}
