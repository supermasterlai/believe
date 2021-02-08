package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q16PowerFunction {

    public static void main(String[] args) {
        /**
         * 实现base的exponent;
         * 指数可能为负数
         * 递归计算1-2-4-8-16 时间O(㏒n)
         */
        System.out.println(pow(-2, 3));
    }

    public static double pow(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent>0){
            return getPower(base, exponent);
        }else {
            exponent = -exponent;
            return 1.0/getPower(base, exponent);
        }
    }

    public static double getPower(double base, int exponent) {
        //1->2->4->...
        if (exponent == 1) {
            return base;
        }
        double result = getPower(base, exponent >> 1);
        result *= result;
        //如果exponent为奇数，第一次右移会丢失一次计算（int 5>>1 = 2）
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }
}
