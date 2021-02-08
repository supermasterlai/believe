package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q28BinaryTreeSymmetric {

    public static void main(String[] args) {
        /**
         * 判断二叉树是否对称
         * A 镜像遍历与之前序列相同
         * B 自定义一种前序遍历（先右后左）
         *
         *    8
         *  6   6
         * 5 7  7 5
         */
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node1 = new BinaryTreeNode(6);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        root.left = node1;
        root.right = node2;
        BinaryTreeNode node3 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        node1.left = node3;
        node1.right = node4;
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(5);
        node2.left = node5;
        node2.right = node6;
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(BinaryTreeNode tree){
        if (null == tree){
            return false;
        }
        if (tree.left == null && tree.right == null){
            return true;
        }
        return isSymmetric(tree,tree);
    }

    private static boolean isSymmetric(BinaryTreeNode tree,BinaryTreeNode treeBak){
        //都到了叶子
        if (tree == null && treeBak == null){
            return true;
        }
        //只有其中一个到了叶子
        if (tree == null || treeBak == null){
            return false;
        }
        //比较节点值
        if (tree.data != treeBak.data){
            return false;
        }
        //递归对称比较
        return isSymmetric(tree.left, treeBak.right) && isSymmetric(tree.right, treeBak.left);
    }
}
