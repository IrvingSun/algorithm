package cn.sunway.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出两个已排序数组中的交集
 * <p>
 * [1,2,3,4,5,6,9]
 * [2,3,4,5,6,7,8,9]
 * <p>
 * 结果：[2,3,4,5,6,9]
 *
 * @author sunw
 * @date 2023/9/21
 */
public class DuplicatedArrayItems {

    /**
     * 使用双指针匹配
     *
     * @param a
     * @param b
     * @return
     */
    public List<Integer> duplicated(int[] a, int[] b) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                result.add(a[i]);
                // 如果匹配上了，需要二者都往前推进一位
                j++;
                i++;
            } else {
                if (a[i] < b[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 9};
        int[] b = new int[]{2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(new DuplicatedArrayItems().duplicated(a, b));
    }
}
