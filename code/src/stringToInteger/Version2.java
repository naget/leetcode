package stringToInteger;

/**
 * created by tianfeng on 2019/8/5
 * 版本：2
 * 状态：通过
 * 思路：①剔除首部的空格字符（可能发生下标越界，直接catch，返回0）②读取正负号③读取整数部分（溢出控制）
 */
public class Version2 {
    public int myAtoi(String str) {
        try {
            while (str.charAt(0)==' ')str = str.substring(1,str.length());
            boolean flag = false;
            if (str.charAt(0)=='-'){
                flag=true;
                str = str.substring(1,str.length());
            }
            else if (str.charAt(0)=='+'){
                str = str.substring(1,str.length());
            }
            int rev = 0;
            for (int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if (c<48||c>=58)break;
                if (!flag&&(rev>Integer.MAX_VALUE/10||rev==Integer.MAX_VALUE/10&&((c-48)>Integer.MAX_VALUE%10)))return Integer.MAX_VALUE;
                if (flag&&(-rev<Integer.MIN_VALUE/10||-rev==Integer.MIN_VALUE/10&&(-(c-48)<Integer.MIN_VALUE%10)))return Integer.MIN_VALUE;
                rev = 10*rev+c-48;
            }
            return flag?-rev:rev;
        }catch (Exception e){
            return 0;
        }

    }

    public static void main(String[] args) {
        Version2 v=new Version2();
        System.out.println(v.myAtoi("2147483646"));
    }
}
