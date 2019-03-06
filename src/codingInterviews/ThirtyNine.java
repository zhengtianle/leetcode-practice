package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-6
 * @Author ZhengTianle
 * Description:
 * 平衡二叉树
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class ThirtyNine {
    /**
     * 平衡二叉树：它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
     * 二叉搜索树/二茬查找树：左子树上节点值都不小于根节点，右子树上节点值都大于根节点
     */

    /**
     * 从上往下递归
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) {
            return true;
        }
        return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) <= 1 &&
                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int TreeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    /**
     * 改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
     * 如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
     */
    public boolean IsBalanced_Solution1(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if(left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if(right == -1) {
            return -1;
        }
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

}
