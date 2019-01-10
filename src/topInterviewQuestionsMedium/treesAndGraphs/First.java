package topInterviewQuestionsMedium.treesAndGraphs;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-10
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/85/
 * 中序遍历二叉树
 */
public class First {

    //递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    //迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                //先压栈左边
                stack.push(cur);
                cur = cur.left;
            } else {
                //出栈入list并遍历右节点
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        return list;
    }
}
