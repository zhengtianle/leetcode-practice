package topInterviewQuestionsMedium.arrayAndStrings;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 18-12-8
 * @Author ZhengTianle
 * Description:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/77/
 */
public class Third {

    /*第一个思路，超慢*/
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if(strs.length == 0)
            return list;
        if(strs.length == 1){
            List<String> list1 = new ArrayList<>();
            list1.add(strs[0]);
            list.add(list1);
            return list;
        }
        //把每一个字符串都排一下序：比如ate和eat都会变成aet
        String[] strings = new String[strs.length];
        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            strings[i] = String.valueOf(chars);
        }
        for(int i = 0; i < strs.length; i++){
            if(strs[i] != null){
                List<String> list1 = new ArrayList<>();
                list1.add(strs[i]);
                for(int j = 0; j < strs.length; j++){
                    if(j == i)
                        continue;
                    if(strings[i].equals(strings[j])){
                        list1.add(strs[j]);
                        strs[j] = null;
                    }
                }
                list.add(list1);
            }
        }

        return list;
    }

    /*看了第一名的思路，使用HashMap匹配list*/
    public List<List<String>> anotherGroupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();
        if(strs.length==0){
            return list;
        }
        Map<String,List<String>> types=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] kk=strs[i].toCharArray();
            Arrays.sort(kk);
            String key=new String(kk);
            //用排序后的字符串作为key检索HashMap
            if(!types.containsKey(key)){
                List<String> keys=new ArrayList<>();
                keys.add(strs[i]);
                types.put(key,keys);
                list.add(keys);
            }else{
                types.get(key).add(strs[i]);
            }
        }
        return list;
    }


}
