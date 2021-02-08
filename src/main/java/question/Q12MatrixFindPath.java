package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q12MatrixFindPath {

    public static void main(String[] args) {
        /**
         * 在矩阵中判断是否存在路径cdf
         */
        String[][] matrix = {
                {"a", "b", "c"},
                {"b", "c", "d"},
                {"c", "d", "f"},
                {"f", "g", "h"}
        };
        System.out.println(findPath(matrix, "cdf"));
    }

    public static boolean findPath(String[][] matrix, String target) {
        if (null == matrix || matrix.length == 0 || null == target || target.length() == 0) {
            return false;
        }
        boolean[][] flagMatrix = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //递归回溯，关键在于判断下一步可不可行
                if (cross(i, j, 1, target, matrix, flagMatrix)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean cross(int i, int j, int targetEndIndex, String target, String[][] matrix, boolean[][] flagMatrix) {
        if (targetEndIndex > target.length()) {
            return false;
        }
        //终止条件(数组越界，前后左右字符不匹配，已经走过)
        if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1 || !matrix[i][j].equals(target.substring(targetEndIndex - 1, targetEndIndex)) || flagMatrix[i][j]) {
            return false;
        }
        System.out.println("行：" + (i + 1) + "****" + "列：" + (j + 1));
        //走到字符串结尾则存在
        if (targetEndIndex == target.length()) {
            return true;
        }
        //找到起点,并标记走过的路不能回退
        flagMatrix[i][j] = true;
        //向前后左右延伸,任一路可走则继续查找
        if (cross(i - 1, j, targetEndIndex +1, target, matrix, flagMatrix)){
            System.out.println("↑");
            return true;
        }
        if (cross(i + 1, j, targetEndIndex +1, target, matrix, flagMatrix)){
            System.out.println("↓");
            return true;
        }
        if (cross(i, j - 1, targetEndIndex +1, target, matrix, flagMatrix)){
            System.out.println("←");
            return true;
        }
        if (cross(i, j + 1, targetEndIndex +1, target, matrix, flagMatrix)){
            System.out.println("→");
            return true;
        }
        //回退
        flagMatrix[i][j] = false;
        return false;
    }
}
