package cn.sunway.algorithm.array;

/**
 * 获取 数组中的字符串 最长公共前缀
 * @author sunw
 * @date 2023/9/21
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs){
        String result = "";
        String template = strs[0];

        for(int i = 1; i <= template.length(); i++){
            String templateResult = template.substring(0, i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].indexOf(templateResult) != 0){
                    return result;
                }
            }
            result = templateResult;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
