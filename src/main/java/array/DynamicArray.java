package array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class DynamicArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        log.info((Arrays.toString(solution(nums))));
    }

    /**
     * @return int[]
     */
    public static int[] solution(int[] nums){

        //不需要求nums[0],直接从nums[1]开始
        for (int i = 1; i < nums.length; i++){
            nums[i] = nums[i]+nums[i-1];
        }
        return nums;
    }
}
