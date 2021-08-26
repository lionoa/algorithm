package array;

import java.util.Arrays;

/**
 * 回文数
 */
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        // x 小于 0 或者 最后一位是 0 但是 不包括 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return true;
        }
        // 用一个数等于 x 反转的数，反转一半比较 相等 或者 y除以10 相等
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return x == y || x == y / 10;
    }
    // 完全反转
    public static boolean isPalindrome_two(int x) {
        int z = x; // 用来保存x
        int y = 0; // 保存反转后的数
        if (x < 0) {
            return false;
        }
        int flag;
        while (x != 0) {
            flag = x % 10;
            y = y * 10 + flag;
            x = x / 10;
        }
        return z == y;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome_two(12321);
        System.out.println(palindrome);
    }
}
