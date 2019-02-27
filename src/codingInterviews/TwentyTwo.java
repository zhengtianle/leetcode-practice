package codingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-27
 * @Author ZhengTianle
 * Description:
 * 从上往下打印二叉树
 * https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class TwentyTwo {
    /**
     * 借助队列
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            if(tmp.left != null) {
                queue.offer(tmp.left);
            }
            if(tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        return list;
    }
}