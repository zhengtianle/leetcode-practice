package codingInterviews;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-28
 * @Author ZhengTianle
 * Description:
 * 二叉树中和为某一值的路径
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class TwentyFour {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> innerList = new ArrayList<>();
        if(root == null) {
            return list;
        }
        findPath(root, target, list, innerList);
        return list;
    }

    private void findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> innerList) {
        if(root == null) {
            return ;
        }
        innerList.add(root.val);
        target = target - root.val;
        if(target == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(innerList));
        }

        findPath(root.left, target, list, innerList);
        findPath(root.right, target, list, innerList);
        innerList.remove(innerList.size()-1);
    }


}
