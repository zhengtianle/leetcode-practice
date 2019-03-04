package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-4
 * @Author ZhengTianle
 * Description:
 * 整数中1出现的次数
 * https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class ThirtyOne {

    /**
     * 遍历
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while(n > 0) {
            String nString = String.valueOf(n);
            char[] nchars = nString.toCharArray();
            for (int i = 0; i < nchars.length; i++) {
                if(nchars[i] == '1') {
                    count++;
                }
            }
            n--;
        }
        return count;
    }


    /**
     * 此题需要根据n一位一位的来看
     * 假设求百位上的数字中出现1的次数
     * 此时可以把数字分为三部分 1.百位上的数字 2.高于百位的数字 3.低于百位的数字 例如12345可分为12  3  45
     * ①如果百位上数字为0，则百位上出现1的次数仅由高位便可求得。
     *   例如12013,出现1的情况有100~199、1100~1199、2100~2199……11100~11199
     *   共有12*100个，也就是高位数字(12)*当前位(百位)
     * ②如果百位上数字为1，则个数由高位和低位同时决定
     *   例如12113，是12*100+14
     * ③如果百位上数字>=2，仅由高位便可求得
     *   例如12213，是(12+1)*100
     *
     * 其他位类似
     */
    public int NumberOf1Between1AndN_Solution1(int n) {
        int count = 0;
        int high = 0;
        int current = 0;
        int low = 0;
        for (int i = 1; i <= n; i *= 10) {
            high = (n/i)/10;
            current = (n/i)%10;
            low = n%i;
            if(current == 0) {
                count += high * i;
            } else if(current == 1) {
                count += high * i + low + 1;
            } else {
                count += (high + 1) * i;
            }
        }
        return count;
    }

}
