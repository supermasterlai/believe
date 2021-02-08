package question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q3ArrayRepeatNumber {

    public static void main(String[] args) {
        /**
         * hashmap
         * 空间O(n)
         */
//        int[] arr = {2,3,1,0,2,5,3,2};
//        if (arr.length<2){
//            System.out.println("数组长度小于2");
//        }
        // findRepeatNumberByMap(arr);
        /**
         * 长度为n的数组中数字都在0—（n-1）
         * 空间O(1)
         */
//        for (int value : arr) {
//            if (value < 0 || value > arr.length - 1) {
//                System.out.println("有数字不再在0—（n-1）范围内！");;
//            }
//        }
//        findRepeatNumberByCompare(arr);

        /**
         * 如果n+1的数组有1-n区间数据，必有一个重复
         * 划分为[1,m] [m+1,n] 根据划分取原数组中统计出现次数，超过m则在左边，否则在右边（二分法）
         * 时间O(nlogn) 空间O(1)
         */
        // int[] arr = {2,3,1,0,2,5,3,2};
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
        findRepeatNumberByBinary(arr);

    }

    public static void findRepeatNumberByMap(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>(8);
        for (int value : arr) {
            if (countMap.containsKey(value)) {
                System.out.println(value);
            } else {
                countMap.put(value, 1);
            }
        }
    }

    public static void findRepeatNumberByCompare(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //自身与下标比较,相等则跳过
            if (arr[i] != i) {
                //与交换位比较
                if (arr[i] != arr[arr[i]]) {
                    int temp = arr[arr[i]];
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
                } else {
                    System.out.println(arr[i]);
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void findRepeatNumberByBinary(int[] arr) {
        int start = 1;
        int end = arr.length - 1;
        int count, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            count = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] >= start && arr[i] <= mid) {
                    count++;
                }
            }
            //重叠必找到重复
            if (start == end) {
                //本质上是一种映射关系，所以返回二分法中的start
                System.out.println(start);
                break;
            }
            if (count > mid - start + 1) {
                //原数组在前半段次数超过二分长度
                end = mid;
            } else {
                //在后半段
                start = mid + 1;
            }
        }
    }
}
