package question;

/**
 * @author masterlai
 * @since 2021/2/8
 */
public class Q26TreeSimilar {

    public static void main(String[] args) {
        /**
         * 判断二叉树B是不是A的子结构
         */
        BinaryTreeNode rootA = new BinaryTreeNode(8);
        BinaryTreeNode node1A = new BinaryTreeNode(8);
        BinaryTreeNode node2A = new BinaryTreeNode(7);
        rootA.left = node1A;
        rootA.right = node2A;
        BinaryTreeNode node3A = new BinaryTreeNode(9);
        node1A.left = node3A;
        BinaryTreeNode rootB = new BinaryTreeNode(8);
        BinaryTreeNode node1B = new BinaryTreeNode(9);
        rootB.left = node1B;
        System.out.println(treeSimilar(rootA, rootB));
    }

    public static boolean treeSimilar(BinaryTreeNode treeA, BinaryTreeNode treeB) {
        if (null == treeA || null==treeB ){
            return false;
        }
        if (treeA.data == treeB.data) {
            boolean result = hasSub(treeA, treeB);
            //如果A的根节点不满足，则选择左子树或者右子树任一分支
            if (!result){
                result = treeSimilar(treeA.left, treeB) || treeSimilar(treeA.right, treeB);
            }
            return result;
        }
        return false;
    }

    private static boolean hasSub(BinaryTreeNode treeA, BinaryTreeNode treeB) {
        //A必须大于等于B（B为子树）
        if (null == treeB) {
            return true;
        }
        if (null == treeA) {
            return false;
        }
        if (treeA.data != treeB.data) {
            return false;
        }
        return hasSub(treeA.left, treeB.left) && hasSub(treeA.right, treeB.right);
    }
}
