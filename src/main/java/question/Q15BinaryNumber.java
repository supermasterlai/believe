package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q15BinaryNumber {

    public static void main(String[] args) {
        /**
         * 位运算
         * 二进制中1的个数(负数+0+正数)
         */
        System.out.println(count1(-9));
    }

    public static int count1(int n) {
        int count = 0;
        if (n < 0) {
            n = -n;
            count++;
        }
        while (n != 0) {
            count++;
            //与运算（n,n-1）消除最右边的1,直接跳过0
            n &= n - 1;
        }
        return count;
    }
}
