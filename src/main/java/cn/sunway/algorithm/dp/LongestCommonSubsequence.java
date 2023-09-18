package cn.sunway.algorithm.dp;

/**
 * 最长 公共 非连续子序列
 * @author sunw
 * @date 2023/2/6
 */
public class LongestCommonSubsequence {

    /**
     * 假设字符串text1 和 text2的长度 分别为m和n
     * 创建一个m+1行  n+1列的二维数组 dp
     * 其中dp[i][j] 表示text1[0:i]和text2[0:j]的最长公共子序列
     * 边界：i = 0 或者 j = 0 时 dp[i][j] = 0
     * 即遍历的时候从1开始即可
     * i ≠ 0 并且 j ≠ 0 的时候
     * 如果 text1.i = text2.j   dp[i][j] = dp[i-1][j-1] + 1
     * 如果 text1.i ≠ text2.j   dp[i][j] = max( dp[i-1][j], dp[i][j-1])
     * @param text1
     * @param text2
     * @return
     */
    private static int longestCommonSubsequence(String text1, String text2){
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            char t1 = text1.charAt(i-1);
            for(int j = 1; j<= n; j++){
                char t2 = text2.charAt(j-1);
                if(t1 == t2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcd","abd"));
    }
}
