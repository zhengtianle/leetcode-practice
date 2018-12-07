package topInterviewQuestionsEasy.array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-8
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 */
public class Second {

    public static int maxProfit(int[] prices) {
        int money = 0;  //利润
        boolean hasBought = false;  //是否买入标志位，初始值为未买入
        for(int i = 0; i < prices.length - 1; i++){
            //买入
            if(prices[i] < prices[i + 1] && !hasBought){
                money -= prices[i];
                hasBought = true;
            }
            //卖出
            if(hasBought & prices[i] > prices[i + 1]){
                money += prices[i];
                hasBought = false;
            }
        }
        if(hasBought){
            money += prices[prices.length - 1];
        }

        return money;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
