package topInterviewQuestionsEasy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-11-12
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
 */
public class Six {

    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int temp;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(len1 <= len2){
            for(int i = 0; i < len1; i++){
                for(int j = 0; j < nums2.length; j++){
                    if(nums1[i] == nums2[j]){
                        list.add(nums1[i]);
                        nums2 = Arrays.copyOfRange(nums2, j + 1, nums2.length);
                        break;
                    }

                }
            }
        } else {
            for(int i = 0; i < len2; i++){
                for(int j = 0; j < nums1.length; j++){
                    if(nums2[i] == nums1[j]){
                        list.add(nums2[i]);
                        nums1 = Arrays.copyOfRange(nums1, j + 1, nums1.length);
                        break;
                    }

                }
            }
        }

        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{1,1})));
    }
}
