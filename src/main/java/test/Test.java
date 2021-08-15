package test;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author lionoa
 */
@Slf4j
public class Test {
    public static void swap(int[] ints) {
        int temp;
        temp = ints[0];
        ints[0] = ints[1];
        ints[1] = temp;
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int[] ints = new int[]{a, b};
        swap(ints);
        log.info(Arrays.toString(ints));
    }
}
