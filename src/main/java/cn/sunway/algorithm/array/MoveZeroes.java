package cn.sunway.algorithm.array;

import java.util.Arrays;

/**
 * @author sunw
 * @date 2023/1/20
 */
public class MoveZeroes {

    /**
     * 将0往后移动
     * 定义读写指针
     * 读指针不断往后移动，
     * 在遇到读指针不为0的情况，将值设置给写指针，并且将写指针往后移动
     * @param nums
     */
    private static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int wp = 0;//写指针
        int rp = 0;//读指针

        while (rp < nums.length) {
            if (nums[rp] != 0) {
                nums[wp] = nums[rp];
                wp++;
            }
            rp++;
        }
        for (; wp < nums.length; wp++) {
            nums[wp] = 0;
        }
    }

    /**
     * 使用快慢指针的思维，这个可能代码和上面的方式差不多，但是思想却有些差异
     * 快慢指针：fast slow
     * 同时从0出发，
     * 如果fast=0，则fast往前一步
     * 如果fast!=0，则将fast赋值给slow，并且slow也往前一步
     *
     *  @param nums
     */
    private static int[] moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }
        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0,1,0,3,12};
        int[] nums = new int[]{0,1,0,2,0,3};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(moveZeroes2(nums)));

    }
}
