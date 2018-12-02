package trees;

import sun.reflect.generics.tree.Tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-30
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/48/
 */
public class Two {
    /**
     * 刚开始的思路是递归判断左孩子比当前节点小，右孩子比当前节点大
     * 但是这不能保证左子树中的节点值都比当前节点小，右子树中的节点值都比当前节点大
     * 比如[10,5,15,null,null,6,20]就是反例
     *
     * 这里是调用另一个函数，增加形参最大最小值
     * 当递归左子树的时候，要保证左子树所有节点的值都必须比当前节点所能接受的最小值大，比当前节点小
     * 当递归右子树的时候，要保证右子树所有节点的值都必须比当前节点大，比当前节点所能接受的最大值小
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTFunc(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBSTFunc(TreeNode root, long min, long max){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return isValidBSTFunc(root.left, min, root.val) && isValidBSTFunc(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        System.out.println(isValidBST(root));
    }
}
