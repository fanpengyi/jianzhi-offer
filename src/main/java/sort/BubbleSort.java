package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */

public class BubbleSort {

    public static void main(String[] args){

        int[] a = {1,5,45,-2,-44,3,20,8,11,-7};

        System.out.println(Arrays.toString(a));

        bubbleSort(a);

        System.out.println(Arrays.toString(a));
    }

    /**
     * 冒泡排序
     *
     * @param a
     */

    private static void bubbleSort(int[] a) {
        //控制比较次数
        for (int i = 0; i < a.length -1; i++) {
            // 控制单次对比次数
            for (int j = 0; j < a.length -1; j++) {
                if(a[j+1] < a[j]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }


    }


}
