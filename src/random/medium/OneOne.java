package random.medium;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-23
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class OneOne {
    //暴力解法
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }


    //双指针法
    //初始位置位于首尾两端
    //较矮的一端向内移动
    public int maxArea1(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = Integer.MIN_VALUE;

        while(i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if(height[i] < height[j]) i++;
            else j--;
        }
        return max;
    }
}
