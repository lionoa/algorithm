package search;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstBadVersion {
    public static boolean isBadVersion(int x) {
        //第四个版本是坏版本
        return x >= 4;
    }
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int i = firstBadVersion(9);
        log.info(String.valueOf(i));
    }
}
