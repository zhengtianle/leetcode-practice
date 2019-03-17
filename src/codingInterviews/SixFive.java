package codingInterviews;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-17
 * @Author ZhengTianle
 * Description:
 * 矩阵中的路径
 * https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e
 *     s f c s
 *     a d e e
 * 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
public class SixFive {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];
        Arrays.fill(visited, false);
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(hasPathHelper(matrix, rows, cols, str, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathHelper(char[] matrix, int rows, int cols, char[] str, int i, int j, int count, boolean[] visited) {
        int index =  i * cols + j;
        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[index] || matrix[index] != str[count]) {
            return false;
        }
        if(count == str.length - 1) {
            return true;
        }
        visited[index] = true;

        if(hasPathHelper(matrix, rows, cols, str, i + 1, j, count+1, visited) ||
                hasPathHelper(matrix, rows, cols, str, i - 1, j, count+1, visited) ||
                hasPathHelper(matrix, rows, cols, str, i, j - 1, count+1, visited) ||
                hasPathHelper(matrix, rows, cols, str, i, j + 1, count+1, visited)) {
            return true;
        }
        visited[index] = false;
        return false;
    }
}
