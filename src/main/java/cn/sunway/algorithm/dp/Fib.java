package cn.sunway.algorithm.dp;

/**
 * @author sunw
 * @date 2023/2/21
 */
public class Fib {

    /**
     * 递归
     * @param n
     * @return
     */
    private static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 2) + fib(n - 1);
    }

    /**
     * 建立备忘录dp，来记录之前已经计算的值
     * @param n
     * @return
     */
    private static int fibLoop(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int i = 2;
        while (i <= n) {
            dp[i] = dp[i - 1] + dp[i - 2];
            i++;
        }
        return dp[n];
    }

    /**
     * 去掉数组，使用变量压缩空间
     * @param n
     * @return
     */
    private static int fibLoop2(int n){
        if (n < 2) {
            return n;
        }
       int pre = 0, cur = 1;
        int i = 2;
        while (i++ <= n) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }


    public static void main(String[] args) {
        System.out.println(fib(4));
        System.out.println(fibLoop(4));
        System.out.println(fibLoop2(4));
    }
}
