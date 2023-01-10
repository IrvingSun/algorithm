package cn.sunway.algorithm.array;

/**
 * 删除数据中的重复元素，返回最新数组的长度
 * 
 * @author sunw
 * @date 2023/1/10
 */
public class DeleteDuplicatedItem {

    /**
     * 使用双指针 如果值不一样，则替换
     * @param nums
     * @return
     */
    public static int delete(int[] nums){
        if(nums == null){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }

        int left = 0;
        for(int right = 1; right < nums.length; right++){
            if(nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
            }
        }
//        for(int i : nums){
//            System.out.print(i + " ");
//        }
//        System.out.println();
        return left + 1;
    }


    public static void main(String[] args) {
        System.out.println(delete(new int[]{1,1,3,3,4,5,5,6}));
    }
}
