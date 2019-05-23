package random.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-5-21
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * Z字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Six {

    //尝试模拟Z字排列
    //不同行之间的字母没有顺序可言，换句话说我们只要保证每一行的顺序即可
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        //每一个代表的是一行
        StringBuilder[] sb = new StringBuilder[numRows];
        char[] chars = s.toCharArray();

        for(int i = 0; i < numRows; i++) sb[i] = new StringBuilder();

        int row = 0;
        boolean add = true;
        boolean subtract = false;
        for(int i = 0; i < chars.length; i++) {
            sb[row].append(chars[i]);
            if(add) {
                row++;
            }
            if(subtract) {
                row--;
            }
            if(row >= numRows) {
                add = !add;
                subtract = !subtract;
                row -= 2;
            }
            if(row < 0) {
                add = !add;
                subtract = !subtract;
                row += 2;
            }
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder str : sb) {
            result.append(str.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Six six = new Six();
        System.out.println(six.convert("AB", 1));
    }
}
