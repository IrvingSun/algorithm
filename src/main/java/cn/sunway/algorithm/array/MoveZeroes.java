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

    public static void main(String[] args) {
//        int[] nums = new int[]{0,1,0,3,12};
        int[] nums = new int[]{0,1,0,2,0,3};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
}
