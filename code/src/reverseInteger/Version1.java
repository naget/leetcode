package reverseInteger;

/**
 * created by tianfeng on 2019/8/3
 * 版本：1
 * 状态：通过
 * 思路：初始化result=0,result=10*result+最后的一个数。
 * 出错点：①base溢出  ②result溢出
 * 改正措施:①base如果大于1000000000,循环结束 ②result如果溢出，返回零
 */
public class Version1 {
    public int reverse(int x) {
        boolean f = false;
        if (x < 0) {
            int tem = x;
            x = -x;
            f = !f;
            if (-x != tem) {
                return 0;
            }
        }
        int base = 1;
        int result = 0;
        while (base != 0 && base <= 1000000000 && x / base != 0) {
            int number = (x / base) % 10;
            int tem = result * 10 + number;
            if ((tem - number) / 10 != result) return 0;
            result = result * 10 + number;
            base = base * 10;
        }
        if (f) result = -result;
        return result;

    }


    public static void main(String[] args) {
        Version1 v = new Version1();
        System.out.println(v.reverse(1534236469));
    }
}
