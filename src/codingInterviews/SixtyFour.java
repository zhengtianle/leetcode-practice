package codingInterviews;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-17
 * @Author ZhengTianle
 * Description:
 * 滑动窗口的最大值
 * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 */
public class SixtyFour {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length <= 0 || size <= 0) {
            return list;
        }
        int index = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            index = i - size + 1;
            if(queue.isEmpty()) {
                queue.addLast(i);
            } else if(index > queue.peekFirst()) {
                //去除队首不在滑动窗口内的元素
                queue.pollFirst();
            }
            while(!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                //去除队尾的小元素，队首保留最大元素
                queue.pollLast();
            }
            queue.add(i);
            if(index >= 0) {
                list.add(num[queue.peekFirst()]);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        SixtyFour obj = new SixtyFour();
        obj.maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3);
    }
}
