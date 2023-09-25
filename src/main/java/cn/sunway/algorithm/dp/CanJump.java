package cn.sunway.algorithm.dp;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 *  判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * @author sunw
 * @date 2023/9/25
 */
public class CanJump {

    /**
     * 使用一个临时变量来记录到目前为止，能到达的最远的距离，如果 达到了最后一个位置，则表示能到达
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        //前n-1个元素能够跳到的最远距离
        int k = 0;
        for (int i = 0; i <= k; i++) {
            //第i个元素能够跳到的最远距离
            int temp = i + nums[i];
            //更新最远距离
            k = Math.max(k, temp);
            //如果最远距离已经大于或等于最后一个元素的下标,则说明能跳过去,退出. 减少循环
            if (k >= nums.length - 1) {
                return true;
            }
        }
        //最远距离k不再改变,且没有到末尾元素
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new CanJump().canJump(new int[]{3,2,1,0,4}));
    }
}
