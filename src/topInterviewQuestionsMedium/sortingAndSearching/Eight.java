package topInterviewQuestionsMedium.sortingAndSearching;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-22
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/103/
 * 搜索二维矩阵 II
 */
public class Eight {
    /**
     * 右上角开始遍历
     * 比target小则删除行
     * 比target大则删除列
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        //从右上角开始遍历
        int row = 0;
        int column = matrix[0].length-1;
        while(row < matrix.length && column >= 0){
            if(matrix[row][column] == target)
                return true;
            else if(matrix[row][column] > target)
                column--;
            else
                row++;
        }
        return false;
    }
}
