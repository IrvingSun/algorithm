package cn.sunway.algorithm.recursion;

/**
 * 阶乘
 * 递归 + 循环
 * @author sunw
 * @date 2023/2/6
 */
public class Factorial {

    private static long factorial(int num){
//        if(num == 0){
//            return 0;
//        }
//        if(num == 1){
//            return 1;
//        }
        if(num <= 2){
            return num;
        }
        return factorial(num - 1) * num;
    }

    private static long loop(int num){
        long sum = 0;
        if(num > 0){
            sum = 1;
        }
        for(int i = 1; i <= num; i++){
            sum = sum * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(loop(0));
        System.out.println(loop(1));
        System.out.println(loop(2));
        System.out.println(loop(3));
        System.out.println(loop(4));
        System.out.println(loop(5));

        System.out.println("---------------------");

        System.out.println(factorial(0));
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
    }
}
