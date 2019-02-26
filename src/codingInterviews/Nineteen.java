package codingInterviews;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-26
 * @Author ZhengTianle
 * Description:
 * 顺时针打印矩阵
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Nineteen {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int right = matrix[0].length - 1;//横长、右边界
        int down = matrix.length - 1;//竖长、下边界
        int up = 0;//上边界
        int left = 0;//左边界
        //控制方向标志位
        boolean canUp = false;
        boolean canDown = false;
        boolean canLeft = false;
        boolean canRight = true;
        int size = (right+1) * (down+1);//元素个数
        int i = 0, j = 0;//下标
        ArrayList<Integer> list = new ArrayList<>();
        while(list.size() < size) {
            list.add(matrix[i][j]);

            if(canUp) {
                if(i > up) {
                    i--;
                } else {
                    canRight = true;
                    canUp = false;
                    left++;

                    if(j < right) {
                        j++;
                    } else {
                        canRight = false;
                        canDown = true;
                        up++;
                    }
                }
            } else if(canDown) {
                if(i < down) {
                    i++;
                } else {
                    canLeft = true;
                    canDown = false;
                    right--;

                    if(j > left) {
                        j--;
                    } else {
                        canUp = true;
                        canLeft = false;
                        down--;
                    }
                }
            } else if(canLeft) {
                if(j > left) {
                    j--;
                } else {
                    canUp = true;
                    canLeft = false;
                    down--;

                    if(i > up) {
                        i--;
                    } else {
                        canRight = true;
                        canUp = false;
                        left++;
                    }
                }
            } else if(canRight) {
                if(j < right) {
                    j++;
                } else {
                    canRight = false;
                    canDown = true;
                    up++;

                    if(i < down) {
                        i++;
                    } else {
                        canLeft = true;
                        canDown = false;
                        right--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Nineteen obj = new Nineteen();
        int[][] test = new int[2][2];
        test[0][0] = 1;
        test[0][1] = 2;
        test[1][0] = 3;
        test[1][1] = 4;
        System.out.println(Arrays.toString(obj.printMatrix(test).toArray()));
    }
}
