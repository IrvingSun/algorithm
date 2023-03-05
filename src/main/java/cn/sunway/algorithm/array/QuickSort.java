package cn.sunway.algorithm.array;

import java.util.Arrays;

/**
 * @author sunw
 * @date 2023/3/6
 */
public class QuickSort {

    private static void quickSort(int[] nums, int low, int high){
        if(low < high){
            int pi = partition(nums, low, high);
            System.out.println(pi + "----> " + Arrays.toString(nums));
            quickSort(nums,low , pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }

    //计算指针位置
    //左边都不大于pivot， 右边都比pivot大
    static int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,6,3,1,8,9,-1};
        System.out.println(" ----> " + Arrays.toString(nums));
        quickSort(nums, 0, 8);
        System.out.println(Arrays.toString(nums));
    }

}
