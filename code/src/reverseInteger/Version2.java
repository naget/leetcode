package reverseInteger;

/**
 * created by tianfeng on 2019/8/5
 * 版本：2
 * 状态：通过
 * 思路：参考官方解答以及解答下边的评论
 * 优点：
 * ①x/=10，这句代码让我们省去了上一个版本记录base以及防止其移除的代码
 * ②使用Integer静态变量，代码可读性增强
 * ③简化步骤，思路清晰
 * ④判断溢出的方法更加科学合理
 */
public class Version2 {
    public int reverse(int x){
        int rev = 0;
        while (x!=0){
            int pop = x%10;
            x /=10;
            if(rev>Integer.MAX_VALUE/10||rev==Integer.MAX_VALUE/10&&pop>Integer.MAX_VALUE%10)return 0;
            if (rev<Integer.MIN_VALUE/10||rev==Integer.MIN_VALUE/10&&pop<Integer.MIN_VALUE%10)return 0;
            rev = 10*rev+pop;
        }
        return rev;
    }
}
