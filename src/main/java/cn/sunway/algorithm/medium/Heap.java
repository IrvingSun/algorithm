package cn.sunway.algorithm.medium;

import java.util.Arrays;

/**
 * 使用完全二叉树来表示堆，构造大顶堆，小顶堆
 *
 * @author sunw
 * @date 2023/1/31
 */
public class Heap {

    /**
     * 满二叉树：所有子节点所在的层高 = 树高
     * 完全二叉树：删除了部分数据的满二叉树
     * <p>
     * 可以使用数组来存储完全二叉树，节点i的左节点 2i+1、右节点 2i+2
     * arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * <p>
     * <p>
     * 构造大顶堆
     * 大顶堆：每个节点都大于或者等于子节点的值
     *
     * @param heap
     */
    private static void maxHeap(int[] heap) {
        if (heap == null || heap.length <= 1) {
            return;
        }
        // 在数组中找到 完全二叉树最后一个非叶子节点
        // arr.length/2 - 1
        int index = heap.length / 2 - 1;

        for (int cur = index; cur >= 0; cur--) {
            adjustDownToUp(heap, cur);
            System.out.println("-->" + Arrays.toString(heap));
        }
    }

    /**
     * 调整非叶子节点和其子节点的位置
     * 每次调整，都会兼顾当前非叶子节点的 所有的子节点
     * @param heap
     * @param index
     */
    private static void adjustDownToUp(int[] heap, int index) {
        int temp = heap[index];//当前非叶子节点的值

        //找到叶子节点的左子节点，一直往下找其左节点
        for (int i = 2 * index + 1; i < heap.length; i = 2 * i + 1) {
            //如果左子节点小于右子节点，判断其右节点
            if (i < heap.length - 1 && heap[i] < heap[i + 1]) {
                i++;
            }
            //此时，子节点中最大的值的下标为i
            //如果当前非叶子节点不小于叶子节点的值，则继续往下
            if (temp >= heap[i]) {
                break;
            } else {
                //如果当前非叶子节点的值小于叶子节点的值
                //将当非叶子节点的值设置为叶子节点的值，
                //将指针往后挪动
                heap[index] = heap[i];
                index = i;
            }
        }
        //将当前非叶子节点的值，设置到对应的位置上
        heap[index] = temp;
    }

    public static void main(String[] args) {
        int[] heap = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(heap));
        maxHeap(heap);
        System.out.println(Arrays.toString(heap));
    }

}
