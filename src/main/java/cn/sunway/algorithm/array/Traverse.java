package cn.sunway.algorithm.array;

/**
 * 使用遍历函数递归遍历数组
 * @author sunw
 * @date 2023/9/6
 */
public class Traverse {

    public static void traverse(int[] arr, int i){
        if(i == arr.length){
            return;
        }
//        System.out.println(arr[i]);
        traverse(arr, i+1);
        System.out.println(arr[i]);
    }

    public static void main(String[] args) {
        traverse(new int[]{3,1,4,1,5,1,6,9}, 0);
    }
}
