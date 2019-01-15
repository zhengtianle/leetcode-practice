package topInterviewQuestionsMedium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-15
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/94/
 * 子集
 */
public class Four {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        childCollections(result, list, nums, 0);
        return result;
    }

    /**
     * dfs递归实现
     * 递归时只能遍历当前元素的后面元素
     * @param result 结果集
     * @param list 中间集
     * @param nums 原数组
     * @param count 从count元素开始
     */
    public void childCollections(List<List<Integer>> result, List<Integer> list,
                                 int[] nums, int count){

        result.add(new ArrayList<>(list));
        for(int i = count; i < nums.length; i++){
            list.add(nums[i]);
            childCollections(result, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }

    /**
     * 迭代实现
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());//空集
        int size;
        for(int num : nums){
            size = result.size();
            for(int i = 0; i < size; i++){//每次结果集的size都会增加一倍
                List<Integer> list = new ArrayList<>(result.get(i));//逐一取出当前结果集
                list.add(num);//将num依次加入每个结果集
                result.add(list);//加入新的结果集
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(four.subsets(new int[]{1,2,3}));
    }

}
