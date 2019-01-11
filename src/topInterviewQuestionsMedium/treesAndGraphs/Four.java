package topInterviewQuestionsMedium.treesAndGraphs;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-11
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/88/
 * 每个节点的右向指针
 */
public class Four {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null)
            return ;
        //非叶子节点层
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
