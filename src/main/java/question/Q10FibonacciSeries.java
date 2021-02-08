package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q10FibonacciSeries {

    public static void main(String[] args) {

        /**
         * fibonacci递归，缺陷->计算n-1和n都计算到了n-2;调用栈过深
         */
        System.out.println(getFibonacciData1(10));

        /**
         * 循环，避免重复计算(45=1134903170；46=1836311903 ；47溢出调整为long)
         */
        System.out.println(getFibonacciData2(47));

        /**
         * 青蛙跳台阶
         */
        System.out.println(getFrogJump(47));
    }

    public static Long getFibonacciData1(int n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        return getFibonacciData1(n - 1) + getFibonacciData1(n - 2);
    }

    public static Long getFibonacciData2(int n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        long before1 = 1L;
        long before2 = 0L;
        long data = 0L;
        for (int i = 2; i <= n; i++) {
            data = before1 + before2;
            before2 = before1;
            before1 = data;
        }
        return data;
    }

    public static Long getFrogJump(int n) {
        if (n <= 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        if (n == 2) {
            return 2L;
        }
        long before1 = 2;
        long before2 = 1;
        long count = 0;
        for (int i = 3; i <= n; i++) {
            count = before1 + before2;
            before2 = before1;
            before1 = count;
        }
        return count;
    }
}
