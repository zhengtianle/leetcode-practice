package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-16
 * @Author ZhengTianle
 * Description:
 * 序列化二叉树
 * https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SixtyOne {
    private int index = -1;
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val).append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        String[] strings = str.split(",");
        return DeserializeHelper(strings);
    }

    private TreeNode DeserializeHelper(String[] strings) {
        index++;
        if(index >= strings.length) {
            return null;
        }
        TreeNode node = null;
        if(!"#".equals(strings[index])) {
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = DeserializeHelper(strings);
            node.right = DeserializeHelper(strings);
        }
        return node;
    }
}
