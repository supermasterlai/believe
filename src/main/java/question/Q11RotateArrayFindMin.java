package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q11RotateArrayFindMin {

    public static void main(String[] args) {
        /**
         * 旋转递增数组取最小,二分查找
         * 1.如果旋转了至少一个元素，则a[0]>a[length-1]
         * 2.如果旋转了0个元素或者全部旋转，则最小元素为a[0]
         * 3.首中尾元素相等，无法分段查找
         * 4.首尾相等，走一般逻辑
         */
        int[] rotateArr = {2,3,4,5,1};
        //   int[] rotateArr = {1,2,3,4,5};
        //int[] rotateArr = {1, 0, 1, 1, 1};
        //     int[] rotateArr = {1, 1, 0, 1, 1};
        int result;
        if (rotateArr == null) {
            System.out.println("输入数组不能为null");
        }
        if (rotateArr.length == 1) {
            result = 0;
        }
        result = findRotateMin(rotateArr);
        System.out.println("最小值数组下标：" + result);
    }

    public static int findRotateMin(int[] rotateArr) {
        int mid = (rotateArr.length - 1) / 2;
        int low = 0;
        int high = rotateArr.length - 1;
        //结束条件为首元素小于尾元素，即旋转了0个元素，最小值为rotateArr[0]
        while (rotateArr[low] >= rotateArr[high]) {
            //指针相邻则最小值为high
            if (low == high - 1) {
                return high;
            }
            //首中尾相等时无法压缩范围，只能顺序查找
            if (rotateArr[mid] == rotateArr[low] && rotateArr[mid] == rotateArr[high]) {
                int min = 0;
                for (int i = 1; i < rotateArr.length; i++) {
                    if (rotateArr[i] < rotateArr[min]) {
                        min = i;
                    }
                }
                return min;
            }
            //中间元素大于开始元素则说明mid处于前段，最小元素必然在后段
            if (rotateArr[mid] >= rotateArr[low]) {
                low = mid;
            }
            //已经处于后段，则降低high压缩范围
            if (rotateArr[mid] <= rotateArr[high]) {
                high = mid;
            }
            mid = (low + high) / 2;
        }
        return 0;
    }
}
