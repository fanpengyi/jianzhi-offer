package tree;

/**
 * 二分法查找 ： 在有序数组中查找特定元素的算法。（有序数组）
 */
public class TwoSplitSearch {

    public static void main(String[] args) {
        int[] data = {-10, -3, 1, 4, 6, 8, 10, 22, 33, 44, 100, 203};

        //存在
        System.out.println(towSplitSearch(data, 0, data.length - 1,4));
        System.out.println(towSplitSearch(data, 0, data.length - 1,9));

    }

    /**
     * 二分查找
     *
     * @param data 有序数组
     * @param from 开始下标
     * @param to   终止下标
     * @param key  目标值
     * @return int 目标值的下标，如果没有返回 -1
     */
    private static int towSplitSearch(int[] data, int from, int to, int key) {

        if (from < 0 || to < 0) {
            return -1;
        }

        // 判断 from 不能大于 to
        if(from <= to ){
            //获取数组中间下标
            int centerIndex = (from + to) / 2;
            //将数组中间值作为基准值比较
            int base = data[centerIndex];
            //目标值比基准值大，则需要往中间下标后查找，起始点为 centerIndex + 1
            if (key > base) {
                from = centerIndex + 1;
                //目标值比基准值小，则需要往中间下标1前查找，终止点为 centerIndex - 1
            } else if (key < base) {
                to = centerIndex - 1;
            } else {
                return centerIndex;
            }
        }else{

            return -1;
        }


        return towSplitSearch(data, from, to, key);

    }


}
