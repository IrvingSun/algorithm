package cn.sunway.algorithm.dp;

/**
 * 某个国度，纸币只有三种面额：1，5，11
 * 如果需要凑W金额，纸币张数最少是多少张？
 *
 * 贪心策略：能用100就用100，每次都使用面额最大的纸币，这样能让W尽快最小
 * 在这个场景下，如果需要凑15，先凑11，然后4个1：  11 + 4*1
 * 但是这不是正确的解法，此处为5*3最优解
 *
 * 贪心策略只关注眼前的情况，而不是将多种情况进行对比
 *
 *
 * 当w = 15的时候，
 * 取11 cost = f(4) + 1
 * 取5  cost = f(10) + 1
 * 取1  cost = f(14) + 1
 *
 * 由此可见，f(n) 只与 f(n-1), f(n-5), f(11)
 *
 * f(n) = min(f(n-1), f(n-5), f(11)) + 1
 *
 * @author sunw
 * @date 2023/2/6
 */
public class Money {
    private static void printCost(){
        int record[] = new int[100];
        int w = 15;
        int cost;

        System.out.println("w = " + w);
        record[0] = 0;
        for(int i = 1; i <= w; i ++){
            cost = Integer.MAX_VALUE;
            if(i - 1 >= 0){
                cost = Math.min(cost, record[i - 1] + 1);
            }
            if(i - 5 >= 0){
                cost = Math.min(cost, record[i - 5] + 1);
            }
            if(i - 11 >= 0){
                cost = Math.min(cost, record[i - 11] + 1);
            }
            record[i] = cost;
            System.out.println(String.format("record[%d] = %d", i, cost));
        }
    }

    public static void main(String[] args) {
        printCost();
    }
}
