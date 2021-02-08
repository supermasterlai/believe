package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q19Regex {

    public static void main(String[] args) {
        /**
         * Q19 正则表达式 . 和 *  校验字符串完全匹配
         *
         * 分析：递归或者动态规划，都存在重复子问题
         * 1.aaa a.a 没有*每次前进一位 i+1 j+1
         * 2.aaa a* *匹配多次 i+1 j不变
         * 3.aaa b*aa *匹配0次 i不变 j+2
         * 4.aaa aaa* *匹配一次 i+1 j+2 可分解为（1）i+1 j不变 （2） i不变 j+2
         */
//         System.out.println(isMatchRegex("aaa", "a.a"));
//        System.out.println(isMatchRegex("aaa", "a*"));
//         System.out.println(isMatchRegex("aaa", "b*aaa"));
        System.out.println(isMatchRegex("aaa", "aaa*"));
    }

    /**
     * 递归
     */
    public static boolean isMatchRegex(String origin, String matcher) {
        char[] originArr = origin.toCharArray();
        char[] matcherArr = matcher.toCharArray();
        if (originArr.length == 0 && matcherArr.length == 0) {
            return true;
        }
        if (originArr.length != 0 && matcherArr.length == 0) {
            return false;
        }
        return matchCore(originArr, matcherArr, 0, 0);
//        return matchCore2(originArr, matcherArr);
    }

    private static boolean matchCore(char[] originArr, char[] matcherArr, int i, int j) {
        //最终都会到length位置，所以用==判断
        if (j == matcherArr.length) {
            //刚好完全匹配t否则f
            return i == originArr.length;
        }
        if (j < matcherArr.length - 1 && matcherArr[j + 1] == '*') {
            //1后面是*的情况
            //1.1第一个字符匹配，后面是*
            if (i!= originArr.length && originArr[i] == matcherArr[j] || matcherArr[j] == '.') {
                System.out.println(1.1 + "");
                return matchCore(originArr, matcherArr, i + 1, j) || matchCore(originArr, matcherArr, i, j + 2);
            } else {
                //1.2第一个字符不匹配，后面是*
                System.out.println(1.2 + "");
                //字符串已经结束但是正则未结束,剩余正则只能为a*这种成对出现格式,此时也应跳跃2位
                return matchCore(originArr, matcherArr, i, j + 2);
            }
        } else {
            //2后面不是*的情况
            //2.1第一个字符匹配，后面不是*
            if (originArr[i] == matcherArr[j] || matcherArr[j] == '.') {
                System.out.println(2.1);
                return matchCore(originArr, matcherArr, i + 1, j + 1);
            } else {
                //2.2第一个字符不匹配，后面也不是*
                System.out.println(2.2);
                return false;
            }
        }
    }

    /**
     * 动态规划，从dp[ij]->dp[00]
     */
    private static boolean matchCore2(char[] originArr, char[] matcherArr) {
        //定义二维数组保存每一步结果,
        boolean[][] dp = new boolean[originArr.length + 1][matcherArr.length + 1];
        //初始值
        dp[originArr.length][matcherArr.length] = true;
        for (int i = originArr.length; i >= 0; i--) {
            //空正则不与非空字符串匹配
            for (int j = matcherArr.length - 1; j >= 0; j--) {
                //判断后面是不是*
                if (j < matcherArr.length - 1 && matcherArr[j + 1] == '*') {
                    //当前字符是否匹配
                    if (i != originArr.length && (originArr[i] == matcherArr[j] || matcherArr[j] == '.')) {
                        dp[i][j] = dp[i][j + 2] || dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i][j + 2];
                    }
                } else {
                    if (i != originArr.length && (originArr[i] == matcherArr[j] || matcherArr[j] == '.')) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        //可省略
                        dp[i][j] = false;
                    }
                }
                System.out.println(i + "/" + j + dp[i][j]);
            }
        }
        return dp[0][0];
    }
}
