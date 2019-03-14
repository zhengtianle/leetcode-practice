package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-14
 * @Author ZhengTianle
 * Description:
 * 二叉树的下一个节点
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class FiftySeven {
    /**
     * 根
     * 左
     * 右
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        ///二叉树为空
        if(pNode == null) {
            return null;
        }
        //有右孩子
        if(pNode.right != null) {
            return left(pNode.right);
        }
        //左子树,没有右孩子,返回父节点
        //右子树，没有右孩子，返回其祖宗节点（是某个节点的左孩子）的父节点
        while(pNode.next != null) {
            if(pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }

    public TreeLinkNode left(TreeLinkNode node) {
        TreeLinkNode p = node;
        while(p.left != null) {
            p = p.left;
        }
        return p;
    }
}
