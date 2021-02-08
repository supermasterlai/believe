package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q21ChangeOddAndEven {

    public static void main(String[] args) {
        /**
         * 一个整数数组，实现奇数在前半段，偶数在后半段
         *  A 遍历一边，取出所有奇数放新数组0-> 偶数往前放<-length-1 时间O（n）空间O（n）
         *  B 两个指针往中间移动 时间O（n）空间O（1）
         */
        int[] arr = {1, 3, 9, 2, 5, 8, 4, 6, 7};
        changeOrder(arr);
        for (int value : arr) {
            System.out.print(value + "  ");
        }
    }

    private static void changeOrder(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            //从左找第一个偶数
            while (start < end && (arr[start] & 1) != 0) {
                start++;
            }
            //从右往左找第一个奇数
            while (start < end && (arr[end] & 1) != 1) {
                end--;
            }
            //交换
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}
