package sort;

import java.util.Arrays;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        //初始化一个临时空间，减少重复创建
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        //left=right结束递归
//        if (left < right) {
//            //折半递归归并排序
//            int mid = (left + right) / 2;
//            sort(arr, left, mid, temp);
//            sort(arr, mid + 1, right, temp);
//            merge(arr, left, mid, right, temp);
//        }
        //初始跨度为1
        int s = 1;
        while (s < arr.length) {
            for (int i = 0; i < arr.length; i += 2 * s) {
                left = i;
                int mid = left + s - 1;
                if (mid > arr.length - 1) {
                    break;
                }
                right = Math.min(left + 2 * s - 1, arr.length - 1);
                merge(arr, left, mid, right, temp);
            }
            s = s << 1;
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int tempIndex = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        //遍历左右子序列合并至temp
        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[tempIndex++] = arr[leftIndex++];
            } else {
                temp[tempIndex++] = arr[rightIndex++];
            }
        }
        //将剩余元素填充到temp
        while (leftIndex <= mid) {
            temp[tempIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[tempIndex++] = arr[rightIndex++];
        }
        //复制temp至原数组，index需要重置
        tempIndex = 0;
        while (left <= right) {
            arr[left++] = temp[tempIndex++];
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        mergeSort(arr);
        System.out.println("----------------------------------");
        System.out.println(Arrays.toString(arr));
    }
}
