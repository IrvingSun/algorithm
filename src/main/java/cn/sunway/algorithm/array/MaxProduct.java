package cn.sunway.algorithm.array;

import java.util.Arrays;

/**
 * 数组最大连续子集的乘积
 * @author sunw
 * @date 2023/2/15
 */
public class MaxProduct {

    /**
     * 如果全是正整数，那么全部数据相乘即是最大值
     * 如果存在非整数，则存在区间值最大的情况
     * 使用一个max变量记录最大的值，初始值为MIN_VALUE
     * 使用imax和imin记录当前最大值和最小值，
     *
     * 如果出现小于0的数，需要将imax和imin交换？
     * 因为负数会将当前最大值变成最小值，最小值变成最大值
     *
     * 最后结果只需要从imax和记录的max中取值即可
     *
     * @param nums
     * @return
     */
    private static int maxProduct(int[] nums){
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3,-1,1,-100,0};
        System.out.println(Arrays.toString(nums));
        System.out.println(maxProduct(nums));
    }
}
