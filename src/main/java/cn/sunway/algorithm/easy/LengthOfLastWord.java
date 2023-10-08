package cn.sunway.algorithm.easy;

/**
 * 字符串中最后一个单词的长度
 * @author sunw
 * @date 2023/10/8
 */
public class LengthOfLastWord {


    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        // 先去除字符串尾部的空格
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int length = 0;
        // 计算最后一个单词的长度
        while(end >= 0 && s.charAt(end--) != ' ') length++;
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World  "));
    }
}
