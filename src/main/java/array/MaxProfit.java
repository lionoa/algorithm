package array;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxProfit {
    /**
     * 贪心算法
     *
     * @param prices 股票数组
     * @return 返回最大利润
     */
    public static int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                result += (prices[i + 1] - prices[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 4, 5, 3, 8, 9, 2, 10};
        log.info("该股票最大利润为：" + maxProfit(prices));
    }
}
