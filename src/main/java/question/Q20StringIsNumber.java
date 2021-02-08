package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q20StringIsNumber {

    public static void main(String[] args) {
        /**
         * 判断字符串是否数值（+100 -100 5e2 3.14 -1E-16 ）
         */
        System.out.println(stringIsNumber("-1E.16"));
    }

    public static boolean stringIsNumber(String target) {
        if (target == null || target.length() == 0) {
            return false;
        }
        char[] targetArr = target.toCharArray();
        int pointSplit = -1;
        boolean pointFlag = false;
        int eSplit = -1;
        boolean eFlag = false;
        for (int i = 0; i <= targetArr.length - 1; i++) {
            //切割.e 只能出现一次
            if (targetArr[i] == '.') {
                if (pointFlag) {
                    return false;
                }
                pointSplit = i;
                pointFlag = true;
            }
            if (targetArr[i] == 'e' || targetArr[i] == 'E') {
                if (eFlag) {
                    return false;
                }
                eSplit = i;
                eFlag = true;
            }
        }
        //1没有e
        if (eSplit == -1) {
            //1.1没有e .  +12 -10 56
            if (pointSplit == -1) {
                return charsIsNumber(true, targetArr, 0, targetArr.length - 1);
            } else {
                //1.2没有e有. -12.3  66.  .12
                if (pointSplit == 0) {
                    return charsIsNumber(false, targetArr, pointSplit + 1, targetArr.length - 1);
                }
                if (pointSplit == targetArr.length - 1) {
                    return charsIsNumber(true, targetArr, 0, pointSplit - 1);
                }
                return charsIsNumber(true, targetArr, 0, pointSplit - 1) && charsIsNumber(false, targetArr, pointSplit + 1, targetArr.length - 1);
            }
        } else {
            // e15  15e
            if (eSplit == 0 || eSplit == targetArr.length - 1) {
                return false;
            }
            //2.1 有e 没有.
            if (pointSplit == -1) {
                //有e   1e5   -12e-5 -12e5x1
                return charsIsNumber(true, targetArr, 0, eSplit - 1) && charsIsNumber(true, targetArr, eSplit + 1, targetArr.length - 1);
            } else {
                //2.2有e . 点一定要在e前面 -12e5.1(指数不能为小数)
                if (pointSplit > eSplit) {
                    return false;
                }
                //12.e6
                if (pointSplit + 1 == eSplit) {
                    return charsIsNumber(true, targetArr, 0, pointSplit - 1) && charsIsNumber(true, targetArr, eSplit + 1, targetArr.length - 1);
                }
                // +12.2e-2
                return charsIsNumber(true, targetArr, 0, pointSplit - 1) && charsIsNumber(false, targetArr, pointSplit + 1, eSplit - 1) && charsIsNumber(true, targetArr, eSplit + 1, targetArr.length - 1);
            }
        }
    }

    private static boolean charsIsNumber(boolean hasSign, char[] chars, int start, int end) {
        //整数部分的正负号只能出现在起始位置
        int i = start;
        if (hasSign) {
            if (chars[0] == '+' || chars[0] == '-') {
                i++;
            }
        }
        for (; i <= end; i++) {
            //如果不在0-9范围则false
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
