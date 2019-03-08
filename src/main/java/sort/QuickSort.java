package sort;

import java.util.Arrays;


/**
 * 快速排序
 * 选取基准值，一般选第一个数，从后往前找，找到比基准值小的，与基准值调换位置
 * 调换位置后，从前往后找，找到比基准值大的交换位置，
 * 如果完成第一次查找，结果为 基准值前为比它小的数，基准值后为比它大的数，但前后的数都是无序的
 * 针对前后数再递归调用排序方法，直到排序完成
 *
 *
 *
 */
public class QuickSort {

    public static void main(String[] args){

        int[] a = {1,5,45,-2,-44,3,20,8,11,-7};

        System.out.println(Arrays.toString(a));

        quickSort(a);

        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] data) {
        if(data.length > 0){
            quickSubSort(data,0,data.length-1);
        }

    }


    /**
     *
     * @param data
     * @param low   最小下标
     * @param high  最高小标
     */
    private static void quickSubSort(int[] data, int low, int high) {
        // 定义基准值
        int base  = data[low];
        //定义开始下标
        int start = low;
        //定义结束下标
        int end = high;

        while(end > start){
            //从后往前找，找到比基准值大的 放过，让下标减1 ，直到找到比base小的下标 end
            while(end > start && data[end] >= base){
                end --;
            }
            // 找到比base小的下标，与base交换位置
            if(end > start && data[end] < base){
                swap(data,start,end);
            }
            //开始从前往后找，找到比基准值小的放过，让start下标加1，直到找到比base大的下标 end

            while(end > start && data[start] <= base){
                start ++;
            }

            // 找到比base大的下标，与base交换位置
            if(end > start && data[start] > base){
                swap(data,start,end);
            }
        }
        //第一次循环后 开始递归调用
        //基准值前的数
        if(start > low){
            quickSubSort(data,low,start-1);
        }
        //基准值后的数
        if(end < high){
            quickSubSort(data,end+1,high);
        }




    }

    /**
     * 交换位置
     * @param data
     * @param start
     * @param end
     */
    private static void swap(int[] data, int start, int end) {

        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;

    }


}
