package cn.sunway.algorithm.recursion;

/**
 * 斐波那契数列
 * 递归 + 循环
 * @author sunw
 * @date 2023/2/6
 */
public class Fibonacci {

    /**
     * 递归
     * @param num
     * @return
     */
    private static int fibonacci(int num){
        if(num <= 2){
            return 1;
        }
        return fibonacci(num - 2) + fibonacci(num - 1);
    }

    private static int loop(int num){
        int prepre = 1;
        int pre = 1;
        int cur = 1;
        for(int i = 3; i <= num; i ++){
            cur = pre + prepre;
            prepre = pre;
            pre = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));

        System.out.println("---------");

        System.out.println(loop(1));
        System.out.println(loop(2));
        System.out.println(loop(3));
        System.out.println(loop(4));
        System.out.println(loop(9));
    }
}
