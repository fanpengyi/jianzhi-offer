package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 每次选择最小的数与第一位交换位置
 * 第二次则在除第一位之外的数组，再挑选最小的数，与当前数组的第一位交换位置
 * 以此类推……
 *
 *
 */
public class ChoiceSort {
    public static void main(String[] args){

        int[] a = {1,5,45,-2,-44,3,20,8,11,-7};

        System.out.println(Arrays.toString(a));

        choiceSort(a);

        System.out.println(Arrays.toString(a));
    }

    /**
     *
     * @param data
     */
    private static void choiceSort(int[] data) {
        //循环数组
        for (int i = 0; i < data.length; i++) {
            //假定最小数下标是 0
            int minIndex = i;
            //开始在 minIndex 之后的数里寻找 与之对比 找出最小的值
            for (int j = i+1; j < data.length ; j++) {
                if(data[j] < data[minIndex]){
                    minIndex = j;
                }
            }
            // 如果最小值不是第一个数 就与第一个数交换位置
            if(minIndex > i){
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
            
        }


    }
}
