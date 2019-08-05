package stringToInteger;

/**
 * created by tianfeng on 2019/8/5
 * 版本：1
 * 状态：未通过
 * 思路：通过 d=c-48转换数字字符，跳过其他字符
 * 未通过原因：没有读懂题目（题目要求连续数字，而我转换了所有数字）
 * 经验：如果题目较长，不要急着做题，读懂题是成功的一半
 */
public class Version1 {
    public int myAtoi(String str) {
        int rev = 0;
        boolean flag = false;
        boolean continueflag = true;
        for(int i=0;i<str.length();i++){
            if (continueflag&&str.charAt(i)==' ')continue;
            else if(continueflag&&(str.charAt(i)<48||str.charAt(i)>=58)&&str.charAt(i)!='-'&&str.charAt(i)!='+')return 0;
            else {
                continueflag=false;
            }
            if(str.charAt(i)=='-'&&rev==0)flag=true;
            if(str.charAt(i)>=48&&str.charAt(i)<58){
                if(!flag&&(rev>Integer.MAX_VALUE/10||rev==Integer.MAX_VALUE/10&&(str.charAt(i)-48)<=Integer.MAX_VALUE%10))return Integer.MAX_VALUE;
                if(flag&&(-rev<Integer.MIN_VALUE/10||-rev==Integer.MIN_VALUE/10&&(str.charAt(i)-48)>=Integer.MIN_VALUE%10))return Integer.MIN_VALUE;
                rev = rev*10+str.charAt(i)-48;
            }

        }
        return flag?-rev:rev;
    }

    public static void main(String[] args) {
        Version1 V=new Version1();
        System.out.println(V.myAtoi("words and 987"));
    }
}
