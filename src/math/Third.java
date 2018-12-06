package math;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-6
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/62/
 */
public class Third {
    /*循环*/
    public boolean isPowerOfThree(int n) {
        double number = n;
        while(number >= 3){
            number = number/3.0;
        }
        if(number == 1.0)
            return true;
        return false;
    }

    /*不用递归或者循环*/
    public boolean anotherIsPowerOfThree(int n){
        //1162261467是int中最大的3的幂
        return n>0 && (1162261467 %n)==0;
    }


    public static void main(String[] args) {
        Third object = new Third();
        /*for(int i = 1; i < 1162261467; i++){
            //非3的幂
            if(1162261467 % i == 0 && !object.isPowerOfThree(i))
                System.out.println(i);
        }*/

    }

}
