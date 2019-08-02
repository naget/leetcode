package zigZagConversion;

/**
 * created by tianfeng on 2019/7/31
 * 版本：3
 * 状态：通过
 * 思路：直接copy官方题解二，感觉完全是找规律，但我真找不出来。。。。
 */
public class Version3 {

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
