package codingInterviews;

import java.net.CookieHandler;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-16
 * @Author ZhengTianle
 * Description:
 * 二叉搜索树的第K个节点
 * https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class SixtyTwo {
    /**
     * 中序遍历就是排序好的节点
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k <= 0) {
            return null;
        }
        int count = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || pRoot != null) {
            if(pRoot != null) {
                //一直向左
                stack.addFirst(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.removeFirst();
                count++;
                if(count == k) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
