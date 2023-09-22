package cn.sunway.algorithm.array;

import java.util.Arrays;

/**
 * @author sunw
 * @date 2023/9/22
 */
public class Merge {
    /**
     * 原地合并两个非降序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int c1 = m - 1;
        int c2 = n - 1;

        // 让两个数组相互消耗，数值大的挑选出来填入数组
        while(c1 >= 0 && c2 >= 0){
            if(nums1[c1] > nums2[c2]){
                nums1[c1 + c2 + 1] = nums1[c1];
                c1 --;
            }else{
                nums1[c1 + c2 + 1] = nums2[c2];
                c2 --;
            }
        }
        //如果c2消耗完了，那就处理完了
        //如果c1消耗完了，则需要将nums2中剩余的数据直接迁移到nums1中
        if(c1 < 0){
            System.arraycopy(nums2, 0, nums1, 0, c2+1);
        }
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,2,3,0,0,0};
//        int[] nums2 = new int[]{2,5,6};
//        new Merge().merge(nums1, 3, nums2, 3);

        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        new Merge().merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
