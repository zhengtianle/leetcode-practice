package topInterviewQuestionsMedium.treesAndGraphs;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-11
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/90/
 * 岛屿的个数
 */
public class Six {
    /**
     * 遍历每个元素，遇到'1'则递归的判断此点上下左右的元素的值，若周围有值为'1'的将其赋为0，直至周围全为'0'
     */
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        recursion(grid, i - 1, j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        recursion(grid, i, j - 1);
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == '1') {
                        recursion(grid, i + 1, j);
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == '1') {
                        recursion(grid, i, j + 1);
                    }
                }
            }
        }

        return result;
    }

    public void recursion(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i > 0 && grid[i - 1][j] == '1') {
            recursion(grid, i - 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            recursion(grid, i, j - 1);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            recursion(grid, i + 1, j);
        }
        if (j < grid[i].length - 1 && grid[i][j + 1] == '1') {
            recursion(grid, i, j + 1);
        }
    }

    /**
     * 网友的写法，较上面的写法更简洁明了一些
     * 思路类似，都是采用深度优先遍历
     */
    public int numIslands1(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    public void dfs(char[][] grid, int i, int j){
        //超出边界或者不是岛屿
        if(i < 0 || j < 0 || i >= grid[i].length || j >= grid.length || grid[i][j] == '0')
            return ;
        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

}
