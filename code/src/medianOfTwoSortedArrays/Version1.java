package medianOfTwoSortedArrays;

/**
 * created by tianfeng on 2019/7/29
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 版本：1
 * 状态：通过
 * 思路：借鉴归并排序的思路，查找中位数（分为奇数时和偶数时）。
 */
public class Version1 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = l1+l2;
        if((l&0x01)==0){
            int index1 = l/2;
            int index2 = l/2-1;
            int sum1=0;
            int sum2=0;
            int i=0;
            int j=0;
            int x=0;
            while(i<l1||j<l2){
                if(i>=l1){
                    if(x==index1)sum1=nums2[j];
                    if(x==index2)sum2=nums2[j];
                    j++;
                }else if(j>=l2){
                    if(x==index1)sum1=nums1[i];
                    if(x==index2)sum2=nums1[i];
                    i++;
                }
                else if(nums1[i]<nums2[j]){
                    if(x==index1)sum1=nums1[i];
                    if(x==index2)sum2=nums1[i];
                    i++;
                }
                else {
                    if(x==index1)sum1=nums2[j];
                    if(x==index2)sum2=nums2[j];
                    j++;
                }
                x++;
            }
            return (sum1+sum2)/2.0;
        }else{
            int index = l/2;
            int sum=0;
            int i=0;
            int j=0;
            int x=0;
            while(i<l1||j<l2){
                if(i>=l1){

                    if(x==index){
                        sum=nums2[j];
                        break;
                    }
                    j++;

                }else if(j>=l2){
                    if(x==index){
                        sum = nums1[i];
                        break;
                    }
                    i++;
                }
                else if(nums1[i]<nums2[j]){

                    if(x==index){
                        sum = nums1[i];
                        break;
                    }
                    i++;

                }
                else {

                    if(x==index){
                        sum=nums2[j];
                        break;
                    }
                    j++;

                }
                x++;
            }
            return sum;

        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
