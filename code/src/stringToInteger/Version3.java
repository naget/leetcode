package stringToInteger;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by tianfeng on 2019/8/5
 * 版本：3
 * 状态:通过，但耗时高（执行用时 :30 ms, 在所有 Java 提交中击败了9.55%的用户   内存消耗 :38 MB, 在所有 Java 提交中击败了71.24%的用户）
 * 思路：参考题解一行Python代码正则表达式解决问题
 * 问题：java中int有32位的限制，于是正则表达式得到的结果不能强转，使得正则表达式没起多大作用，只是作为一个预处理，
 * 提高的效率没看到，反而耗时较高。
 */
public class Version3 {
    public int myAtoi(String str) {
        str=str.trim();
        int rev = 0;
        Matcher m = Pattern.compile("^[\\+|\\-]?\\d+").matcher(str);
        StringBuilder number = new StringBuilder();
        while (m.find()){
            number.append(m.group());
        }
        if (number.length()<1)return rev;
        boolean flag = false;
        if (number.charAt(0)=='+')number.deleteCharAt(0);
        if (number.charAt(0)=='-'){
            flag=true;
            number.deleteCharAt(0);
        }

        for (int i=0;i<number.length();i++){
            char c = number.charAt(i);
            if (c<48||c>=58)break;
            if (!flag&&(rev>Integer.MAX_VALUE/10||rev==Integer.MAX_VALUE/10&&((c-48)>Integer.MAX_VALUE%10)))return Integer.MAX_VALUE;
            if (flag&&(-rev<Integer.MIN_VALUE/10||-rev==Integer.MIN_VALUE/10&&(-(c-48)<Integer.MIN_VALUE%10)))return Integer.MIN_VALUE;
            rev = 10*rev+c-48;
        }
        return flag?-rev:rev;
    }

    public static void main(String[] args) {
        Version3 v = new Version3();
        v.myAtoi("   -42");
    }
}
