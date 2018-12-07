package topInterviewQuestionsEasy.others;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-7
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/64/
 */
public class First {



    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int temp = 1;
        while(temp != 0){
            //从最后一位向前判断该为是否为1
            if((n&temp) != 0){
                count++;
            }
            //temp左移一位
            temp = temp << 1;
        }
        return count;
    }

    public int anotherHammingWeight(int n) {
        int count = 0;
        //n & (n-1)得数的二进制相当于n的二进制去掉了最右边的1
        while(n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }

    /**
     * 错误解法
     * 符号位为1的话，高位一直补1
     */
    public int wrongHammingWeight(int n){
        int count = 0;
        while(n > 0){
            //判断最后一位是不是1
            if((n&1) == 1){
                count++;
            }
            //n右移一位
            n = n >> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        First object = new First();
        System.out.println(object.hammingWeight(  128));

    }
}
