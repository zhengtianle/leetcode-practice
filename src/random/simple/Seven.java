package random.simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-10
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/reverse-integer/
 * 7.整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Seven {
    public int reverse(int x) {
        if(x == 0) return 0;
        String s = String.valueOf(x);
        int i;
        for(i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != '0') break;
        }
        if(s.charAt(0) == '-') {
            s = s.substring(1, i + 1);
        } else {
            s = s.substring(0, i + 1);
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int ans = 0;
        try {
            ans = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        if(x < 0) {
            return -ans;
        }
        return ans;
    }

    public int reverse1(int x) {
        int ans = 0;
        int pop = 0;
        while(x != 0) {
            pop = x % 10;
            x /= 10;
            if(pop < 0 && ans < (Integer.MIN_VALUE - pop)/10) return 0;
            if(pop > 0 && ans > (Integer.MAX_VALUE - pop)/10) return 0;

            ans = ans * 10 + pop;
        }
        return ans;
    }

    public static void main(String[] args) {
        Seven obj = new Seven();
        System.out.println(obj.reverse1(-1230));
    }
}
