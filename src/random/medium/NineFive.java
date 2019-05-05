package random.medium;


import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-5
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class NineFive {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    /**
     * 以每个节点为根节点递归求取左右子树
     * 拿到这个节点的左右子树根节点集合时（这个节点的左子树和右子树应该也会有很多种，存储他们的根节点集合即可）
     * 遍历左子树根节点和右子树根节点，把他们的组合根节点置为当前节点
     * 最后即可得出答案
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<TreeNode>();
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if(start > end) {
            res.add(null);
            return res;
        }
        //每个节点都可以当做根节点
        for(int i = start; i <= end; i++) {
            //左子树根节点集合
            List<TreeNode> leftRoots = generateTreesHelper(start, i - 1);
            //右子树根节点集合
            List<TreeNode> rightRoots = generateTreesHelper(i + 1, end);
            //进行不同的左右子树组合
            for(TreeNode left : leftRoots) {
                for(TreeNode right : rightRoots) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
