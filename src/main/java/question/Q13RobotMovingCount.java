package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q13RobotMovingCount {

    public static void main(String[] args) {
        /**
         * 机器人在（m * n）矩阵移动，不能进入坐标位数之和>k的位置
         * 问能到达的位置总和
         * 回溯法-> 跟矩阵路径不同的是不需要回退
         */
        try {
            System.out.println(countRobotMoving(50, 60, 18));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static int countRobotMoving(int m, int n, int k) throws Exception {
        if (k<0){
            throw new Exception("k必须大于0！");
        }
        //历史轨迹标志
        boolean[][] flagMatrix = new boolean[m][n];
        return cross(0, 0, m, n, flagMatrix, k);
    }

    private static int cross(int i, int j, int m, int n, boolean[][] flagMatrix, int k) {
        int count = 0;
        //判断是否有下一位置可走
        if (i <= m - 1 && i >= 0 && j <= n - 1 && j >= 0 && getSumByIndex(i) + getSumByIndex(j) <= k && !flagMatrix[i][j]) {
            //标记走过的位置
            flagMatrix[i][j] = true;
            //递归前后左右
            count = 1 + cross(i - 1, j, m, n, flagMatrix, k) + cross(i + 1, j, m, n, flagMatrix, k) + cross(i, j - 1, m, n, flagMatrix, k) + cross(i, j + 1, m, n, flagMatrix, k);
        }
        return count;
    }

    private static int getSumByIndex(int index) {
        int sum = 0;
        while (index > 0) {
            sum += index % 10;
            index /= 10;
        }
        return sum;
    }
}
