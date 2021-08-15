package sort;

import java.util.Random;

public class IntArray {
    private IntArray() {
        throw new IllegalStateException("Utility class");
    }
    /**
     *
     * @param i - 传递一个int类型变量
     * @return - 返回一个int类型数组
     */
    public static int[] arrays(int i){
        int[] arr = new int[i];
        for (int j = 0; j < i; j++){
            arr[j] = (new Random().nextInt() * i);
        }
        return arr;
    }
}
