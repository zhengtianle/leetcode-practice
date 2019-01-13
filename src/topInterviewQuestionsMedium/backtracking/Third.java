package topInterviewQuestionsMedium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-13
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/93/
 * 全排列
 */
public class Third {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }

        boolean[] visited = new boolean[nums.length];//标志是否访问过
        Arrays.fill(visited, false);//表示全部没有被访问过
        List<Integer> list = new LinkedList<>();
        fullArray(result, list, nums, 0, visited);
        return result;
    }

    /**
     * 类似backtracking.First.java（电话）的递归DFS方法
     */
    public void fullArray(List<List<Integer>> result, List<Integer> list,
                          int[] nums, int count, boolean[] visited){
        if(count == nums.length){
            result.add(new LinkedList<>(list));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!visited[i]){
                list.add(nums[i]);
                visited[i] = true;
                fullArray(result, list, nums, count+1, visited);//递归进行
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }

    /**
     * 递归解法
     */
    public void fullArray1(){

    }

    /**
     * 遍历解法
     */
    public void fullArray2(){

    }


}
