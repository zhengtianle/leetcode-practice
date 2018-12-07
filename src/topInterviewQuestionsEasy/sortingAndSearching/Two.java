package topInterviewQuestionsEasy.sortingAndSearching;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-3
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/53/
 */
public class Two extends VersionControl{
    public int firstBadVersion(int n) {
        long low = 1;
        long high = n;
        long mid = (low + high) >> 1;
        while(low <= high){
            if(!isBadVersion((int)mid))
                low = mid + 1;
            else
                high = mid - 1;
            mid = (low + high) >> 1;
        }

        return (int)low;
    }

    public static void main(String[] args) {
        Two two = new Two();
        System.out.println(two.firstBadVersion(2126753390));
    }
}
