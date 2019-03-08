package sort;

import java.util.Arrays;

/**
 * 归并排序，二分归并
 * 新建临时数组，将左右数组同时比较，小的放入临时数组中
 * 一旦有某一数组比较完成，则将剩下的数组全放到临时数组中
 * 两个循环只会走一个，因为只有一个数组没有遍历完
 * <p>
 * 最后将临时数组复制回原数组
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] a = {1, 5, 45, -2, -44, 3, 20, 8, 11, -7};

        System.out.println(Arrays.toString(a));

        mergeSort(a);

        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a) {
        if (a.length > 0) {
            mergeSubSort(a, 0, a.length - 1);
        }


    }

    /**
     * 二分归并
     *
     * @param data
     * @param left
     * @param right
     */
    private static void mergeSubSort(int[] data, int left, int right) {

        if (left >= right) {
            return;
        }

        //获取中间值
        int center = (left + right) / 2;
        //划分成左右2个数组
        mergeSubSort(data, left, center);
        mergeSubSort(data, center + 1, right);
        //开始归并排序
        merge(data, left, center, center + 1, right);


    }

    /**
     * @param data
     * @param leftStart
     * @param leftEnd
     * @param rightStart
     * @param rightEnd
     */
    private static void merge(int[] data, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        //定义循环开始左下标
        int leftIndex = leftStart;
        //定义循环开始右下标
        int rightIndex = rightStart;
        //定义临时数组开始下标
        int tempIndex = 0;
        //定义临时数组
        int[] temp = new int[rightEnd - leftStart + 1];

        //开始循环 ，当左右有任意一方下标达到临界值 停止循环
        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            //比较最小值，将最小值放到临时数组中
            if (data[leftIndex] > data[rightIndex]) {
                temp[tempIndex++] = data[rightIndex++];
            } else {
                temp[tempIndex++] = data[leftIndex++];
            }
        }
        //有一方数组循环完成
        // 一下循环只有其实只有一个执行
        while (leftIndex <= leftEnd) {
            temp[tempIndex++] = data[leftIndex++];
        }

        while (rightIndex <= rightEnd) {
            temp[tempIndex++] = data[rightIndex++];
        }

        //将临时数组复制回原数组

        tempIndex = leftStart;

        for (int element : temp) {
            data[tempIndex++] = element;
        }
    }

}
