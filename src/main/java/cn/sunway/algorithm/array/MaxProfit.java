package cn.sunway.algorithm.array;

/**
 * @author sunw
 * @date 2023/9/25
 */
public class MaxProfit {


    public int maxProfit(int[] prices) {
        int begin = 0, end = 0;
        int max = 0;
        while(begin <= end && end < prices.length) {
            if (prices[end] - prices[begin] > max) {
                max = prices[end] - prices[begin];
            } else {
                if (prices[end] - prices[begin] < 0) {
                    begin = end;
                } else {
                    end++;
                }
            }
        }
        return max;
    }

    /**
     * 最大总利润是多少
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                max = max + profit;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new MaxProfit().maxProfit(new int[]{7,6,4,3,1}));


        System.out.println(new MaxProfit().maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(new MaxProfit().maxProfit2(new int[]{7,6,4,3,1}));
    }

}
