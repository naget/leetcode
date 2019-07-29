package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * created by tianfeng on 2019/7/29
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 版本：1
 * 状态：通过
 * 思路：first和second左右两个指针，保证second在first之后,并且两个指针之间的字符无重复。second++直到走到末尾，过程中
 * second-first+1的最大值就是最子串的长度
 */
public class Version1 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.equalsIgnoreCase(""))return 0;
        int first=0;
        int second = 1;
        int max = 1;
        int current=1;
        Set<String> set = new HashSet<>();
        set.add(String.valueOf(s.charAt(first)));
        while(second<s.length()){
            if(!set.add(String.valueOf(s.charAt(second)))){
                while(first<second&&s.charAt(first)!=s.charAt(second)){
                    set.remove(String.valueOf(s.charAt(first)));
                    first++;
                    current--;
                }
                first++;
                current--;
            }
            second++;
            current++;
            if(current>max)max=current;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
