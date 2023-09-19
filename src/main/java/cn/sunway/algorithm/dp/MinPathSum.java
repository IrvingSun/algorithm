package cn.sunway.algorithm.dp;

/**
 * m * n 网格
 * 计算从左上角到右下角的所有路径中，值最小的情况下，最小值是多少
 *
 * @author sunw
 * @date 2023/2/6
 */
public class MinPathSum {

    /**
     * 默认数组长度大于等于[1][1]
     * 动态规划
     * dp[m][n] = min(dp[m][n-1],dp[m-1][n]) + grid[m][n]
     *
     * @param grid
     * @return
     */
    private static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        //需要将两边的值进行规整
        //因为最上和最左的边边上的值，只和一条边上的值有关系
        //而这个值，却能帮助计算出其他位置的值，所以先计算出来
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        //计算出遍历到每个节点需要的步数，填满整个dp数组
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }


    /**
     * 存在重叠子问题的情况，所以耗时会长
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private static int dp(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        return Math.min(
                dp(grid, i - 1, j),
                dp(grid, i, j - 1)) + grid[i][j];

    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6},{7,8,9}};
        System.out.println(minPathSum(grid));
        System.out.println(dp(grid, 2, 2));
    }
}
