package cn.sunway.algorithm.dp;

/**
 * @author sunw
 * @date 2023/2/21
 */
public class Fib {

    /**
     * 递归
     * 通过递归的方式来处理，其实是建立了一棵二叉树，并且二叉树的某些节点还被重复计算
     *
     *          f(20)
     *          /    \
     *       f(19)   f(18)
     *       / \      /   \
     *   f(18) f(17) f(17) f(16)
     *          .......
     *
     * 其中，f(18)、f(17) 都被计算了两次
     * 二叉树的总节点数为2^N，是指数级别的
     *
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
     * 带备忘录的递归解法
     * 建立备忘录dp，来记录之前已经计算的值
     *
     * 备忘录通常是以数组的形式来展现，如果之前计算过，就会被记录下来，后面只需要通过下标来获取即可
     *            f(20)
     *          /      \
     *       f(19)    f(18)🚫
     *       / \        /   \
     *   f(18) f(17)🚫 f(17)🚫 f(16)🚫
     *            .......
     * 这相当于把部分节点给去除了，称为「剪枝」
     *
     * 归纳来讲，题解的过程，就相当于填充DP数组的过程
     * 整个题解的过程，也可以看成是状态在数组中不断扩充的过程
     *
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
     *
     * 上面的dp解法，使用到了额外的n长度空间
     * 其实我们关心的只是最后两个位置的值，
     * 如果使用两个变量把这两个值临时存起来，还将减少内存使用
     *
     * @param n
     * @return
     */
    private static int fibLoop2(int n){
        if (n < 2) {
            return n;
        }
        int pre = 0, cur = 1;
        int i = 2; //从第二位开始遍历
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
