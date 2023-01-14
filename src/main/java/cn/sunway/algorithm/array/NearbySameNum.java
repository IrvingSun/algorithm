//package cn.sunway.algorithm.array;
//
///**
// * @author sunw
// * @date 2023/1/13
// */
//public class NearbySameNum {
//
//    static boolean containsNearbyDuplicate(int[] nums, int k) {
//        if(nums.length < 2){
//            return false;
//        }
//        int slow = 0;
//        int fast = 1;
//        while(fast< nums.length){
//            if(fast - slow > k){
//                slow++;
//                continue;
//            }
//            if(nums[slow] == nums[fast] && fast - slow > 0){
//                return true;
//            }
//            fast++;
//        }
//         return false;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
//    }
//}
