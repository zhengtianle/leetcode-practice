package codingInterviews;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-16
 * @Author ZhengTianle
 * Description:
 * 把二叉树打印成多行
 * https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Sixty {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(pRoot.val);
        result.add(list);

        //当成队列使用
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(pRoot);
        printHelper(queue, result);
        return result;
    }

    private void printHelper(Deque<TreeNode> queue, ArrayList<ArrayList<Integer>> result) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode node = null;
        int len = queue.size();
        while((len--) != 0) {
            node = queue.removeFirst();
            if(node.left != null) {
                queue.addLast(node.left);
                list.add(node.left.val);
            }
            if(node.right != null) {
                queue.addLast(node.right);
                list.add(node.right.val);
            }

        }
        if(list.size() != 0) {
            result.add(list);
            printHelper(queue, result);
        }
    }
}
