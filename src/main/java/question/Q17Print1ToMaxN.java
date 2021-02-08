package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q17Print1ToMaxN {

    public static void main(String[] args) throws Exception {
        /**
         * 打印1-最大的n位数
         * 主要问题在于可能越界（10的int.MAX次方）
         */
        print1ToMaxN(2);
    }

    public static void print1ToMaxN(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("n必须大于0！");
        }
        //初始0，然后模拟递增
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i <= n - 1; i++) {
            stringBuilder.append('0');
        }
//        //判断没有超过最大的n位数n
//        while (!increment(stringBuilder)) {
//          printMaxN(stringBuilder);
//        }
        /**
         * 递归从左往右设置每一位
         * 时间 O(n)
         */
        for (int i = 0; i <=9 ; i++) {
            stringBuilder.setCharAt(0,(char) (i+'0'));
            printByRecursion(stringBuilder,n,0);
        }

    }

    private static void printByRecursion(StringBuilder stringBuilder,int n ,int index){
        //最后一位直接打印整个字符串
        if (index == n-1){
            printMaxN(stringBuilder);
            return;
        }
        for (int i = 0; i <=9 ; i++) {
            stringBuilder.setCharAt(index+1,(char) (i+'0'));
            printByRecursion(stringBuilder,n,index+1);
        }
    }

    private static boolean increment(StringBuilder stringBuilder) {
        boolean isOverFlow = false;
        int nTakeOver = 0;
        for (int i = stringBuilder.length() - 1; i >= 0; i--) {
            //当前字符与‘0’的偏移
            int offset = (stringBuilder.charAt(i) - '0' )+ nTakeOver;
            //最后一位递增
            if (i == stringBuilder.length() - 1) {
                offset++;
            }
            if (offset < 10) {
                stringBuilder.setCharAt(i, (char) ('0' + offset));
                break;
            } else {
                //10进1，最高位越界
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    nTakeOver = 1;
                    offset -= 10;
                    stringBuilder.setCharAt(i, (char) ('0' + offset));
                }
            }
        }
        return isOverFlow;
    }

    private static void printMaxN(StringBuilder stringBuilder){
        //多余的0不显示
        boolean allZeroFlag = true;
        int start = 0;
        for (int i = 0; i <= stringBuilder.length() - 1; i++) {
            //从左往右找到第一个不为0的下标
            if (stringBuilder.charAt(i) != '0') {
                start = i;
                allZeroFlag = false;
                break;
            }
        }
        if (!allZeroFlag) {
            System.out.println(stringBuilder.toString().substring(start, stringBuilder.length()));
        }
    }
}
