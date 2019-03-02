package codingInterviews;



/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-2
 * @Author ZhengTianle
 * Description:
 * 二叉搜索树与双向链表
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class TwentySix {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null || (pRootOfTree.right == null && pRootOfTree.left == null)) {
            return pRootOfTree;
        }
        TreeNode left = convertLeft(pRootOfTree.left);
        if(left != null) {
            left.right = pRootOfTree;
        }
        pRootOfTree.left = left;

        TreeNode right = convertRight(pRootOfTree.right);
        if(right != null) {
            right.left = pRootOfTree;
        }
        pRootOfTree.right = right;

        TreeNode head = pRootOfTree;
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }

    //返回最后一个节点
    public TreeNode convertLeft(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) {
            return root;
        }
        TreeNode left = convertLeft(root.left);
        if(left != null) {
            left.right = root;
        }
        root.left = left;

        TreeNode right = convertRight(root.right);
        if(right != null) {
            right.left = root;
        }
        root.right = right;

        TreeNode head = root;
        while(head.right != null) {
            head = head.right;
        }
        return head;
    }

    //返回第一个节点
    public TreeNode convertRight(TreeNode root) {
        return Convert(root);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     *
     * @param root 根节点
     * @param left 双向链表的最左节点
     * @param right 双向链表的最右节点
     * @return 双向链表的最左节点
     */
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode convert1(TreeNode root) {
        if(root == null) {
            return root;
        }
        convert1(root.left);
        root.left = right;
        if(right != null) {
            right.right = root;
        }
        right = root;//更新最右节点
        left = left == null ? root : left;
        convert1(root.right);
        return left;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //注意这种写法不对，分析一下就知道了

    public TreeNode convert(TreeNode root, TreeNode left, TreeNode right) {
        if(root == null) {
            return root;
        }
        convert(root.left, left, right);
        root.left = right;
        if(right != null) {
            right.right = root;
        }
        right = root;//更新最右节点
        left = left == null ? root : left;
        convert(root.right, left, right);
        return left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode six = new TreeNode(6);
        TreeNode oneFour = new TreeNode(14);
        TreeNode four = new TreeNode(4);
        TreeNode eight = new TreeNode(8);
        TreeNode oneTwo = new TreeNode(12);
        TreeNode oneSix = new TreeNode(16);
        root.left = six;
        root.right = oneFour;
        six.left = four;
        six.right = eight;
        oneFour.left = oneTwo;
        oneFour.right = oneSix;
        TwentySix obj = new TwentySix();
        obj.convert(root,null,null);
    }

}
