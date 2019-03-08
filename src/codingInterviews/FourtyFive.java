package codingInterviews;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-8
 * @Author ZhengTianle
 * Description:
 * 扑克牌筛子
 * https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 */
public class FourtyFive {
    /**
     * 1. 除了0以外没有重复的数字
     * 2. max - min < 5 (不包括0)
     *
     * 数组作为重复标记
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length < 5) {
            return false;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] judgeRepeat = new int[14];
        Arrays.fill(judgeRepeat, 0);
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0) {
                continue;
            }
            judgeRepeat[numbers[i]]++;
            if(judgeRepeat[numbers[i]] > 1) {
                return false;
            }
            max = numbers[i] > max ? numbers[i] : max;
            min = numbers[i] < min ? numbers[i] : min;
        }
        if(max < min + 5) {
            return true;
        }
        return false;
    }

    /**
     * 改为 bit作为重复标记
     */
    public boolean isContinuous1(int [] numbers) {
        if(numbers == null || numbers.length < 5) {
            return false;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int judge = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0) {
                continue;
            }
            if(((judge >> numbers[i]) & 1) == 1)
                return false;
            judge |= (1 << numbers[i]);
            max = numbers[i] > max ? numbers[i] : max;
            min = numbers[i] < min ? numbers[i] : min;
        }
        if(max < min + 5) {
            return true;
        }
        return false;
    }
}
