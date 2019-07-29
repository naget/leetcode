package longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * created by tianfeng on 2019/7/29
 * 版本：2
 * 状态：通过
 * 思路：官方提供的滑动窗口优化版，其实就是前一个指针不再一个一个移动，而是跳到与第二个元素重复的元素的位置的后一个位置
 */
public class Version2 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.equalsIgnoreCase(""))return 0;
        int max = 1;
        int current=1;
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0,j=0;j<s.length();j++){
            if (map.get(s.charAt(j))!=null)i=Math.max(map.get(s.charAt(j))+1,i);//开始忘记了跟i做比较，导致下边测试用例出错
            map.put(s.charAt(j),j);
            current = j-i+1;
            if (current>max)max=current;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

}
