package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-21
 * @Author ZhengTianle
 * Description:
 * 二维数组的查找
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class First {
    /**
     * 从右上角元素开始遍历
     * 用右上角元素与target比较
     * 若target > 右上角元素 -> 排除此行（右上角元素为此行最大元素）
     * 若target < 右上角元素 -> 排除此列（右上角元素为此列最小元素）
     */
    public boolean Find(int target, int [][] array){
        if(array.length == 0){
            return false;
        }
        int i = 0;//行
        int j = array[0].length - 1;//列
        while(i < array.length && j >= 0){
            if(target > array[i][j]){
                i++;
            } else if (target < array[i][j]){
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
