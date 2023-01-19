package cn.sunway.algorithm.array;

import java.util.Arrays;

/**
 * 轮转数组
 * @author sunw
 * @date 2023/1/20
 *
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class RotateArray {


    /**
     原始数组	  1 2 3 4 5 6 7
     翻转所有元素  7 6 5 4 3 2 1
     翻转 [0,k mod n−1]区间的元素	5 6 7 4 3 2 1
     翻转 [k mod n,n−1]区间的元素	5 6 7 1 2 3 4

     * @param nums
     * @param k
     */
    static void rotate(int[] nums, int k){
    int mode = k % nums.length  ; //需要移动的数量
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, mode - 1);
    reverse(nums, mode, nums.length - 1);
}

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
