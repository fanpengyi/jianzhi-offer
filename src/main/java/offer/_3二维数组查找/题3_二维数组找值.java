package offer._3二维数组查找;


import java.util.Arrays;
import java.util.concurrent.Executors;

/**
 * 1 2 4 6
 * 2 4 4 8
 * 3 4 7 9
 * 5 9 11 16
 * <p>
 * 有规律的二维数组，每一行，从左到右升序，每一列，从上到下升序
 * <p>
 * 以右上角数为基准值，如果目标值比它小则左移，比它大则右移
 * 出了边界则没有
 */
public class 题3_二维数组找值 {


    public static void main(String[] args) {


        int[][] a = {{1, 2, 4, 6}, {2, 4, 4, 8}, {3, 4, 5, 9}, {7, 9, 11, 16}};


        System.out.println(find(a, -1));
       /* System.out.println(find(a, -5));
        System.out.println(find(a, 1));
        System.out.println(find(a, 3));
        System.out.println(find(a, 9));
        System.out.println(find(a, 10));
        System.out.println(find(a, 15));
        System.out.println(find(a, 100));

        System.out.println(find(a, 7));*/


    }

    /**
     * 在二维数组中找这个数是否存在
     *
     * @param data
     * @param target
     * @return 存在返回true ，否则返回 false
     */
    private static boolean find(int[][] data, int target) {

        if (data.length == 0 || data[0].length == 0) {
            return false;
        }
        //列下标
        int col = data[0].length - 1;
        //行下标
        int line = 0;

        int base = data[line][col];
        //基准值与目标值一致则跳出循环
        while (base != target) {
            // 列标最小是0，行标最大是 data[0].length - 1
            if (col >= 0 && line <= data[0].length - 1) {
                if (target > base) {
                    //目标值比基准值大 需要增大行标，如果行标已经是最大了 返回false
                    if (line == data[0].length - 1) {
                        return false;
                    }
                    line++;
                } else {
                    //目标值比基准值小 需要减小列标，如果列标已经是最小了 返回false
                    if (col == 0) {
                        return false;
                    }
                    col--;
                }

                base = data[line][col];
            } else {
                return false;
            }
        }

        return true;
    }


}
