package cn.sunway.algorithm.array;

import java.util.*;

/**
 * 两个数组的交集 II
 * @author sunw
 * @date 2023/9/20
 */
public class Intersect {

    /**
     * 通过计算数组中每个数字出现的次数。来确定交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap();

        for(int nums : nums1){
            nums1Map.put(nums, nums1Map.getOrDefault(nums, 0) + 1);
        }
        List<Integer> resultList = new ArrayList();
        for(int nums : nums2){
            Integer remain = nums1Map.get(nums);
            if(remain != null && remain > 0){
                resultList.add(nums);
                nums1Map.put(nums, remain - 1);
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Intersect().intersect(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(new Intersect().intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
