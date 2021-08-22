package sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author lionoa
 */
@Slf4j
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = IntArray.arrays(100);
        long start = System.currentTimeMillis();
        bubbleSortMethod(arr,arr.length);
        long end = System.currentTimeMillis();
        log.info(Arrays.toString(arr));
        log.info(String.valueOf(end - start));
    }

    /**
     * 设置flag标志，如果某一次发生了交换则为true，否则为false，
     * @param ints - int型数组
     * @param n - 传递数组的长度
     */
    public static void bubbleSortMethod(int[] ints,int n){
        int i;
        int j = n;
        boolean flag = true;
        while (flag){
            flag = false;
            for (i = 1; i < j;i++){
                if (ints[i -1] > ints[i]){
                    int temp;
                    temp = ints[i-1];
                    ints[i-1] = ints[i];
                    ints[i] = temp;
                    flag = true;
                }
            }
            j--;
        }
    }
}
