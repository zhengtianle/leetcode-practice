package codingInterviews;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-10
 * @Author ZhengTianle
 * Description:
 * 数组中重复的数字
 * https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Fifty {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 1) {
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++) {
            if(map.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                map.put(numbers[i], 0);
            }
        }
        return false;
    }

    /**
     * 因为所有数字都在0到n-1的范围内
     * 所有可以利用现有数组做标记
     * 时间复杂福O(n)
     * 空间复杂度O(1)
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 1) {
            return false;
        }
        for(int i = 0; i < length; i++) {
            if(numbers[i] != i && numbers[numbers[i]] == numbers[i]) {
                duplication[0] = numbers[i];
                return true;
            }

            //交换下标i和numbers[i]对应的值
            int tmp = numbers[i];
            numbers[i] =  numbers[tmp];
            numbers[tmp] = tmp;
        }
        return false;
    }
}
