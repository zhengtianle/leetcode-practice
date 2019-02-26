package codingInterviews;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-26
 * @Author ZhengTianle
 * Description:
 * 树的子结构
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Seventeen {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) {
            return false;
        }
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    /**
     * 判断两棵树是否相同
     */
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        //二棵子树根节点相等
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }
}
