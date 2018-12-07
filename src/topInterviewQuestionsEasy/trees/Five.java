package topInterviewQuestionsEasy.trees;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-3
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/51/
 */
public class Five {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        TreeNode node = new TreeNode(nums[nums.length/2]);
        if(nums.length != 1){
            node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length/2));
            node.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length/2 + 1, nums.length));
        }
        return node;
    }
}
