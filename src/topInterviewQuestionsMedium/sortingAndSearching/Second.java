package topInterviewQuestionsMedium.sortingAndSearching;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-17
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/97/
 * 前K个高频元素
 */
public class Second {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.get(num) == null){
                map.put(num, 0);
            } else {
                map.put(num, map.get(num)+1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2)-> o2.getValue().compareTo(o1.getValue()));
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> mapNode : list){
            if(count >= k)
                break;
            count++;
            result.add(mapNode.getKey());
        }

        return result;
    }

    /**
     * 空间换时间
     */
    public List<Integer> topKFrequent1(int[] nums, int k){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            //min:nums里最小值
            //max:nums里最大值
            if (num < min) min = num;
            if (num > max) max = num;
        }
        int[] count = new int[max-min+1];//下标为数字-min，值为频数：统计每个数字的频数
        for(int num : nums){
            count[num-min]++;//min的下标为0
        }

        int[] keys = new int[nums.length+1];//下标为频数，值为数字：每个频数各有几个不同元素
        for(int i : count){
            if(i > 0)
                keys[i]++;
        }

        int num = 0;
        int minIndex = 0;//前k个高频元素中最小频率数
        for(int i = keys.length-1; i > 0; i--){
            if(keys[i] > 0){
                num+=keys[i];
                if(num >= k){
                    minIndex = i;
                    break;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < count.length; i++){
            if(count[i] >= minIndex){
                list.add(i+min);
            }
        }
        return list;
    }

}
