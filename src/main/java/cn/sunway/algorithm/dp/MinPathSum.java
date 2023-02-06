package cn.sunway.algorithm.dp;

/**
 * m * n 网格
 * 计算从左上角到右下角的所有路径中，值最小的情况下，最小值是多少
 * @author sunw
 * @date 2023/2/6
 */
public class MinPathSum {

    /**
     * 默认数组长度大于等于[1][1]
     * 动态规划
     * dp[m][n] = min(dp[m][n-1],dp[m-1][n]) + grid[m][n]
     * @param grid
     * @return
     */
    private static int minPathSum(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        //需要将两边的值进行规整，因为不能遍历到，而初始值为0，会造成错误
        for (int i = 1;i<grid.length;i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        for (int i = 1;i<grid[0].length;i++) {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }

        for(int i = 1; i < grid.length; i ++){
            for(int j = 1; j < grid[i].length; j++){
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length -1 ];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid));
    }
}
