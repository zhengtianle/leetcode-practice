package codingInterviews;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-10
 * @Author ZhengTianle
 * Description:
 * 孩子们的游戏（圆圈中最后剩下的数）
 *  * https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *  题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class FourtySix {

    /**
     * 链表模拟
     * O(nm)
     */
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        int number = 0;
        while(list.size() > 1) {
            number = (number + m - 1) % n;
            list.remove(number);
        }
        return list.get(0);
    }

    /**
     * 第一轮：0 1 2 3 …… n-1，出去的人是 (m-1) % n，设为k
     * 第二轮：0 1 2 3 ……k-1 k+1 …… n-1。改成从k+1为0编号……。
     * 出去的人新编号为(m-1)%(n-1),对应的旧编号（在第一轮中的编号）为 （新编号+(k+1)） % n ==k是(m-1)%n==> (新编号+m)%n
     * 每轮以第一个开始报数的人编号为0
     * 最后一轮报数的人在最后一轮的编号为0，
     * 那么这个人在倒数第二轮里的编号是多少就可以求出来，
     * 求出倒数第二轮的对应编号，那么这个人对应到倒数第三轮是多少也可以求出来……
     * 直到对应到第一轮，因为我们最后想要的，就是以第一轮编号为基准的最后留下的人的编号。
     */
    public int LastRemaining_Solution1(int n, int m) {
        if(n <= 0) {
            return -1;
        }
        if(n == 1) {
            return 0;
        }
        return (LastRemaining_Solution1(n - 1, m) + m) % n;
    }
}
