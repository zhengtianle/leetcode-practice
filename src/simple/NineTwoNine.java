package simple;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * https://leetcode-cn.com/problems/unique-email-addresses/description/
 * Author: ZhengTianle
 */
public class NineTwoNine {

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < emails.length; i++){
            int addIndex;
            int atIndex = emails[i].indexOf("@");
            if(-1 != (addIndex = emails[i].indexOf("+"))){
                //去掉+之后@之前的字符串
                emails[i] = emails[i].substring(0, addIndex)
                        + emails[i].substring(atIndex);
            }
            atIndex = emails[i].indexOf("@");
            emails[i] = emails[i].substring(0, atIndex).replace(".", "")
                    + emails[i].substring(atIndex);
            set.add(emails[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{
                "fxggfzk.fo.q+e@uxbeyetxc.com","fxggfzk.fo.q+h@uxbeyetxc.com","uv+mw.lkw+ybe@yppz.com"
        }));
    }
}
