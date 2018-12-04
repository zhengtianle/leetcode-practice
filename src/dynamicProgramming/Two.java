package dynamicProgramming;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-4
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/55/
 */
public class Two {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int ans = 0;
        int min = prices[0];
        for(int i = 1;i < prices.length; i++){
            if(prices[i] <= min){
                min = prices[i];
            }
            else{
                ans = Math.max(prices[i] - min, ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Two two = new Two();
        System.out.println(two.maxProfit(new int[]{7,6,4,3,1}));
    }
}
