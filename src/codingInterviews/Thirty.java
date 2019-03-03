package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-3
 * @Author ZhengTianle
 * Description:
 * 连续子数组的最大和
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Thirty {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int sum = array[0];//记录前面的和
        int max = array[0];//最大连续子序列的和
        for (int i = 1; i < array.length; i++) {
            /*if(sum > 0) {
                sum += array[i];
            } else {
                //前面的和变为负数或者0，不值得和后面的相加
                sum = array[i];
            }
            max = sum > max ? sum : max;*/
            sum = Math.max(sum+array[i], array[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
