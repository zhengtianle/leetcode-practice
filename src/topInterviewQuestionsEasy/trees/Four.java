package topInterviewQuestionsEasy.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-2
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/50/
 */
public class Four {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rootList = new ArrayList<List<Integer>>();
        if(root == null)
            return rootList;
        //给根节点创建list
        List<Integer> list = new ArrayList<>();
        //根节点的list加入到rootList
        rootList.add(list);
        //把第二层到最后一层每一层的list都加到rootList里面
        levelOrderFunc(root, rootList, 0);

        return rootList;
    }

    public static void levelOrderFunc(TreeNode root, List<List<Integer>> rootList, int level) {
        List<Integer> list = rootList.get(level);
        list.add(root.val);
        if(root.left != null || root.right != null){
            List<Integer> nextLevelList;
            if(rootList.size() <= level + 1){
                nextLevelList = new ArrayList<>();
                rootList.add(nextLevelList);
            } else {
                nextLevelList = rootList.get(level + 1);
            }
            if(root.left != null)
                levelOrderFunc(root.left, rootList, level+ 1);
            if(root.right != null)
                levelOrderFunc(root.right, rootList, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = null;
        three.left = null;
        three.right = five;

        System.out.println(levelOrder(one).toString());
    }
}
