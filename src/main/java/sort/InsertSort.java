package sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
@Slf4j
public class InsertSort {
    //插入排序
    public static void insertSort(int[] nums) {
        int temp;
        for (int i = 1; i < nums.length; i++) {
            //每次从最后一个数开始插入排序
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{ 1,5,8,3,7,2,0,10};
        insertSort(ints);
        log.info(Arrays.toString(ints));
        insertionSort(ints);
        log.info(Arrays.toString(ints));
    }

    public static void insertionSort(int[] nums) {
        //希尔排序 是不稳定的 也是一种插入排序
        int temp;
        for (int grep = nums.length / 2; grep > 0; grep /= 2) {//设置增量 每次增量变为原来的二分之一，最后增量一定为1
            for (int i = grep; i < nums.length; i++) {
                for (int j = i - grep; j > 0; j-= grep) {
                    if (nums[j] > nums[j + grep]) {
                        temp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = temp;
                    }
                }
            }
        }
    }
}
