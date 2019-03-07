package codingInterviews;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-7
 * @Author ZhengTianle
 * Description:
 * 和为S的两个数字
 * https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FourtyTwo {

    /**
     * 两端指针向内遍历
     * 离得越远，成绩越小(x + y = S, x * y = M， y = x + d
     *                  => 2x + d = S
     *                  => x * y = (S -d)(S + d)/2 = M
     *                  => x*y关于d(x与y之间的距离)是一个二次函数，开口向下，y轴为对称轴，d越大，x*y越小)
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array == null || array.length <= 1) {
            return list;
        }
        int low = 0;
        int high = array.length - 1;
        while(low < high) {
            if(array[low] + array[high] == sum) {
                list.add(array[low]);
                list.add(array[high]);
                break;
            } else if(array[low] + array[high] < sum) {
                low++;
            } else {
                high--;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        FourtyTwo obj = new FourtyTwo();
        System.out.println(obj.FindNumbersWithSum(new int[]{1,2,4,7,11,15}, 15));
    }
}
