package array;

/**
 * 求最大数组子序和
 * 一个数组，其子数组中最大的和
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int count = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            count = count > 0 ? count + nums[i] : nums[i];
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, 2, -1, 2, -9, 221, 3, 2, 4}));
    }
}
