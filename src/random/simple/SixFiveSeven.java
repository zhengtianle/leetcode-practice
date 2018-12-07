package random.simple;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * https://leetcode-cn.com/problems/robot-return-to-origin/description/
 * Author: ZhengTianle
 */
public class SixFiveSeven {

    public static boolean judgeCircle(String moves) {
        //初始为水平垂直中心点
        int horizontal = 0;
        int vertical = 0;
        char word;
        for(int i = 0; i < moves.length(); i++){
            word = moves.charAt(i);
            switch (word){
                case 'U':vertical++;break;
                case 'D':vertical--;break;
                case 'R':horizontal++;break;
                case 'L':horizontal--;break;
            }
        }

        return (horizontal == 0 & vertical ==0);
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UL"));
    }
}
