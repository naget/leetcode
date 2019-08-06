package palindromeNumber;

/**
 * created by tianfeng on 2019/8/5
 * 版本：1
 * 状态：通过
 * 思路：计算出倒序对应的数，比较两个数是否相等，相等则是回文数
 */
public class Version1 {
    public boolean isPalindrome(int x) {
        int tem = x;
        if (x < 0) return false;
        int rev = 0;
        while (x > 0) {
            int pop = x % 10;
            rev = 10 * rev + pop;
            x /= 10;
        }
        return tem == rev;

    }

    public static void main(String[] args) {
        Version1 v = new Version1();
        System.out.println(v.isPalindrome(121));
    }
}
