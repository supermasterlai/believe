package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q5StringReplaceBlank {

    public static void main(String[] args) {
        /**
         * 替换字符串空格，从前往后涉及多次移动，时间O(n²)
         * 计算长度，复制，只需要移动一次O(n)
         */
        String originStr = "we are happy!";
        char[] chars = originStr.toCharArray();
        int spaceCount=0;
//        for (int i = 0; i <chars.length ; i++) {
//            if (Character.isSpaceChar(chars[i])){
//                spaceCount++;
//            }
//        }
//        if (spaceCount == 0){
//            return;
//        }
//        //创建扩容长度的数组
//        int size = chars.length + 2*spaceCount;
//        char[] newChars = new char[size];
        //     int j = size-1;
//        for (int i = chars.length-1; i >=0 ; i--) {
//            if (Character.isSpaceChar(chars[i])){
//                newChars[j--]='0';
//                newChars[j--]='2';
//                newChars[j--]='%';
//            }else {
//                newChars[j--]=chars[i];
//            }
//        }
//        System.out.println(Arrays.toString(newChars));
        /**
         * stringBuilder
         */
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <chars.length ; i++) {
            if (Character.isSpaceChar(chars[i])){
                builder.append("%20");
            }else {
                builder.append(chars[i]);
            }
        }
        System.out.println(builder.toString());
    }
}
