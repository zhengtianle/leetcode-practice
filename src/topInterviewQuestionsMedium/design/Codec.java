package topInterviewQuestionsMedium.design;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-1-25
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/52/design/109/
 * 二叉树的序列化与反序列化
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);
        TreeNode node = new TreeNode(0);//temp
        while(!stack.isEmpty()){
            node = stack.pop();
            if(node != null){
                sb.append(node.val+",");
                stack.push(node.right);
                stack.push(node.left);
            } else {
                sb.append("null,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Stack<TreeNode> stack = new Stack<>();
        String[] s = data.split(",");
        TreeNode root;
        TreeNode node;//temp
        boolean right = false;
        if(!s[0].equals("null")){
            root = new TreeNode(Integer.parseInt(s[0]));
            stack.push(root);
            for(int i = 1; i < s.length; i++){
                if(!right){
                    node = stack.peek();
                    if(!s[i].equals("null")){
                        right = false;
                        TreeNode temp = new TreeNode(Integer.parseInt(s[i]));
                        node.left = temp;
                        stack.push(temp);
                    } else {
                        right = true;//下一个循环该右孩子
                    }
                } else {
                    node = stack.pop();
                    if(!s[i].equals("null")){
                        right = false;
                        TreeNode temp = new TreeNode(Integer.parseInt(s[i]));
                        node.right = temp;
                        stack.push(temp);
                    } else {
                        right = true;//下一个循环该右孩子
                    }
                }
            }
            return root;
        } else {
            return null;
        }
    }
}
