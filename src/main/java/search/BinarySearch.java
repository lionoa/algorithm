package search;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearch {
    public static void main(String[] args) {
        //目标数组
        int[] nums = new int[]{-1,0,3,5,9,12};
        //目标值
        int target = 9;
        int x = binarySearch(nums, target);
        log.info(String.valueOf(x));

        log.info(String.valueOf(mySqrt(target)));

        int[] ints = new int[]{4,5,6,7,8,0,1,2};
        int i = search(ints,8);
        log.info(String.valueOf(i));
        int min = search1(ints);
        log.info(String.valueOf(min));
    }

    //最基本的二分查找方法
    public static int binarySearch(int[] nums, int target) {
        //如果传入的数组长度为0，则直接返回-1
        //先判断是否为空，再判断长度是否为0 因为||可能会短路 导致null放在后面无法判断
        if (nums == null || nums.length == 0) return -1;

        //先定义左右的索引
        int left = 0;
        int right = nums.length - 1;

        //如果left > right 则说明已经该目标数不在该数组中
        while (left <= right) {
            //不使用 （left+right）防止数据过大导致溢出
            int mid = left + (right - left)/2;

            if (nums[mid] == target) {

                return mid;

            }else if (nums[mid] > target) {

                right = mid - 1;

            } else if (nums[mid] < target) {

                left = mid + 1;

            }
        }
        return -1;
    }
    //使用二分查找求 x 的算术平方根
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        //定义一个变量存储答案，减少if else的次数
        int ans = -1;

        while(left <= right) {
            //正常取中值
            int mid = left + (right - left) / 2;
            //防止数据溢出
            if ((long)mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    //二分查找 搜索旋转排序数组
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            //判断是否是有序的
            //前半段有序
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                //后半段有序
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }
    //二分搜索旋转排序数组，返回最小值
    public static int search1(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l< r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
