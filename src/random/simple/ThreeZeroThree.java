package random.simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-3
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class ThreeZeroThree {
    /**
     * 会多次调用sunRange方法，则每次调用sumRange时都把索引i～j的元素加起来计算的方式不可取（太慢了）
     * 这里用一个sum数组,sum[i]表示索引0~i对应的元素之和
     */
    int[] sum = null;

    public void NumArray(int[] nums) {
        if(nums == null || nums.length <= 0) return ;
        sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) {
            return sum[j];
        } else{
            return sum[j] - sum[i - 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */