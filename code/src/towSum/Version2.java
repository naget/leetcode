package towSum;

import java.util.HashMap;
import java.util.Map;

/**
 * created by tianfeng on 2019/7/28
 *
 * 版本:2
 * 状态:通过
 * 思路：使用一个哈希表，以元素值为key，元素下标为value，将数组中的元素装入hash表，然后遍历，寻找是否
 * 存在一个键为target-nums[i]的记录，如果有，并且不等于i（不是同一个元素），那么找到所求下标
 * i和map.get(target-nums[i])
 */
public class Version2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(map.get(target-nums[i])!=null&&map.get(target-nums[i])!=i){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                return result;
            }
        }
        return result;
    }
}

