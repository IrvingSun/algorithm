package cn.sunway.algorithm.array;

/**
 * 满足sum >= target 的长度最小的子数组
 * @author sunw
 * @date 2023/2/15
 */
public class MinSubArrayLen {

    /**
     * 使用双指针
     * high指针不断向前移动，直到sum >= target
     * 而后记录长度
     * 然后移动low指针，寻找下一个sum >= target时机，继续记录长度，并且比较记录较小的长度
     * 如果min从来没有被赋值，说明数组(正整数)本身所有的值加起来都不超过target，返回0
     * @param target
     * @param nums
     * @return
     */
    private static int minSubArrayLen(int target, int[] nums){
        int low = 0, high = 0, sum = 0, min = Integer.MAX_VALUE;
        while(high < nums.length){
            sum += nums[high++];
            while(sum >= target){
                min = Math.min(min, high - low);
                sum -= nums[low++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
