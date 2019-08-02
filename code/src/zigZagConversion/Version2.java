package zigZagConversion;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;

/**
 * created by tianfeng on 2019/7/31
 *
 * 版本 2
 * 状态：通过，效率较高
 * 思路：根据官方题解一进行了优化
 * 优化细节：①numRows=1时，直接返回s。②Map+BlockingQueue变为List+StringBuilder ③好优美的代码：index += change?1:-1
 */
public class Version2 {
    public String convert(String s,int numRows){
        if (numRows==1)return s;
        List<StringBuilder> slist = new ArrayList<>();
        boolean change = false;
        int index = 0;
        for (int i=0;i<Math.min(numRows,s.length());i++){
            slist.add(new StringBuilder());
        }

        for (int i=0;i<s.length();i++){
            if(index==0||index==numRows-1){
                change = !change;
            }
            slist.get(index).append(s.charAt(i));
            index += change?1:-1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder ss :
                slist) {
            result.append(ss);
        }
        return result.toString();

    }
}
