package zigZagConversion;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * created by tianfeng on 2019/7/31
 *
 * 版本：1
 * 状态：通过，但是效率低（执行用时 :96 ms, 在所有 Java 提交中击败了10.51%的用户；内存消耗 :51.4 MB, 在所有 Java 提交中击败了40.92%的用户）
 * 思路：遍历字符串s，就可以确定每个元素在哪一行，每一行的元素装入同一个队列中。最后把队列中的元素依次打印出来。
 */
public class Version1 {
    public String convert(String s, int numRows) throws InterruptedException {
        Map<String,LinkedBlockingQueue<Character>> map = new HashMap<>();
        boolean operation = false;
        int index = 0;
        for (int i = 0;i<numRows;i++){
            map.put("queue"+i,new LinkedBlockingQueue<>());
        }
        for (int i = 0;i<s.length();i++){
            if (numRows!=1&&(index==0||index==numRows-1)){
                operation = !operation;
            }
            map.get("queue"+index).put(s.charAt(i));
            if (operation)index++;
            else if (numRows!=1)index--;
        }
        StringBuilder result = new StringBuilder();
        for (int i=0;i<numRows;i++){
            LinkedBlockingQueue<Character> queue = map.get("queue"+i);
            while (queue.size()!=0){
                result.append(queue.take());
            }
        }
        return result.toString();

    }

    public static void main(String[] args) throws InterruptedException {
        Version1 v = new Version1();
        System.out.println(v.convert("AB",1));
    }

}
