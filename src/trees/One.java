package trees;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-30
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/47/
 */
public class One {

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = 1;
        int rightDepth = 1;
        if(root.left != null)
            leftDepth =  maxDepth(root.left) + 1;
        if(root.right != null)
            rightDepth = maxDepth(root.right) + 1;

        return leftDepth > rightDepth ? leftDepth : rightDepth;

    }

    public static void main(String[] args) {

    }
}
