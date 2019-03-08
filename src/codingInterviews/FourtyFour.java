package codingInterviews;


/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-3-8
 * @Author ZhengTianle
 * Description:
 * 翻转单词序列
 * https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class FourtyFour {
    public String ReverseSentence(String str) {
        String[] strings = str.split(" ");
        if(strings.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 1; i--) {
            sb.append(strings[i]);
            sb.append(" ");
        }
        sb.append(strings[0]);
        return sb.toString();
    }
}
