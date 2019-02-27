package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-27
 * @Author ZhengTianle
 * Description:
 * 二叉搜索树的后序遍历序列
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class TwentyThree {
    /**
     * 二叉搜索树：必须满足 右孩子>根节点>左孩子
     * 后序遍历最后一个元素为root
     * 从前向后遍历第一个大于root的元素，左边为根节点的左子树，此元素和其右边（不包括root）为右子树
     * 递归判断左右子树
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        return judge(sequence, 0, sequence.length-1);
    }

    public boolean judge(int[] array, int start, int root) {
        if(start >= root) {
            return true;
        }
        int i;
        //找出从左到右第一个大于根节点值的节点下标i
        for(i = start; i < root; i++) {
            if(array[i] > array[root]) {
                break;
            }
        }
        //如果i后面的元素值有一个小于根节点元素值，则返回false
        for(int j = i+1; j < root; j++) {
            if(array[j] < array[root]) {
                return false;
            }
        }
        //递归判断左右子树
        return judge(array, start, i - 1) && judge(array, i, root - 1);
    }
}
