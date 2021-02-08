package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q14CutRopeMaxProduct {
    public static void main(String[] args) {
        /**
         * 长度为n>1的绳子，剪成m>1段，问最大乘积(都是整数)
         * 动态规划-> 自下而上计算 时间 O(n²) 空间 O(n)
         * 贪婪算法-> 每步最优则结局最优 O(1)
         */
        try {
            System.out.println(getMaxProduct2(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getMaxProduct1(int n) throws Exception {
        if (n <= 1) {
            throw new Exception("n必须为大于1的整数！");
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long[] computeArr = new long[n+1];
        //基础数值
        computeArr[1] = 1;
        computeArr[2] = 2;
        computeArr[3] = 3;
        long maxProduct;
        for (int i = 4; i <= n; i++) {
            maxProduct = 1L;
            //计算所有可能情况下的乘积,i/2与后一半相等
            for (int j = 1; j <=i/2 ; j++) {
                long product = computeArr[j]*computeArr[i-j];
                if (maxProduct<product){
                    maxProduct = product;
                }
                computeArr[i] = maxProduct;
            }
        }
        return computeArr[n];
    }

    public static long getMaxProduct2(int n) throws Exception {
        if (n <= 1) {
            throw new Exception("n必须为大于1的整数！");
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        //当>=5时,每次取3;当<5时，尽可能取2
        int timesOfThree = n/3;
        //如果最后一段为4
        if (n - 3*timesOfThree == 1 ){
            timesOfThree --;
        }
        int timesOfTwo = (n - 3*timesOfThree)/2;
        return (long) (Math.pow(3,timesOfThree)*Math.pow(2,timesOfTwo));
    }
}
