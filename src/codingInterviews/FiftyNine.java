package codingInterviews;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-14
 * @Author ZhengTianle
 * Description:
 * 按之字形顺序打印二叉树
 * https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，
 * 其他行以此类推。
 */
public class FiftyNine {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(pRoot.val);
        result.add(list);

        stack.addFirst(pRoot);
        rightToLeft(result, stack);
        return result;
    }

    private void leftToRight(ArrayList<ArrayList<Integer>> result, Deque<TreeNode> stack) {
        TreeNode node = null;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> ltrStack = new ArrayDeque<>();
        while(!stack.isEmpty()) {
            node = stack.removeFirst();
            if(node.left != null) {
                list.add(node.left.val);
                ltrStack.addFirst(node.left);
            }
            if(node.right != null) {
                list.add(node.right.val);
                ltrStack.addFirst(node.right);
            }
        }
        if(list.size() != 0) {
            result.add(list);
            rightToLeft(result, ltrStack);
        }
    }

    private void rightToLeft(ArrayList<ArrayList<Integer>> result, Deque<TreeNode> stack) {
        TreeNode node = null;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> rtlStack = new ArrayDeque<>();
        while(!stack.isEmpty()) {
            node = stack.removeFirst();
            if(node.right != null) {
                list.add(node.right.val);
                rtlStack.addFirst(node.right);
            }
            if(node.left != null) {
                list.add(node.left.val);
                rtlStack.addFirst(node.left);
            }
        }
        if(list.size() != 0) {
            result.add(list);
            leftToRight(result, rtlStack);
        }
    }
}
