package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-13
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 */
public class Nine {
    /**
     * 遍历
     */
    public static int[] twoSum(int[] nums, int target) {
        int i;
        int j;
        boolean flag = true;
        int[] ans = new int[2];
        for(i = 0; flag & i < nums.length; i++){
            for(j = 1; j <nums.length; j++){
                if(j == i)
                    continue;
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    flag = false;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 借助HashMap直接搜索是否有target-nums[i]
     */
    public static int[] anotherTwoSum(int[] nums, int target){
        HashMap<Integer,Integer> m = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(target-nums[i])){
                return new int[]{m.get(target-nums[i]), i};
            } else {
                m.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(anotherTwoSum(new int[]{2, 5, 5, 15}, 10)));
    }
}
