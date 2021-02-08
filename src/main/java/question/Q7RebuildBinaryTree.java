package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q7RebuildBinaryTree {

    public static void main(String[] args) {
        /**
         * 输入先序和中序，重构树
         */
        int[] preArr = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] midArr = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode tree = rebuildTree(preArr, midArr);
        preTraverse(tree);
    }

    public static BinaryTreeNode rebuildTree(int[] preArr, int[] midArr) {
        if (preArr.length == 1) {
            return new BinaryTreeNode(preArr[0]);
        }
        return rebuild(preArr, midArr, 0, preArr.length - 1, 0, midArr.length - 1);
    }

    private static BinaryTreeNode rebuild(int[] preArr, int[] midArr, int preStart, int preEnd, int midStart, int midEnd) {
        //先序遍历[preStart]找root
        BinaryTreeNode root = new BinaryTreeNode(preArr[preStart]);
        //遍历中序找左右子树
        int mid = 0;
        for (int i = midStart; i <= midEnd; i++) {
            if (midArr[i] == root.data) {
                mid = i;
            }
        }
        //子树递归
        if (mid > midStart) {
            root.left = rebuild(preArr, midArr, preStart + 1, preStart + (mid - midStart), midStart, mid - 1);
        }
        if (mid < midEnd) {
            root.right = rebuild(preArr, midArr, preEnd - (midEnd - mid) + 1, preEnd, mid + 1, midEnd);
        }
        return root;
    }

    public static void preTraverse(BinaryTreeNode tree) {
        if (tree != null) {
            System.out.println(tree.data);
            preTraverse(tree.left);
            preTraverse(tree.right);
        }
    }

}

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}
