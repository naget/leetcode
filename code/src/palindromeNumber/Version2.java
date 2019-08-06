package palindromeNumber;

/**
 * created by tianfeng on 2019/8/6
 * 版本：2
 * 状态：通过
 * 思路：参考官方题解，只需要弹出一半的数字，比较是否相等
 */
public class Version2 {
    public boolean isPalindrome(int x) {
        int tem = x;
        if(x<0||x%10==0&&x!=0)return false;
        int rev = 0;
        while(x>rev){
            int pop = x%10;
            rev = 10*rev+pop;
            x /=10;
        }
        return rev==x||x==rev/10;
    }
}
