package topInterviewQuestionsEasy.dynamicProgramming;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-4
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/54/
 */
public class First {


    public int climbStairs(int n) {
        //return climbStairsWithArray(n, new int[n + 1]);
        return climbStairsByFor(n);
    }

    /*递归*/
    public int climbStairsWithArray(int n, int[] array){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(array[n] == 0)
            array[n] = climbStairsWithArray(n - 1, array) + climbStairsWithArray(n - 2, array);
        return array[n];
    }

    /*遍历*/
    public int climbStairsByFor(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;
        for(int i = 3; i <= n; i++){
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n];
    }

    public static void main(String[] args) {
        First first = new First();
        System.out.println(first.climbStairs(10));
    }
}
