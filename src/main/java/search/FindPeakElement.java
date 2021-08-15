package search;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindPeakElement {
    //寻找峰值
    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int x = findPeakElementOne(nums);
        log.info(String.valueOf(x));
    }
    public static int check(int[] nums){
        //为空或为0
        if (nums == null || nums.length == 0) return -1;
        //只有一个或第一个数大于后面的数
        if (nums.length == 1 || nums[0] > nums[1]) return 0;
        //返回最后一个数的索引
        if (nums[nums.length -1] > nums[nums.length - 2]) return nums.length - 1;

        return 2;
    }
    //暴力法 循环寻找峰值
    public static int findPeakElementOne(int[] nums) {
        if (check(nums) == 2){
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        } else {
            return check(nums);
        }
        return -1;
    }
    //二分法，寻找峰值
    public static int findPeakElementTwo(int[] nums) {
        //如果数组为空或者长度为0则返回-1
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid+1]) {
                return mid;
            } else if(nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    //递归二分
    public static int findPeakElementThree(int[] nums) {
        return search(nums,1,nums.length);
    }
    public static int search(int[] nums,int left,int right) {
        if (left == right) {
            return left;
        }
        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[mid + 1]) return search(nums,left,mid);

        return search(nums,mid + 1,right);
    }
}
