package math;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-5
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/61/
 */
public class Two {
    /*筛法*/
    public int countPrimes(int n) {
        int count = 0;
        byte[] byteArray = new byte[n];
        //全部赋值为1,默认全是素数
        for(int i = 2; i < n; i++)
            byteArray[i] = 1;

        /*遍历，素数的倍数不是素数->标0*/
        int sqrtN = (int) Math.sqrt(n);
        int i,j;
        for(i = 2; i <= sqrtN; i++){
            if(byteArray[i] == 1){
                for(j = i*i; j < n; j+=i){
                    byteArray[j] = 0;
                }
            }
        }

        for(i = 2; i < n; i++)
            if(byteArray[i] == 1)
                count++;

        return count;
    }

    public static void main(String[] args) {
        Two obj = new Two();
        System.out.println(obj.countPrimes(10));
    }
}
