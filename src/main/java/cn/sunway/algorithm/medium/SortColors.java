package cn.sunway.algorithm.medium;

import java.util.Arrays;

/**
 * 一个长度为n的数组
 * 包含三种颜色
 * 0 红色
 * 1 白色
 * 2 蓝色
 *
 * 将数组中的元素，按012进行归类，使得相同的数字聚集在一起
 *
 * 在本地数组上进行操作，不使用额外的存储空间
 * @author sunw
 * @date 2023/2/8
 */
public class SortColors {

    /**
     * 使用指针，将0和1分批向前移动，最后剩下的就是2
     * 时间复杂度O(n),空间复杂度O(1)
     *
     * @param nums
     */
    private static void sortColors(int[] nums){
        if(nums == null || nums.length < 1){
            return ;
        }

        //将ptr指向第一个不为0的节点
        int ptr = 0;
        for(int i = 1 ; i < nums.length; i ++){
            if(nums[ptr] == 0){
                ptr ++;
            }
        }

        for(int i = ptr ; i < nums.length; i ++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }

        for(int i = ptr ; i < nums.length; i ++){
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,2,0,1,0,2,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
