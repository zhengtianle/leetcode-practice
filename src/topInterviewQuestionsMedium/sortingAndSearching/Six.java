package topInterviewQuestionsMedium.sortingAndSearching;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-22
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/101/
 * 合并区间
 */
public class Six {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if(intervals.isEmpty())
            return list;
        intervals.sort(Comparator.comparingInt(o -> o.start));//按照start升序排序
        list.add(intervals.get(0));//第一个区间放入结果集
        for(int i = 1; i < intervals.size(); i++){//第二个区间开始遍历
            if(intervals.get(i).start <= list.get(list.size()-1).end){//可以合并
                Interval temp = list.remove(list.size() - 1);
                list.add(new Interval(temp.start, Math.max(temp.end, intervals.get(i).end)));
            } else {
                list.add(intervals.get(i));
            }

        }

        return list;
    }
}
