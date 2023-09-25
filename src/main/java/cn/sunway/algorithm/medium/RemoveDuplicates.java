package cn.sunway.algorithm.medium;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项
 * 原地删除，使得出现次数超过2次的元素只出现2次
 * 返回删除之后的新长度
 *
 * @author sunw
 * @date 2023/2/8
 */
public class RemoveDuplicates {

    /**
     * 指针
     * 按照题目的要求 指针index指向的值，不能等于index-2的值
     * 如果相等，则需要暂停index的移动
     *  0, 0, 1, 1, 1, 1, 2, 3, 3
     * @param nums
     * @return
     */
    private static int removeDuplicates(int nums[]) {
        if (nums.length <= 2) return nums.length;

        int index = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[index - 2] != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    /**
     * 每个元素只能出现一次
     *
     * @param nums
     * @return
     */
    private static int removeDuplicates1(int nums[]) {
        if (nums.length <= 1) return nums.length;

        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[index - 1] != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        int nums1[] = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates1(nums1));
        System.out.println(Arrays.toString(nums1));
    }
}
