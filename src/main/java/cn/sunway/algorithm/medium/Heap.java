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
//            if(!(heap[cur] >= heap[2*cur + 1])){
//                int temp = heap[2*cur + 1];
//                heap[2*cur + 1] = heap[cur];
//                heap[cur] = temp;
//            }
//            if(!(heap[cur] >= heap[2*cur + 2])){
//                int temp = heap[2*cur + 2];
//                heap[2*cur + 2] = heap[cur];
//                heap[cur] = temp;
//            }
            adjustDownToUp(heap, cur);
            System.out.println("-->" + Arrays.toString(heap));
        }
    }

    private static void adjustDownToUp(int[] heap, int index) {
        int temp = heap[index];

        for (int i = 2 * index + 1; i < heap.length; i = 2 * i + 1) {
            if (i < heap.length - 1 && heap[i] < heap[i + 1]) {
                i++;
            }
            if (temp >= heap[i]) {
                break;
            } else {
                heap[index] = heap[i];
                index = i;
            }
        }
        heap[index] = temp;
    }

    public static void main(String[] args) {
        int[] heap = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(heap));
        maxHeap(heap);
        System.out.println(Arrays.toString(heap));
    }

}
