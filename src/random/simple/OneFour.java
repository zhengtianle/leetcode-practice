package random.simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @Time 19-4-21
 * @Author ZhengTianle
 * Description:
 */
class OneFour {
    public String longestCommonPrefix(String[] strs) {
        //找出最短的字符串
        String minString = null;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++) {
            if(min > strs[i].length()) {
                minString = strs[i];
                min = strs[i].length();
            }
        }

        if(minString == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i = 0; i < minString.length(); i++) {
            for(int j = 0; j < strs.length; j++) {
                if(minString.charAt(i) != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sb.append(minString.charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
