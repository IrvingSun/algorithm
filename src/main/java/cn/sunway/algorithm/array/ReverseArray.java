package cn.sunway.algorithm.array;

import java.util.Arrays;

/**
 * 反转数组
 * 左右替换
 * @author sunw
 * @date 2023/1/3
 */
public class ReverseArray {

    public static void reverse(int[] arr){
        System.out.println("before: "+ Arrays.toString(arr));
        if(arr != null && arr.length != 1){
            int left = 0;
            int right = arr.length -1;
            while(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left ++;
                right --;
            }
        }
        System.out.println("after: "+ Arrays.toString(arr));
    }

    public static void main(String[] args) {
        reverse(new int[]{1,2,3,4,5,6,7});
        reverse(new int[]{1,2,3,4,5,6,7,8});
        reverse(new int[]{1});
        reverse(null);
    }
}
