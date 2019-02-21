package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-21
 * @Author ZhengTianle
 * Description:
 * 重建二叉树
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Four {
    /**
     * 前序遍历序列中第一个节点元素为根节点
     * 根据根节点元素在中序遍历序列中的位置，左边为左子树中序遍历序列，右边是右子数中序遍历序列
     * 根据左子树中序遍历序列元素个数依次取前序遍历序列前n个节点为左子树前序遍历序列（不包括第一个节点），其余为右子树前序遍历序列
     * 根据左右子数的前序中序序列递归求得左右子数
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        return rcbt(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    private TreeNode rcbt(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn){
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for(int i = startIn; i <= endIn; i++){
            if(in[i] == pre[startPre]){//在中序遍历序列中找到根节点的位置
                root.left = rcbt(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
                root.right = rcbt(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
                break;
            }
        }
        return root;
    }
}
