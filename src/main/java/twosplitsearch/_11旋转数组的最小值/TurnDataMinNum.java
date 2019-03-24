package twosplitsearch._11旋转数组的最小值;

/**
 * offer 11
 * 题目旋转数组的最小数字
 * 把一个数组最开始的元素搬到数组的末尾成为数组的旋转。输入一个递增的排序数组的一个旋转，输出旋转数组的最小元素
 * 如 {3,4,5,1,2} 是{1,2,3,4,5}的一个旋转，该旋转的最小值为1
 * <p>
 * 思路：使用for循环遍历查找时间复杂度为O（n），使用二分法查找为O(logn)
 */
public class TurnDataMinNum {

    public static void main(String[] args) {
        int[] data = {4, 5, 6, 7, 8, 2, 3};
        int[] data2 = {2, 2, 2, 2, 1, 2};
        int[] data3 = {6,7,1,2,3,4,5};
        int[] data4 = {1,0,1,1,1};
        int[] data5 = {1,1,1,0,1};
        System.out.println(findTurnDataMinNum(data));//2
        System.out.println(findTurnDataMinNum(data2));//1
        System.out.println(findTurnDataMinNum(data3));//1
        System.out.println(findTurnDataMinNum(data4));//1
        System.out.println(findTurnDataMinNum(data5));//1
    }
    /**
     * 二分法寻找旋转数组的最小值
     * 3种情况：
     * 中间值 大于 末尾值  4,5,6,7,8,2,3  -> 开始下标 + 1
     * 中间值 等于 末尾值  2 2 2 2 1 2  -> 说明 最小值在末尾值前  末尾值 - 1
     * 中间值 小于 末尾值  6,7,1,2,3,4,5 -> 说明最小值在末尾值前 或者最小值等于末尾值
     * @param data
     */
    private static int findTurnDataMinNum(int[] data) {
        //起始下标
        int low = 0;
        //末尾下标
        int high = data.length - 1;
        int center = 0;
        while (low <= high) {
            //中间下标
            center = (low + high) / 2;
            if (data[center] > data[high]) {
                low = center + 1;
            } else if (data[center] == data[high]) {
                high = high - 1;
            } else {
                high = center;
            }
        }
        //返回的是 最小值
        return data[low];
    }
}
