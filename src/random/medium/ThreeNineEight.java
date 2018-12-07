package random.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-2
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/random-pick-index/description/
 */
public class ThreeNineEight {

    int[] nums;
    public ThreeNineEight(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                list.add(i);
            }
        }

        return list.get((int)(Math.random()*list.size()));
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,3,3};
        ThreeNineEight solution = new ThreeNineEight(nums);

        // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
        System.out.println(solution.pick(3));

        // pick(1) 应该返回 0。因为只有nums[0]等于1。
        System.out.println(solution.pick(1));
    }
}
