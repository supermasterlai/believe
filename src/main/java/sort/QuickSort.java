package sort;

import java.util.Arrays;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class QuickSort {
    public static void quicksort(int[] array, int low, int high) {
        while (low < high) {
            //分成两个区
            int pivot = partition(array, low, high);
            System.out.println(Arrays.toString(array));
            quicksort(array, low, pivot - 1);
            //尾递归复用了上一行的quicksort(array, low, pivot - 1)，相当于两次递归变成一次递归+一次迭代
            low = pivot + 1;
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            //先从右边开始,把轴点当做temp
            while (low < high && array[high] >= pivot) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot) {
                low++;
            }
            array[high] = array[low];
        }
        //交换轴点分割数组
        array[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] array = {6, 1, 2, 7, 9, 6, 4, 5, 10, 8};
        quicksort(array, 0, array.length - 1);
    }
}
