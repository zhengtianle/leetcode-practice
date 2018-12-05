package design;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-5
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/58/
 */
public class First {
    private int[] nums;
    private int[] result;
    private Random random;

    public First(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        result = Arrays.copyOf(nums, nums.length);
        return result;
    }

    /** Returns a random shuffling of the array. */
    /**
     * 洗牌的正确姿势：
     * https://yjk94.wordpress.com/2017/03/17/%E6%B4%97%E7%89%8C%E7%9A%84%E6%AD%A3%E7%A1%AE%E5%A7%BF%E5%8A%BF-knuth-shuffle%E7%AE%97%E6%B3%95/
     */
    public int[] shuffle() {
        result = Arrays.copyOf(nums, nums.length);
        int j;
        int temp;
        for(int i = 1; i < result.length; i++){
            //在拿起第i张牌时，只从它前面的牌（包括它）随机选出j，而不是从整副牌里面随机选取
            j = random.nextInt(i + 1);
            //swap
            temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        First obj = new First(nums);
        System.out.println("shuffle：" + Arrays.toString(obj.shuffle()));
        System.out.println("reset：" + Arrays.toString(obj.reset()));
        System.out.println("shuffle：" + Arrays.toString(obj.shuffle()));
    }
}
