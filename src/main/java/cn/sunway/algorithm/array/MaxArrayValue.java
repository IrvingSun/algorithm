package cn.sunway.algorithm.array;

/**
 * @author sunw
 * @date 2023/1/10
 */
public class MaxArrayValue {

    /**
     * 动态规划
     * 如果前面的结果之和大于0，则本次的计算 = 当前值 + 前面的值
     * 如果前面的结果之和小于0，则本次的计算 = 当前值
     * 每次计算完毕，重新选出最大值
     * @param nums
     * @return
     */
    static int maxValue(int[] nums){
        int result = nums[0];
        int preSum = 0;
        for(int num : nums){
            if(preSum > 0){
                preSum += num;
            }else{
                preSum = num;
            }
            result = Math.max(result, preSum);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxValue(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxValue(new int[]{5,4,-1,7,8}));
    }
}
