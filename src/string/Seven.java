package string;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-19
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/38/
 */
public class Seven {
    //求next数组
    public static int[] getNext(char[] p){
        int len = p.length;
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        int j = 0;

        while(j < len - 1){
            //p[k]表示前缀  p[j]表示后缀
            if(k == -1 || p[k] == p[j]){
                j++;
                k++;
                if(p[k] != p[j]){
                    next[j] = k;
                } else {
                    //因为不能出现p[j] == p[next[j]]，所以当出现时需要继续“递归”，k = next[k]
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }

        return next;
    }

    //利用kmp算法求解
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }

        int i = 0;
        int j = 0;
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        //求next数组
        int[] next = getNext(p);

        while(i < s.length && j < p.length){
            //如果j = -1或者当前字符匹配成功
            if(j == -1 || s[i] == p[j]){
                j++;
                i++;
            } else {
                //如果j != -1并且当前字符匹配失败，i步回溯，j=next[j]
                j = next[j];
            }
        }

        if(j == p.length){
            return i - j;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        System.out.println(strStr("aaaaa", "bba"));
    }
}
