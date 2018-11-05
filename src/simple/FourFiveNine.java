package simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-5
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/problems/repeated-substring-pattern/description/
 */
public class FourFiveNine {

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        String substring;
        int subLen;
        boolean flag;
        for(int i = 1; i <= len/2; i++){
            substring = s.substring(0, i);
            subLen = substring.length();
            if(len % subLen != 0){
                continue;
            }
            flag = true;
            for(int j = subLen; j < len; j += subLen){
                if(!substring.equals(s.substring(j, j+subLen))){
                    flag = false;
                    break;
                }
            }

            if(flag){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aabaaba"));
    }
}
