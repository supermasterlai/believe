package sort;

import java.util.Arrays;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        //构建堆
        for (int i = arr.length / 2-1; i >= 0; i--) {
            //叶子节点不需要操作（在父节点过程中已经上浮或者下沉）
            heapAdjust(arr, i, arr.length-1);
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("---------------------");
        //堆内排序
        for (int j = arr.length-1; j > 0; j--) {
            //最后一个未排序的节点与堆顶交换
            swapTop(arr, j);
            heapAdjust(arr, 0, j-1 );
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void heapAdjust(int[] arr, int i, int high) {
        int temp = arr[i];
        //左右节点比较取大者
        for (int k = 2 * i+1; k < high; k =k* 2+1) {
            if (k+1<= high && arr[k] < arr[k + 1]) {
                ++k;
            }
            //父节点大不交换
            if (temp >= arr[k]) {
                break;
            }
            arr[i] = arr[k];
            //记录当前位置
            i = k;
        }
        //外部可以减少赋值次数
        arr[i] = temp;
    }

    private static void swapTop(int[] arr, int j) {
        int temp = arr[0];
        arr[0] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        heapSort(arr);
    }
}
