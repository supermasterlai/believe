package sort;

import java.util.Arrays;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        //已经全部有序则直接结束
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            //从后往前相邻两个比较，一趟排序确定一个i位置
            for (int j = arr.length-1; j >i ; j--) {
                flag = false;
                if (arr[j-1]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = true;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        bubbleSort(arr);
    }
}
