package cn.sunway.algorithm.dp;

/**
 * 给定一个两个数，m,n
 * 表示m*n的网格，从[0,0]点出发，只能是m+1或者n+1
 * 能有多少种方式得到[m,n]
 *
 * @author sunw
 * @date 2023/2/3
 */
public class UniquePaths {

    /**
     * 动态规划
     *
     * dp[m,n] = dp[m,n-1] + dp[m-1,n]
     * dp[0, * ] = 1
     * dp[*, 0 ] = 1
     *
     * @param m
     * @param n
     * @return
     */
    private static int uniquePaths(int m, int n){
        if(m <= 0 || n <= 0){
            return 0;
        }
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i ++){
            dp[i][0] = 1;
        }

        for(int j = 0; j < n; j ++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                dp[i][j] = dp[i][j-1] + dp[i - 1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
        System.out.println(uniquePaths(3,3));
    }
}
