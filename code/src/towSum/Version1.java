package towSum;

import java.util.Arrays;

/**
 * created by tianfeng on 2019/7/28
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 版本：1
 *
 * 状态：未通过
 *
 * 思路：将数组从小到大排序，取第一个和第n个数（一头一尾），加和如果大于target则大树左移,小于target则小数右移，再做加和与
 * target比较，重复这个过程，直到找到加和等于target的两个数，但这两个数的下标是多少呢？因为我们开始进行了排序，下标发生了变化，所以，开始
 * 的时候我复制了nums数组，但是如果，数组中有重复数字的话，就可能发生错误，比如，下边这个代码会在以下测试用例中发生错误：

 * 输入:
 * [3,3]
 * 6
 * 输出
 * [1,1]
 * 预期结果
 * [0,1]
 */
public class Version1 {
    public int[] twoSum(int[] nums, int target) {
        int[] numsCopy =new int[nums.length];
        for(int i=0;i<nums.length;i++){
            numsCopy[i]=nums[i];
        }
        Arrays.sort(nums);
        int i=0;
        int j = nums.length-1;
        int[] result = new int[2];
        while(i<j){
            int tem = nums[i]+nums[j];
            if(tem==target){
                result[0]=i;
                result[1]=j;
                for(int x=0;x<nums.length;x++){
                    if(numsCopy[x]==nums[result[0]])result[0] = x;
                    else if(numsCopy[x]==nums[result[1]])result[1]=x;
                }
                return result;
            }else if(tem<target)i++;
            else j--;
        }
        for(int x=0;x<nums.length;x++){
            if(numsCopy[x]==nums[result[0]])result[0] = x;
            else if(numsCopy[x]==nums[result[1]])result[1]=x;
        }
        return result;
    }
}
