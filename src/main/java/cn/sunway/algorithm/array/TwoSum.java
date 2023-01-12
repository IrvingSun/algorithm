package cn.sunway.algorithm.array;

/**
 * 两数之和
 * 数组非降序排列
 * 只有一个解
 * 不使用hashMap等容器
 * @author sunw
 * @date 2023/1/12
 */
public class TwoSum {

    /**
     * 使用双指针 + 动态规划
     * 从首尾开始遍历，
     * 如果小于目标值，则左边较小的值往右移动  使和小一点
     * 如果大于目标值，则右边较大的值往左移动  使和大一点
     * @param nums
     * @param sum
     * @return
     */
    private static int[] twoSum(int[] nums, int sum){
        if(nums == null || nums.length < 2){
            return new int[]{};
        }
        int left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] == sum){
                return new int[]{left+1, right+1};
            }
            if(nums[left] + nums[right] < sum){
                left ++;
            }else if(nums[left] + nums[right] > sum){
                right --;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] source = new int[]{2,7,11,15};
        int[] result = twoSum(source, 9);
        if(result == null || result.length < 1){
            System.out.println("[]");
        }
        for(int item : result){
            System.out.print(item + " ");
        }
    }

}
