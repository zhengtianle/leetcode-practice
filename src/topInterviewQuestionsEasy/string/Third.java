package topInterviewQuestionsEasy.string;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-15
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/
 */
public class Third {

    public static int firstUniqChar(String s) {
        int len = s.length();
        char[] words = s.toCharArray();
        boolean repeated = false;
        for(int i = 0; i < len; i++){
            repeated = false;
            for(int j = 0; j < len; j++){
                if(i == j)
                    continue;
                if(words[i] == words[j]){
                    repeated = true;
                    break;
                }
            }
            if(!repeated){
                return i;
            }
        }
        return -1;
    }


    public static int anotherFirstUniqChar(String s){
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(s.lastIndexOf(s.charAt(i)) == s.indexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("lovveleettcocdde"));
        System.out.println(anotherFirstUniqChar("z"));
    }
}
