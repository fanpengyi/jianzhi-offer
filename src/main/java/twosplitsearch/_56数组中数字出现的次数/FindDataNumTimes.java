package twosplitsearch._56数组中数字出现的次数;

/**
 * 二分法查找一个数字在有序数组中出现的次数
 * 使用二分查找方法 如统计数组{1,2,3,3,3,3,4,5}中3出现的次数
 * 思路：
 * 找到 第一个3出现的下标，找到最后一个3出现的下标 ，二者相减得出个数
 * <p>
 * 步骤：
 * 取中间值center，如果center 大于 3， 则3在中间值前面 在前半段查找 3
 * 如果中间值小于3 ，则在后半段查找 3
 * 如果中间值等于3 则判断 中间值前一个数，如果不是3 则是第一个3的下标，如果是3则继续往前找
 * 同理判断中间值后一个数是不是3 ，如果不是3 则是最后一个3下标，如果是则继续往后找
 */
public class FindDataNumTimes {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 7, 8, 9};
        System.out.println(findDataNumTimes(data, 0, data.length - 1, 1));
        System.out.println(findDataNumTimes(data, 0, data.length - 1, 2));
        System.out.println(findDataNumTimes(data, 0, data.length - 1, 3));
        System.out.println(findDataNumTimes(data, 0, data.length - 1, 4));
        System.out.println(findDataNumTimes(data, 0, data.length - 1, 5));
        System.out.println(findDataNumTimes(data, 0, data.length - 1, 6));
        System.out.println(findDataNumTimes(data, 0, data.length - 1, 10));
    }

    /**
     * 二分法查找
     *
     * @param data
     * @param low
     * @param high
     * @param key  目标值
     */
    private static int findDataNumTimes(int[] data, int low, int high, int key) {
        //查找第一个目标值下标
        int firstIndex = findDataNumTimesFirstIndex(data, low, high, key);
        //查找最后一个目标值下标
        int lastIndex = findDataNumTimesLastIndex(data, firstIndex, high, key);
        return lastIndex - firstIndex + 1;
    }

    /**
     * @param data
     * @param low
     * @param high
     * @param key
     * @return
     */
    private static int findDataNumTimesLastIndex(int[] data, int low, int high, int key) {
        while (low <= high) {
            int center = (low + high) >> 1;
            if (data[center] == key) {
                // 如果中间值的后一个不是目标值，则说明center就是最后一个目标值下标
                if (center == data.length - 1 || data[center + 1] != key) {
                    return center;
                }
                //最后一个目标值在center后则要加大起始下标
                low = center + 1;
            } else if (data[center] > key) {
                high = center - 1;
            } else {
                low = center + 1;
            }
        }
        return 0;
    }
    /**
     * 查找第一个目标值出现的下标
     *
     * @param data
     * @param low
     * @param center
     * @param key
     */
    private static int findDataNumTimesFirstIndex(int[] data, int low, int high, int key) {
        if (low > high) {
            return 0;
        }
        while (low <= high) {
            //中间下标
            int center = (low + high) >> 1;
            // 如果中间值的前一个不是目标值，则说明center就是第一个目标值下标
            if (data[center] == key) {
                if (center == 0 || data[center - 1] != key) {
                    return center;
                }
                //第一个目标值在center前，需要减小 high
                high = center - 1;
            } else if (data[center] > key) {
                high = center - 1;
            } else {
                low = center + 1;
            }
        }
        return 0;
    }
}
