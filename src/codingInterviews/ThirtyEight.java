package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-6
 * @Author ZhengTianle
 * Description:
 * 二叉树的深度
 * https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class ThirtyEight {
    public int TreeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
