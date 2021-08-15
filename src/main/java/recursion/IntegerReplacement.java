package recursion;

/**
 * @author lionoa
 * @date 2021/8/15 21:13
 * 给出一个正整数n，如果n为偶数则n = n / 2,如果为奇数则 n = n + 1 或 n = n - 1;
 * 求等于1的最少次数
 **/
public class IntegerReplacement {
    public static void main(String[] args) {
        int replacement = replacement(100);
        System.out.println(replacement);
    }

    /**
     * 递归
     *
     * @param n     正整数
     * @param count 次数
     * @return 返回次数
     */
    public static int replacement(long n, int count) {
        if (n == 1) {
            return count;
        }
        if (n % 2 == 0) {
            return replacement(n / 2, count + 1);
        } else {
            // 直接取最小的就行了，不管内部 +1 -1 是怎么选择的
            return Math.min(replacement(n + 1, count + 1), replacement(n - 1, count + 1));
        }
    }

    /**
     * 使用位运算来得到结果
     *
     * @param n 正整数
     * @return 返回次数
     * 二进制0结尾为偶数，1结尾为奇数
     * 偶数只有除二这种选项
     * 奇数有两种选项，-1 +1 如何选择？
     * 将n转化为二进制，结尾要么01要么11，+1 -1 都是为了将其变为偶数
     * 假设数为1011111,+1 -1 分别为(1100000,1011110)，+1只要一直右移就能得到11，-1则需要右移之后继续处理尾数1
     * 右移比加减更快到达正整数1，所以右移是最优的
     */
    public static int replacement(int n) {
        int count = 0;
        while (n != 1) {
            // 偶数与1永远为0
            if ((n & 1) == 0) {
                // 有符号右移会溢出
                n = n >>> 1;
                count++;
            } else {
                // 进入到这个分支都是奇数
                // 01结尾 -1直接右移两次
                if ((n & 2) == 0) {
                    n -= 1;
                    count++;
                } else {
                    // 11结尾的时候有一个特殊值3，(3-1) / 2 = 1两次 (3 + 1) / 2 / 2 = 1 三次
                    if (n == 3) {
                        // 所以直接+2停止循环
                        count += 2;
                        break;
                    } else {
                        n += 1;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
