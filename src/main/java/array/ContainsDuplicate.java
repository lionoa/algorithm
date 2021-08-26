package array;

import java.util.Arrays;

/**
 * 判断数组中是否有重复整数
 * // 排序之后，重复项一定在这个数的边上
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = containsDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(b);
    }
}
