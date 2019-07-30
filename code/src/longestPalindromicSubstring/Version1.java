package longestPalindromicSubstring;


/**
 * created by tianfeng on 2019/7/30
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 版本：1
 * 状态：通过
 * 思路：中心扩展法，如字符串abbc，它有7个扩展点a#b#b#c，字符本身位置以及两个字符之间的位置。
 * 从扩展点想两旁扩展，如果记录所有以扩展点为中心的最长回文子字符串，最终得出最长回文子串。
 */
public class Version1 {
    public String longestPalindrome(String s) {
        if (s.equalsIgnoreCase(""))return "";
        double index = 0;
        int length = 1;
        for (double i=0;i<s.length();i=i+0.5){
            int len = palindromeLength(s,i);
            if (len>length){
                length = len;
                index = i;
            }
        }
        return getStringFromIndex(s,index,length);
    }
    private int palindromeLength(String s,double index){
        int length;
        if (index==(int)index)length=1;
        else length=0;
        for (int i=1;;i++){
            int before = (int)Math.ceil(index-i);
            int after = (int)Math.floor(index+i);
            if (before<0||after<0)break;
            if (before>=0&&after<s.length()&&s.charAt(before)==s.charAt(after)){
                length +=2;
            }else {
                break;
            }
        }
        return length;
    }

    private String getStringFromIndex(String s,double index,int length){
        int start = (int)Math.ceil(index)-length/2;
        if (start>=0)return  s.substring(start,start+length);
        else return s.substring(0,1);

    }

    public static void main(String[] args) {
        Version1 v = new Version1();
        System.out.println(v.longestPalindrome("cbbd"));
    }
}
