package medium;

import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * https://leetcode-cn.com/problems/card-flipping-game/description/
 * Author: ZhengTianle
 */
public class EightTwoTwo {

    public static int flipgame(int[] fronts, int[] backs) {
        TreeSet<Integer> goodTreeSet = new TreeSet<>();
        TreeSet<Integer> badTreeSet = new TreeSet<>();
        int length = fronts.length;
        for(int i = 0; i < length; i++){
            if(fronts[i] == backs[i]){
                badTreeSet.add(fronts[i]);
            }else{
                goodTreeSet.add(fronts[i]);
                goodTreeSet.add(backs[i]);
            }
        }
        goodTreeSet.removeAll(badTreeSet);
        if(goodTreeSet.isEmpty()){
            return 0;
        }else{
            return goodTreeSet.first();
        }


    }

    public static void main(String[] args) {
        System.out.println(flipgame(new int[]{1, 1}, new int[]{1, 2}));
    }
}
