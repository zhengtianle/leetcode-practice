package codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-2-21
 * @Author ZhengTianle
 * Description:
 * 替换空格
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Two {
    public String replaceSpace(StringBuffer str){
        char[] c = str.toString().toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < c.length; i++){
            if(c[i] == ' '){
                sb.append("%20");
            } else {
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }
}
