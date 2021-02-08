package sort;

import java.util.Arrays;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class ShellSort {

    /**
     * 8 9 1 7 2  3 5 4 6 0
     * [8,3][9,5][1,4][7,6][2,0]
     * 3 5 1 6 0 8 9 4 7 2
     * [3,1,0,9,7] [5,6,8,4,2]
     * 0 2 1 4 3 5 7 6 9 8
     */
    public static void shellSort(int[] arr) {
        //增量序列5-2-1
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            //对每组交替进行插入排序
            for (int i = increment; i < arr.length; i++) {
                insertI(arr, increment, i);
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("------------------");
        }
    }

    private static void insertI(int[] arr, int increment, int i) {
        int temp = arr[i];
        int j;
        //插入排序
        for (j = i - increment; j >= 0 && temp < arr[j]; j -= increment) {
            //右移
            arr[j + increment] = arr[j];
        }
        //循环结束为-increment
        arr[j + increment] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
    }
}
