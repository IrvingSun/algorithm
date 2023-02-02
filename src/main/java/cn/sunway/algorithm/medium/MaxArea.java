package cn.sunway.algorithm.medium;

/**
 * 给定一个数组，选择其中两个元素，以其下标距离为底，以元素的值表示边的高度，计算能得到的最大的面积
 * eg: [1,2,3],最大面积是2；选择节点：1,3 或者 2,3
 *
 * @author sunw
 * @date 2023/2/2
 */
public class MaxArea {

    /**
     * 计算数组最大面积
     * 面积计算公式：
     * S[i,j] = (j - i) * min(h[i], h[j])
     *
     * @param height
     * @return
     */
    private static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                //每次移动短板   移动长板会引起面积变得更小
                max = Math.max(max, (right - left) * height[left++]);
            } else {
                max = Math.max(max, (right - left) * height[right--]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
