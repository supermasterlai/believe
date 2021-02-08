package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q4ArrayFind {

    public static void main(String[] args) {
        /**
         * 左小右大
         * 上小下大
         */
        int[][] arr = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(search(arr,11));
    }

    public static boolean search(int[][] arr,int target){
        //起点为左下角(右上角同理)
        int i = arr.length-1;
        int j = 0;
        while (i>=0 && j<= arr[0].length-1){
            System.out.println(arr[i][j]);
            if (arr[i][j] == target){
                return true;
            }
            if (arr[i][j]>target){
                i--;
            }else {
                j++;
            }
        }
        return false;
    }
}
