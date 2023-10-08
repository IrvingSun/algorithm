package cn.sunway.algorithm.easy;

/**
 * @author sunw
 * @date 2023/9/28
 */
public class RomanToInt {

    public int romanToInt(String s) {
        return 0;

    }


    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
