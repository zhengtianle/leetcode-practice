package codingInterviews;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-16
 * @Author ZhengTianle
 * Description:
 * 数据流中的中位数
 * https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&tqId=11216&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class SixThree {
    /**
     * 利用两个优先队列实现
     */
    PriorityQueue<Integer> smallQueue = new PriorityQueue<>();
    PriorityQueue<Integer> bigQueue = new PriorityQueue<>(Comparator.reverseOrder());

    //读取数据流
    public void Insert(Integer num) {
        if(bigQueue.isEmpty() || num <= bigQueue.peek()) {
            bigQueue.offer(num);
        } else {
            smallQueue.offer(num);
        }
        if(bigQueue.size() == smallQueue.size() + 2) {
            smallQueue.offer(bigQueue.poll());
        }
        if(smallQueue.size() == bigQueue.size() + 1) {
            bigQueue.offer(smallQueue.poll());
        }
    }

    //获取当前读取数据的中位数
    public Double GetMedian() {
        return smallQueue.size() == bigQueue.size() ? (smallQueue.peek() + bigQueue.peek()) / 2.0 : Double.valueOf(bigQueue.peek());
    }
}
