package cn.sunway.algorithm.array;

/**
 * 获取数组中出现次数超过一半的数字
 *
 * 投票计数法
 *
 * 超过一半的意思是：比其他所有的数字数量加起来还要多
 *
 * @author sunw
 * @date 2023/1/12
 */
public class MajorityNumber {
    private static int majority(int[] nums){
        int current = nums[0]; //暂时无法删除的数字
        int count = 0; //暂时无法删除的数字的数量

        for(int i = 0; i < nums.length; i++){
            if(count == 0){  //如果count==0，则需要替换无法删除的数字
                current = nums[i];
            }

            if(current == nums[i]){
                count ++;

            }else{
                count --;
            }

        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(majority(new int[]{2,2,1,1,1,2,2,1,1}));
        System.out.println(majority(new int[]{3,2,3}));
    }

}
